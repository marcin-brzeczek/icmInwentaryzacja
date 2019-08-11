package com.income.icminventory.database

import com.income.icminventory.database.dto.Item
import com.income.icminventory.database.dto.Item_Table
import com.income.icminventory.database.dto.Location
import com.income.icminventory.database.dto.Location_Table
import com.income.icminventory.database.dto.User
import com.raizlabs.android.dbflow.sql.language.From
import com.raizlabs.android.dbflow.sql.language.SQLite
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DBContext @Inject constructor() {

    val items: From<Item>
        get() = SQLite.select().from(Item::class.java)

    val users: From<User>
        get() = SQLite.select().from(User::class.java)

    val locations: From<Location>
        get() = SQLite.select().from(Location::class.java)

    fun deleteOldLocations() {
        SQLite.delete()
            .from(Location::class.java)
            .innerJoin(Item::class.java)
            .on(Item_Table.oldLocation.eq(Location_Table.name))
            .execute()
    }

    fun deleteUsers(){
        SQLite.delete()
            .from(User::class.java)
            .async()
            .execute()
    }

    val isEmptyItems: Boolean
        get() = !items.hasData()

    val isEmptyScannedItems: Boolean
       get() = !items.where(Item_Table.endNumber.greaterThan(0.0)).hasData()

    val isEmptyUsers: Boolean
        get() = !users.hasData()

}