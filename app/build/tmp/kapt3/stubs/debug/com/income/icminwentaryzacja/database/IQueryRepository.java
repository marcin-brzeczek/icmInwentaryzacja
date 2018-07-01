package com.income.icminwentaryzacja.database;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH&J6\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H&J?\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H&\u00a2\u0006\u0002\u0010\u0014J9\u0010\u0015\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H\'\u00a2\u0006\u0002\u0010\u0016J;\u0010\u0017\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H&\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0019"}, d2 = {"Lcom/income/icminwentaryzacja/database/IQueryRepository;", "", "delete", "", "entry", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "insert", "", "save", "selectAll", "", "T", "selectFrom", "Ljava/lang/Class;", "orderBy", "Lcom/raizlabs/android/dbflow/sql/language/OrderBy;", "ascending", "conditions", "", "Lcom/raizlabs/android/dbflow/sql/language/SQLOperator;", "(Ljava/lang/Class;[Lcom/raizlabs/android/dbflow/sql/language/SQLOperator;)Ljava/lang/Iterable;", "selectFirst", "(Ljava/lang/Class;[Lcom/raizlabs/android/dbflow/sql/language/SQLOperator;)Lcom/raizlabs/android/dbflow/structure/BaseModel;", "selectFirstOrDefault", "update", "app_debug"})
public abstract interface IQueryRepository {
    
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.raizlabs.android.dbflow.structure.BaseModel entry);
    
    public abstract boolean update(@org.jetbrains.annotations.NotNull()
    com.raizlabs.android.dbflow.structure.BaseModel entry);
    
    public abstract boolean delete(@org.jetbrains.annotations.NotNull()
    com.raizlabs.android.dbflow.structure.BaseModel entry);
    
    public abstract boolean save(@org.jetbrains.annotations.NotNull()
    com.raizlabs.android.dbflow.structure.BaseModel entry);
    
    @org.jetbrains.annotations.NotNull()
    public abstract <T extends com.raizlabs.android.dbflow.structure.BaseModel>T selectFirst(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> selectFrom, @org.jetbrains.annotations.NotNull()
    com.raizlabs.android.dbflow.sql.language.SQLOperator... conditions);
    
    @org.jetbrains.annotations.Nullable()
    public abstract <T extends com.raizlabs.android.dbflow.structure.BaseModel>T selectFirstOrDefault(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> selectFrom, @org.jetbrains.annotations.NotNull()
    com.raizlabs.android.dbflow.sql.language.SQLOperator... conditions);
    
    @org.jetbrains.annotations.NotNull()
    public abstract <T extends com.raizlabs.android.dbflow.structure.BaseModel>java.lang.Iterable<T> selectAll(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> selectFrom, @org.jetbrains.annotations.NotNull()
    com.raizlabs.android.dbflow.sql.language.SQLOperator... conditions);
    
    @org.jetbrains.annotations.NotNull()
    public abstract <T extends com.raizlabs.android.dbflow.structure.BaseModel>java.lang.Iterable<T> selectAll(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> selectFrom);
    
    @org.jetbrains.annotations.NotNull()
    public abstract <T extends com.raizlabs.android.dbflow.structure.BaseModel>java.lang.Iterable<T> selectAll(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> selectFrom, @org.jetbrains.annotations.NotNull()
    com.raizlabs.android.dbflow.sql.language.OrderBy orderBy, boolean ascending);
}