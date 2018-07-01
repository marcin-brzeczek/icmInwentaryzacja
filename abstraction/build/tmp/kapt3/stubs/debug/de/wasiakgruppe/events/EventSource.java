package de.wasiakgruppe.events;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u001c\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H&J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u00a6\u0002\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lde/wasiakgruppe/events/EventSource;", "T", "", "event", "Lkotlin/properties/ReadOnlyProperty;", "Lde/wasiakgruppe/events/Event;", "invoke", "", "arguments", "(Ljava/lang/Object;)V", "abstraction_debug"})
public abstract interface EventSource<T extends java.lang.Object> {
    
    public abstract void invoke(@org.jetbrains.annotations.NotNull()
    T arguments);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.properties.ReadOnlyProperty<java.lang.Object, de.wasiakgruppe.events.Event<T>> event();
}