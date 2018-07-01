package de.wasiakgruppe.time;

import java.lang.System;

@kotlin.Suppress(names = {"NOTHING_TO_INLINE", "UNUSED"})
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lde/wasiakgruppe/time/TimeSpan;", "", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)V", "getDuration", "()J", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "abstraction_debug"})
public final class TimeSpan {
    private final long duration = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.TimeUnit unit = null;
    public static final de.wasiakgruppe.time.TimeSpan.Companion Companion = null;
    
    public final long getDuration() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.TimeUnit getUnit() {
        return null;
    }
    
    public TimeSpan(long duration, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.TimeUnit unit) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.TimeUnit component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.wasiakgruppe.time.TimeSpan copy(long duration, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.TimeUnit unit) {
        return null;
    }
    
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(java.lang.Object p0) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\bJ\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\bJ\u0011\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\bJ\u0011\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\bJ\u0011\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b\u00a8\u0006\u000b"}, d2 = {"Lde/wasiakgruppe/time/TimeSpan$Companion;", "", "()V", "fromDays", "Lde/wasiakgruppe/time/TimeSpan;", "duration", "", "fromHours", "fromMilliseconds", "fromMinutes", "fromSeconds", "abstraction_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final de.wasiakgruppe.time.TimeSpan fromMilliseconds(long duration) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.wasiakgruppe.time.TimeSpan fromSeconds(long duration) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.wasiakgruppe.time.TimeSpan fromMinutes(long duration) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.wasiakgruppe.time.TimeSpan fromHours(long duration) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.wasiakgruppe.time.TimeSpan fromDays(long duration) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}