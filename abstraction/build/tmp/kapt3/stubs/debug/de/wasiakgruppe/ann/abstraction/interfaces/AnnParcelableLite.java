package de.wasiakgruppe.ann.abstraction.interfaces;

import java.lang.System;

/**
 * * This interface is used for every parcelable
 * * model in application. It simplifies model creation
 * * by overriding unused describeContents() method.
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/interfaces/AnnParcelableLite;", "Landroid/os/Parcelable;", "describeContents", "", "abstraction_debug"})
public abstract interface AnnParcelableLite extends android.os.Parcelable {
    
    @java.lang.Override()
    public abstract int describeContents();
    
    /**
     * * This interface is used for every parcelable
     * * model in application. It simplifies model creation
     * * by overriding unused describeContents() method.
     */
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 3)
    public final class DefaultImpls {
        
        @java.lang.Override()
        public static int describeContents(de.wasiakgruppe.ann.abstraction.interfaces.AnnParcelableLite $this) {
            return 0;
        }
    }
}