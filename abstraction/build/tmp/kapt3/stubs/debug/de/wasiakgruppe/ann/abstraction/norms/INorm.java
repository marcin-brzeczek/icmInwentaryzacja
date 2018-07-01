package de.wasiakgruppe.ann.abstraction.norms;

import java.lang.System;

/**
 * * Norm that can validate a measure.
 * *
 * * @param <in M : Measure> the type of measure used for this norm
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J%\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/norms/INorm;", "M", "Lde/wasiakgruppe/ann/abstraction/domain/Measure;", "", "acceptsUnit", "", "unit", "Lde/wasiakgruppe/ann/abstraction/domain/MeasurementUnit;", "isValid", "measure", "profile", "Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo;", "throwExceptionOnUnitMismatch", "(Lde/wasiakgruppe/ann/abstraction/domain/Measure;Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo;Z)Z", "abstraction_debug"})
public abstract interface INorm<M extends de.wasiakgruppe.ann.abstraction.domain.Measure> {
    
    /**
     * @return true if this norm accepts given measurement unit 
     */
    public abstract boolean acceptsUnit(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit unit);
    
    /**
     * @return true if given measure is valid 
     */
    public abstract boolean isValid(@org.jetbrains.annotations.NotNull()
    M measure, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.norms.IPersonInfo profile, boolean throwExceptionOnUnitMismatch);
}