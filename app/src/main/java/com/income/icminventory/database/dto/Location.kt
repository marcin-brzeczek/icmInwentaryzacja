package com.income.icminventory.database.dto

import android.os.Parcel
import com.income.icminventory.abstraction.ParcelableLite
import com.income.icminventory.database.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import paperparcel.PaperParcel
import java.util.UUID


@PaperParcel
@Table(database = AppDatabase::class)
data class Location(

        @Column
        var name: String = "",

        @PrimaryKey
        @Column
        var id: UUID = UUID.randomUUID()

) : BaseModel(), ParcelableLite {

    companion object {
        @JvmField
        val CREATOR = PaperParcelUser.CREATOR
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelLocation.writeToParcel(this, dest, flags)
    }
}