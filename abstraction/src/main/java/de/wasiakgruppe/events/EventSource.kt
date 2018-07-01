package de.wasiakgruppe.events

import java.util.concurrent.ConcurrentHashMap
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@Deprecated("Use EventSource", ReplaceWith("EventSource<T>()", "de.wasiakgruppe.events.EventSource"))
fun <T : Any> EventHandler(): EventSource<T> = EventSourceImpl<T>()

fun <T : Any> EventSource(): EventSource<T> = EventSourceImpl<T>()

object EmptyEventArguments

class PropertyChangedArguments<out S : Any?, out T : Any?>(val propertyName: String, val oldValue: T, val newValue: T, val sender: S? = null)

interface Event<out EventArguments : Any> {
    operator fun plusAssign(reaction: (EventArguments) -> Unit)
    operator fun minusAssign(reaction: (EventArguments) -> Unit)
}

interface EventSource<T : Any> {
    operator fun invoke(arguments: T)
    fun event(): ReadOnlyProperty<Any?, Event<T>>
}

inline operator fun <T : Any> Event<T>.getValue(thisRef: Any?, property: KProperty<*>): Event<T> = this

fun <TArgument : Any?, TValue : TArgument> EventSource<PropertyChangedArguments<Any?, TArgument>>.observable(initialValue: TValue): ReadWriteProperty<Any?, TValue>
        = object : ObservableProperty<TValue>(initialValue) {
    override fun afterChange(property: KProperty<*>, oldValue: TValue, newValue: TValue) {
        if (oldValue !== newValue) this@observable.invoke(PropertyChangedArguments(property.name, oldValue, newValue))
    }
}

private class SealedEvent<T : Any> : Event<T>, ReadOnlyProperty<Any?, Event<T>> {
    internal val listeners = ConcurrentHashMap<Any, (T) -> Unit>()

    override operator fun plusAssign(reaction: (T) -> Unit) {
        listeners.put(reaction, reaction)
    }

    override operator fun minusAssign(reaction: (T) -> Unit) {
        listeners.remove(reaction)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): Event<T> = this
}

private class EventSourceImpl<E : Any> : EventSource<E> {
    private val _event: SealedEvent<E> = SealedEvent()

    override fun event() = _event

    override fun invoke(arguments: E) = _event.listeners.forEach { it.value.invoke(arguments) }
}