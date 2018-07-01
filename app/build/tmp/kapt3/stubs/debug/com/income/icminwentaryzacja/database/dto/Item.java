package com.income.icminwentaryzacja.database.dto;

@com.raizlabs.android.dbflow.annotation.Table(name = "items", database = com.income.icminwentaryzacja.database.AppDatabase.class)
@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b\u00a8\u0006\'"}, d2 = {"Lcom/income/icminwentaryzacja/database/dto/Item;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "()V", "Name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "code", "getCode", "setCode", "endNumber", "", "getEndNumber", "()D", "setEndNumber", "(D)V", "id", "", "getId", "()J", "setId", "(J)V", "oldLocation", "getOldLocation", "setOldLocation", "shortName", "getShortName", "setShortName", "startNumber", "getStartNumber", "setStartNumber", "supportCode", "getSupportCode", "setSupportCode", "user", "getUser", "setUser", "app_debug"})
public final class Item extends com.raizlabs.android.dbflow.structure.BaseModel {
    @com.raizlabs.android.dbflow.annotation.Column(name = "Id")
    @com.raizlabs.android.dbflow.annotation.PrimaryKey(autoincrement = true)
    private long id;
    @org.jetbrains.annotations.NotNull()
    @com.raizlabs.android.dbflow.annotation.Column(name = "Kod")
    private java.lang.String code;
    @org.jetbrains.annotations.NotNull()
    @com.raizlabs.android.dbflow.annotation.Column(name = "KodPomocniczy")
    private java.lang.String supportCode;
    @org.jetbrains.annotations.NotNull()
    @com.raizlabs.android.dbflow.annotation.Column(name = "NazwaSkrocona")
    private java.lang.String shortName;
    @org.jetbrains.annotations.NotNull()
    @com.raizlabs.android.dbflow.annotation.Column(name = "Nazwa")
    private java.lang.String Name;
    @org.jetbrains.annotations.NotNull()
    @com.raizlabs.android.dbflow.annotation.Column(name = "LokalizacjaStara")
    private java.lang.String oldLocation;
    @com.raizlabs.android.dbflow.annotation.Column(name = "IloscPoczatkowa")
    private double startNumber;
    @com.raizlabs.android.dbflow.annotation.Column(name = "IloscKoncowa")
    private double endNumber;
    @org.jetbrains.annotations.NotNull()
    @com.raizlabs.android.dbflow.annotation.Column(name = "uzytkownik")
    private java.lang.String user;
    
    public final long getId() {
        return 0L;
    }
    
    public final void setId(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCode() {
        return null;
    }
    
    public final void setCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSupportCode() {
        return null;
    }
    
    public final void setSupportCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShortName() {
        return null;
    }
    
    public final void setShortName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOldLocation() {
        return null;
    }
    
    public final void setOldLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final double getStartNumber() {
        return 0.0;
    }
    
    public final void setStartNumber(double p0) {
    }
    
    public final double getEndNumber() {
        return 0.0;
    }
    
    public final void setEndNumber(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Item() {
        super();
    }
}