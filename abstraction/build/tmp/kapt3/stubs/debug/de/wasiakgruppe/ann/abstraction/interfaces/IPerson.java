package de.wasiakgruppe.ann.abstraction.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/interfaces/IPerson;", "Lde/wasiakgruppe/ann/abstraction/interfaces/IUniqueEntry;", "email", "", "getEmail", "()Ljava/lang/String;", "firstName", "getFirstName", "lastName", "getLastName", "phoneNumber", "getPhoneNumber", "abstraction_debug"})
public abstract interface IPerson extends de.wasiakgruppe.ann.abstraction.interfaces.IUniqueEntry {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getFirstName();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getLastName();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getPhoneNumber();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getEmail();
}