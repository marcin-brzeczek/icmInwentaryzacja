package de.wasiakgruppe.events;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lde/wasiakgruppe/events/EventSourceImpl;", "E", "", "Lde/wasiakgruppe/events/EventSource;", "()V", "_event", "Lde/wasiakgruppe/events/SealedEvent;", "event", "invoke", "", "arguments", "(Ljava/lang/Object;)V", "abstraction_debug"})
final class EventSourceImpl<E extends java.lang.Object> implements de.wasiakgruppe.events.EventSource<E> {
    private final de.wasiakgruppe.events.SealedEvent<E> _event = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public de.wasiakgruppe.events.SealedEvent<E> event() {
        return null;
    }
    
    @java.lang.Override()
    public void invoke(@org.jetbrains.annotations.NotNull()
    E arguments) {
    }
    
    public EventSourceImpl() {
        super();
    }
}