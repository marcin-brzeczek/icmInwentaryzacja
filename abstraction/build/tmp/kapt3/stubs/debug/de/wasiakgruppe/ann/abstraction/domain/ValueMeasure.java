package de.wasiakgruppe.ann.abstraction.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/domain/ValueMeasure;", "Lde/wasiakgruppe/ann/abstraction/domain/Measure;", "Lde/wasiakgruppe/ann/abstraction/interfaces/AnnParcelableLite;", "value", "", "unit", "Lde/wasiakgruppe/ann/abstraction/domain/MeasurementUnit;", "(FLde/wasiakgruppe/ann/abstraction/domain/MeasurementUnit;)V", "getUnit", "()Lde/wasiakgruppe/ann/abstraction/domain/MeasurementUnit;", "getValue", "()F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "abstraction_debug"})
@paperparcel.PaperParcel()
public final class ValueMeasure extends de.wasiakgruppe.ann.abstraction.domain.Measure implements de.wasiakgruppe.ann.abstraction.interfaces.AnnParcelableLite {
    private final float value = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit unit = null;
    @org.jetbrains.annotations.NotNull()
    public static final de.wasiakgruppe.ann.abstraction.domain.ValueMeasure EMPTY = null;
    @org.jetbrains.annotations.NotNull()
    public static final error.NonExistentClass CREATOR = null;
    public static final de.wasiakgruppe.ann.abstraction.domain.ValueMeasure.Companion Companion = null;
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel dest, int flags) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public final float getValue() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit getUnit() {
        return null;
    }
    
    public ValueMeasure(float value, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit unit) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    public final float component1() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.wasiakgruppe.ann.abstraction.domain.ValueMeasure copy(float value, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit unit) {
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
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/domain/ValueMeasure$Companion;", "", "()V", "CREATOR", "error/NonExistentClass", "Lerror/NonExistentClass;", "EMPTY", "Lde/wasiakgruppe/ann/abstraction/domain/ValueMeasure;", "abstraction_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}