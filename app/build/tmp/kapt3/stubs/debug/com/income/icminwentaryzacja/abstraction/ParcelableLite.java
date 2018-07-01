package com.income.icminwentaryzacja.abstraction;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/income/icminwentaryzacja/abstraction/ParcelableLite;", "Landroid/os/Parcelable;", "describeContents", "", "app_debug"})
public abstract interface ParcelableLite extends android.os.Parcelable {
    
    @java.lang.Override()
    public abstract int describeContents();
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 3)
    public final class DefaultImpls {
        
        @java.lang.Override()
        public static int describeContents(com.income.icminwentaryzacja.abstraction.ParcelableLite $this) {
            return 0;
        }
    }
}