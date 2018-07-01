package de.wasiakgruppe.events;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0006H\u00a6\u0002J\u001d\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0006H\u00a6\u0002\u00a8\u0006\b"}, d2 = {"Lde/wasiakgruppe/events/Event;", "EventArguments", "", "minusAssign", "", "reaction", "Lkotlin/Function1;", "plusAssign", "abstraction_debug"})
public abstract interface Event<EventArguments extends java.lang.Object> {
    
    public abstract void plusAssign(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super EventArguments, kotlin.Unit> reaction);
    
    public abstract void minusAssign(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super EventArguments, kotlin.Unit> reaction);
}