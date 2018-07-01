package com.income.icminwentaryzacja.database

import com.raizlabs.android.dbflow.sql.language.OrderBy
import com.raizlabs.android.dbflow.sql.language.SQLOperator
import com.raizlabs.android.dbflow.structure.BaseModel


interface IQueryRepository {
    fun insert(entry: BaseModel): Long

    fun update(entry: BaseModel): Boolean

    fun delete(entry: BaseModel): Boolean

    fun save(entry: BaseModel): Boolean

    @Throws(NullDatabaseResultException::class)
    fun <T : BaseModel> selectFirst(selectFrom: Class<T>, vararg conditions: SQLOperator): T

    fun <T : BaseModel> selectFirstOrDefault(selectFrom: Class<T>, vararg conditions: SQLOperator): T?

    fun <T : BaseModel> selectAll(selectFrom: Class<T>, vararg conditions: SQLOperator): Iterable<T>

    fun <T : BaseModel> selectAll(selectFrom: Class<T>): Iterable<T>

    fun <T : BaseModel> selectAll(selectFrom: Class<T>, orderBy: OrderBy, ascending: Boolean): Iterable<T>
}
