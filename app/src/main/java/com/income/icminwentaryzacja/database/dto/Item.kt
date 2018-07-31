package com.income.icminwentaryzacja.database.dto

import android.os.Parcel
import com.income.icminwentaryzacja.abstraction.ParcelableLite
import com.income.icminwentaryzacja.database.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import paperparcel.PaperParcel

@PaperParcel
@Table( database = AppDatabase::class)
data class Item(

    @PrimaryKey(autoincrement = true)
    @Column
    var id: Long = 0,

    @Column
    var code: String="",

    @Column
    var supportCode: String = "",

    @Column
    var shortName: String = "",

    @Column
    var name: String = "",

    @Column
    var oldLocation: String = "",

    @Column
    var startNumber: Double = 0.0,

    @Column
    var endNumber: Double = 0.0,

    @Column
    var itemState: String ="skaner",

    @Column
    var user: String = "")  : BaseModel(), ParcelableLite
{

    companion object {
        @JvmField
        val CREATOR = PaperParcelItem.CREATOR
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
         PaperParcelItem.writeToParcel(this, dest, flags)
    }
}
