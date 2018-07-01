package de.wasiakgruppe.events;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00022\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0002J\u001d\u0010\u0010\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\u0096\u0002J\u001d\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\u0096\u0002R,\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lde/wasiakgruppe/events/SealedEvent;", "T", "", "Lde/wasiakgruppe/events/Event;", "Lkotlin/properties/ReadOnlyProperty;", "()V", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function1;", "", "getListeners$abstraction_debug", "()Ljava/util/concurrent/ConcurrentHashMap;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "minusAssign", "reaction", "plusAssign", "abstraction_debug"})
final class SealedEvent<T extends java.lang.Object> implements de.wasiakgruppe.events.Event<T>, kotlin.properties.ReadOnlyProperty<java.lang.Object, de.wasiakgruppe.events.Event<? extends T>> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Object, kotlin.jvm.functions.Function1<T, kotlin.Unit>> listeners = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.ConcurrentHashMap<java.lang.Object, kotlin.jvm.functions.Function1<T, kotlin.Unit>> getListeners$abstraction_debug() {
        return null;
    }
    
    @java.lang.Override()
    public void plusAssign(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> reaction) {
    }
    
    @java.lang.Override()
    public void minusAssign(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> reaction) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public de.wasiakgruppe.events.Event<T> getValue(@org.jetbrains.annotations.Nullable()
    java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property) {
        return null;
    }
    
    public SealedEvent() {
        super();
    }
}