package de.wasiakgruppe.ann.abstraction.unitconverter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005R2\u0010\u0003\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/unitconverter/UnitConverter;", "", "()V", "converters", "", "Lde/wasiakgruppe/ann/abstraction/domain/MeasurementUnit;", "Lkotlin/Function1;", "", "canConvert", "", "from", "to", "convert", "Lde/wasiakgruppe/ann/abstraction/domain/RangeMeasure;", "toUnit", "Lde/wasiakgruppe/ann/abstraction/domain/ValueMeasure;", "registerConversion", "", "conversion", "tryConvert", "abstraction_debug"})
public final class UnitConverter {
    private static final java.util.Map<de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit, java.util.Map<de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit, kotlin.jvm.functions.Function1<java.lang.Float, java.lang.Float>>> converters = null;
    public static final de.wasiakgruppe.ann.abstraction.unitconverter.UnitConverter INSTANCE = null;
    
    public final boolean canConvert(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit from, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit to) {
        return false;
    }
    
    private final void registerConversion(de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit from, de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit to, kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float> conversion) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.wasiakgruppe.ann.abstraction.domain.ValueMeasure convert(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.ValueMeasure from, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit toUnit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.wasiakgruppe.ann.abstraction.domain.RangeMeasure convert(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.RangeMeasure from, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit toUnit) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final de.wasiakgruppe.ann.abstraction.domain.ValueMeasure tryConvert(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.ValueMeasure from, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit toUnit) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final de.wasiakgruppe.ann.abstraction.domain.RangeMeasure tryConvert(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.RangeMeasure from, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit toUnit) {
        return null;
    }
    
    private UnitConverter() {
        super();
    }
}