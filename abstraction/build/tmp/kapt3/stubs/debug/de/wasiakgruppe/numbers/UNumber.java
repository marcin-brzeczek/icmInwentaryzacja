package de.wasiakgruppe.numbers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0016"}, d2 = {"Lde/wasiakgruppe/numbers/UNumber;", "", "Ljava/io/Serializable;", "()V", "toBigInteger", "Ljava/math/BigInteger;", "toByte", "", "toChar", "", "toDouble", "", "toFloat", "", "toInt", "", "toLong", "", "toShort", "", "toString", "", "abstraction_debug"})
public abstract class UNumber extends java.lang.Number implements java.io.Serializable {
    
    @org.jetbrains.annotations.NotNull()
    public java.math.BigInteger toBigInteger() {
        return null;
    }
    
    @java.lang.Override()
    public abstract byte toByte();
    
    @java.lang.Override()
    public final byte byteValue() {
        return 0;
    }
    
    @java.lang.Override()
    public abstract char toChar();
    
    @java.lang.Override()
    public abstract short toShort();
    
    @java.lang.Override()
    public final short shortValue() {
        return 0;
    }
    
    @java.lang.Override()
    public abstract int toInt();
    
    @java.lang.Override()
    public final int intValue() {
        return 0;
    }
    
    @java.lang.Override()
    public abstract long toLong();
    
    @java.lang.Override()
    public final long longValue() {
        return 0L;
    }
    
    @java.lang.Override()
    public abstract float toFloat();
    
    @java.lang.Override()
    public final float floatValue() {
        return 0.0F;
    }
    
    @java.lang.Override()
    public abstract double toDouble();
    
    @java.lang.Override()
    public final double doubleValue() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public abstract java.lang.String toString();
    
    public UNumber() {
        super();
    }
}