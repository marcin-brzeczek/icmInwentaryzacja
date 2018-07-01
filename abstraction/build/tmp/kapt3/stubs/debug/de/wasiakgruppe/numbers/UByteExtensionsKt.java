package de.wasiakgruppe.numbers;

import java.lang.System;

@kotlin.Suppress(names = {"NOTHING_TO_INLINE", "unused"})
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\u0002\u001a\u00020\nH\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u000e\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u000e\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u000e\u001a\r\u0010\r\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u000e\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u000e\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u000e\u001a\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\nH\u0086\u000e\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u000e\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u000e\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u000e\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u000e\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u000e\u001a\u0015\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\u000e\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0017H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0006H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0018H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0019H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u001aH\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u001bH\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u001cH\u0086\b\u001a\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\f\u001a\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\f\u00a8\u0006\u001f"}, d2 = {"ubyte", "Lde/wasiakgruppe/numbers/UByte;", "value", "", "and", "other", "", "checkRange", "", "Lde/wasiakgruppe/numbers/UByte$Companion;", "", "dec", "div", "inc", "minus", "or", "plus", "rem", "shl", "bits", "shr", "times", "toUByte", "Lde/wasiakgruppe/numbers/UShort;", "", "", "", "", "", "ushr", "xor", "abstraction_debug"})
public final class UByteExtensionsKt {
    
    /**
     * Simple creator of the `unsigned byte` with given [value]. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte ubyte(int value) {
        return null;
    }
    
    /**
     * Adds the [other] value to this value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte plus(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.Number other) {
        return null;
    }
    
    /**
     * Adds the [other] value to this value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte plus(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int other) {
        return null;
    }
    
    /**
     * Subtracts the [other] value from this value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte minus(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte other) {
        return null;
    }
    
    /**
     * Subtracts the [other] value from this value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte minus(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, byte other) {
        return null;
    }
    
    /**
     * Subtracts the [other] value from this value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte minus(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int other) {
        return null;
    }
    
    /**
     * Multiplies this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte times(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte other) {
        return null;
    }
    
    /**
     * Multiplies this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte times(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, byte other) {
        return null;
    }
    
    /**
     * Multiplies this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte times(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int other) {
        return null;
    }
    
    /**
     * Divides this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte div(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte other) {
        return null;
    }
    
    /**
     * Divides this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte div(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, byte other) {
        return null;
    }
    
    /**
     * Divides this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte div(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int other) {
        return null;
    }
    
    /**
     * Calculates the remainder of dividing this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte rem(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte other) {
        return null;
    }
    
    /**
     * Calculates the remainder of dividing this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte rem(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, byte other) {
        return null;
    }
    
    /**
     * Calculates the remainder of dividing this value by the [other] value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte rem(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int other) {
        return null;
    }
    
    /**
     * Performs a bitwise AND operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte and(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte other) {
        return null;
    }
    
    /**
     * Performs a bitwise AND operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte and(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, byte other) {
        return null;
    }
    
    /**
     * Performs a bitwise AND operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte and(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int other) {
        return null;
    }
    
    /**
     * Performs a bitwise OR operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte or(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte other) {
        return null;
    }
    
    /**
     * Performs a bitwise OR operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte or(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, byte other) {
        return null;
    }
    
    /**
     * Performs a bitwise OR operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte or(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int other) {
        return null;
    }
    
    /**
     * Performs a bitwise XOR operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte xor(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte other) {
        return null;
    }
    
    /**
     * Performs a bitwise XOR operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte xor(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, byte other) {
        return null;
    }
    
    /**
     * Performs a bitwise XOR operation between the two values. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte xor(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int other) {
        return null;
    }
    
    /**
     * Shifts this value left by [bits]. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte shl(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int bits) {
        return null;
    }
    
    /**
     * Shifts this value right by [bits], filling the leftmost bits with zeros. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte shr(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int bits) {
        return null;
    }
    
    /**
     * Shifts this value right by [bits], filling the leftmost bits with zeros. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte ushr(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver, int bits) {
        return null;
    }
    
    /**
     * Increments this value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte inc(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver) {
        return null;
    }
    
    /**
     * Decrements this value. 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte dec(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte $receiver) {
        return null;
    }
    
    /**
     * Converts number to UByte (`unsigned Byte`) 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte toUByte(byte $receiver) {
        return null;
    }
    
    /**
     * Converts number to UByte (`unsigned Byte`) 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte toUByte(short $receiver) {
        return null;
    }
    
    /**
     * Converts number to UByte (`unsigned Byte`) 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte toUByte(int $receiver) {
        return null;
    }
    
    /**
     * Converts number to UByte (`unsigned Byte`) 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte toUByte(long $receiver) {
        return null;
    }
    
    /**
     * Converts number to UByte (`unsigned Byte`) 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte toUByte(float $receiver) {
        return null;
    }
    
    /**
     * Converts number to UByte (`unsigned Byte`) 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte toUByte(double $receiver) {
        return null;
    }
    
    /**
     * Converts number to UByte (`unsigned Byte`) 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte toUByte(@org.jetbrains.annotations.NotNull()
    java.lang.String $receiver) {
        return null;
    }
    
    /**
     * Converts number to UByte (`unsigned Byte`) 
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.numbers.UByte toUByte(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UShort $receiver) {
        return null;
    }
    
    public static final boolean checkRange(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.numbers.UByte.Companion $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.Number value) {
        return false;
    }
}