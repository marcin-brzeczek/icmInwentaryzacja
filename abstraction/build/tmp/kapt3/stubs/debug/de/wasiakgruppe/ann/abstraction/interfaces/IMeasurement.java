package de.wasiakgruppe.ann.abstraction.interfaces;

import java.lang.System;

/**
 * This interface describes measurement in our application.
 * *
 * * @param <T> every measurement contains measure inside.
 * * It could be ValueMeasure or RangeMeasure, so measure type must be defined beforehand.
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/interfaces/IMeasurement;", "T", "Lde/wasiakgruppe/ann/abstraction/domain/Measure;", "Lde/wasiakgruppe/ann/abstraction/interfaces/IUniqueEntry;", "device", "Lde/wasiakgruppe/ann/abstraction/interfaces/IDevice;", "getDevice", "()Lde/wasiakgruppe/ann/abstraction/interfaces/IDevice;", "isManual", "", "()Z", "time", "Lorg/joda/time/DateTime;", "getTime", "()Lorg/joda/time/DateTime;", "type", "Lde/wasiakgruppe/ann/abstraction/domain/MeasurementType;", "getType", "()Lde/wasiakgruppe/ann/abstraction/domain/MeasurementType;", "value", "getValue", "()Lde/wasiakgruppe/ann/abstraction/domain/Measure;", "abstraction_debug"})
public abstract interface IMeasurement<T extends de.wasiakgruppe.ann.abstraction.domain.Measure> extends de.wasiakgruppe.ann.abstraction.interfaces.IUniqueEntry {
    
    /**
     * Timestamp which defines when measurement was taken 
     */
    @org.jetbrains.annotations.NotNull()
    public abstract org.joda.time.DateTime getTime();
    
    /**
     * Flag which defines if measurement was created manually, or sent by device 
     */
    public abstract boolean isManual();
    
    /**
     * Actual measure that contains value and measurement unit 
     */
    @org.jetbrains.annotations.NotNull()
    public abstract T getValue();
    
    /**
     * Type of the measurement 
     */
    @org.jetbrains.annotations.NotNull()
    public abstract de.wasiakgruppe.ann.abstraction.domain.MeasurementType getType();
    
    /**
     * Device which sent the measurement. Could be null if measurement was created manually 
     */
    @org.jetbrains.annotations.Nullable()
    public abstract de.wasiakgruppe.ann.abstraction.interfaces.IDevice getDevice();
}