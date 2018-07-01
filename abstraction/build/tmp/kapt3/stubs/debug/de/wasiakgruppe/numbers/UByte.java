package de.wasiakgruppe.numbers;

import java.lang.System;

/**
 * * The `unsigned byte` type
 * *
 * * @author Szymon Kraus
 * * @author Karol Stasinski
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lde/wasiakgruppe/numbers/UByte;", "Lde/wasiakgruppe/numbers/UNumber;", "", "", "value", "", "(I)V", "_value", "", "compareTo", "other", "equals", "", "", "hashCode", "toBigInteger", "Ljava/math/BigInteger;", "toByte", "", "toChar", "", "toDouble", "", "toFloat", "", "toInt", "toLong", "", "toShort", "toString", "", "Companion", "abstraction_debug"})
public final class UByte extends de.wasiakgruppe.numbers.UNumber implements java.lang.Comparable<java.lang.Number> {
    
    /**
     * The _value modelling the content of this `unsigned byte` 
     */
    private final short _value = 0;
    
    /**
     * Generated UID 
     */
    private static final long serialVersionUID = -1634613216843254L;
    
    /**
     * Number of bits required to store [UByte] 
     */
    public static final int BITS = 8;
    
    /**
     * Minimum (0x00) bit mask of `unsigned byte` 
     */
    public static final int MIN_VALUE_MASK = 0;
    
    /**
     * Maximum (0xff) bit mask of `unsigned byte` 
     */
    public static final int MAX_VALUE_MASK = 255;
    
    /**
     * Number up to which values are cached (fly-weight pattern implementation) 
     */
    private static final int CACHED_THRESHOLD = 255;
    
    /**
     * Cached values (fly-weight pattern implementation) 
     */
    private static final de.wasiakgruppe.numbers.UByte[] CACHED_VALUES = null;
    
    /**
     * A constant holding the minimum _value an `unsigned byte` can have, 0. 
     */
    @org.jetbrains.annotations.NotNull()
    private static final de.wasiakgruppe.numbers.UByte MIN_VALUE = null;
    
    /**
     * A constant holding the maximum _value an `unsigned byte` can have, 2<sup>8</sup>-1. 
     */
    @org.jetbrains.annotations.NotNull()
    private static final de.wasiakgruppe.numbers.UByte MAX_VALUE = null;
    public static final de.wasiakgruppe.numbers.UByte.Companion Companion = null;
    
    @java.lang.Override()
    public byte toByte() {
        return 0;
    }
    
    @java.lang.Override()
    public char toChar() {
        return '\u0000';
    }
    
    @java.lang.Override()
    public short toShort() {
        return 0;
    }
    
    @java.lang.Override()
    public int toInt() {
        return 0;
    }
    
    @java.lang.Override()
    public long toLong() {
        return 0L;
    }
    
    @java.lang.Override()
    public float toFloat() {
        return 0.0F;
    }
    
    @java.lang.Override()
    public double toDouble() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.math.BigInteger toBigInteger() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int compareTo(@org.jetbrains.annotations.NotNull()
    java.lang.Number other) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    private UByte(int value) {
        super();
    }
    
    @kotlin.Suppress(names = {"unused"})
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lde/wasiakgruppe/numbers/UByte$Companion;", "", "()V", "BITS", "", "CACHED_THRESHOLD", "CACHED_VALUES", "", "Lde/wasiakgruppe/numbers/UByte;", "getCACHED_VALUES", "()[Lde/wasiakgruppe/numbers/UByte;", "[Lde/wasiakgruppe/numbers/UByte;", "MAX_VALUE", "getMAX_VALUE", "()Lde/wasiakgruppe/numbers/UByte;", "MAX_VALUE_MASK", "MIN_VALUE", "getMIN_VALUE", "MIN_VALUE_MASK", "serialVersionUID", "", "getSerialVersionUID", "()J", "valueOf", "value", "abstraction_debug"})
    public static final class Companion {
        
        private final long getSerialVersionUID() {
            return 0L;
        }
        
        private final de.wasiakgruppe.numbers.UByte[] getCACHED_VALUES() {
            return null;
        }
        
        /**
         * Method returning `unsigned byte` representing given value 
         */
        @org.jetbrains.annotations.NotNull()
        public final de.wasiakgruppe.numbers.UByte valueOf(int value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.wasiakgruppe.numbers.UByte getMIN_VALUE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.wasiakgruppe.numbers.UByte getMAX_VALUE() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}