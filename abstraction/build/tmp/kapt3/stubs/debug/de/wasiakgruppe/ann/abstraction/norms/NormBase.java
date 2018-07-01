package de.wasiakgruppe.ann.abstraction.norms;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J#\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010H$\u00a2\u0006\u0002\u0010\u0014R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/norms/NormBase;", "M", "Lde/wasiakgruppe/ann/abstraction/domain/Measure;", "Lde/wasiakgruppe/ann/abstraction/norms/INorm;", "()V", "acceptableUnits", "", "Lde/wasiakgruppe/ann/abstraction/domain/MeasurementUnit;", "getAcceptableUnits", "()Ljava/util/Set;", "acceptsUnit", "", "unit", "isValid", "measure", "profile", "Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo;", "throwExceptionOnUnitMismatch", "(Lde/wasiakgruppe/ann/abstraction/domain/Measure;Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo;Z)Z", "validate", "(Lde/wasiakgruppe/ann/abstraction/domain/Measure;Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo;)Z", "abstraction_debug"})
public abstract class NormBase<M extends de.wasiakgruppe.ann.abstraction.domain.Measure> implements de.wasiakgruppe.ann.abstraction.norms.INorm<M> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Set<de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit> getAcceptableUnits();
    
    protected abstract boolean validate(@org.jetbrains.annotations.NotNull()
    M measure, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.norms.IPersonInfo profile);
    
    @java.lang.Override()
    public final boolean acceptsUnit(@org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.domain.MeasurementUnit unit) {
        return false;
    }
    
    @java.lang.Override()
    public final boolean isValid(@org.jetbrains.annotations.NotNull()
    M measure, @org.jetbrains.annotations.NotNull()
    de.wasiakgruppe.ann.abstraction.norms.IPersonInfo profile, boolean throwExceptionOnUnitMismatch) {
        return false;
    }
    
    public NormBase() {
        super();
    }
}