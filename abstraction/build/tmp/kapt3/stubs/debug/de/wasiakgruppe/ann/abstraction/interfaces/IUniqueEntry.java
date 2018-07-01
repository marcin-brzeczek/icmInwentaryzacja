package de.wasiakgruppe.ann.abstraction.interfaces;

import java.lang.System;

/**
 * Interface describes models that need to be distinct. 
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/interfaces/IUniqueEntry;", "", "id", "Ljava/util/UUID;", "getId", "()Ljava/util/UUID;", "abstraction_debug"})
public abstract interface IUniqueEntry {
    
    /**
     * UUID used to distinguish models 
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.UUID getId();
}