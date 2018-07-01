package de.wasiakgruppe.ann.abstraction.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005\u00a8\u0006\u0010"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/interfaces/IDevice;", "Lde/wasiakgruppe/ann/abstraction/interfaces/IUniqueEntry;", "hardwareVersion", "", "getHardwareVersion", "()Ljava/lang/String;", "mac", "getMac", "name", "getName", "registrationDate", "Lorg/joda/time/DateTime;", "getRegistrationDate", "()Lorg/joda/time/DateTime;", "softwareVersion", "getSoftwareVersion", "abstraction_debug"})
public abstract interface IDevice extends de.wasiakgruppe.ann.abstraction.interfaces.IUniqueEntry {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getName();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getMac();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getHardwareVersion();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getSoftwareVersion();
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.joda.time.DateTime getRegistrationDate();
}