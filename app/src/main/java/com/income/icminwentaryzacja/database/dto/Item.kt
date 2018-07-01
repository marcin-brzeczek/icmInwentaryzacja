package com.income.icminwentaryzacja.database.dto

import com.income.icminwentaryzacja.database.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel


@Table(name = "items", database = AppDatabase::class)
class Item : BaseModel() {

    @PrimaryKey(autoincrement = true)
    @Column(name = "Id")
    var id: Long = 0

    @Column(name = "Kod")
    var code: String = ""

    @Column(name = "KodPomocniczy")
    var supportCode: String = ""

    @Column(name = "NazwaSkrocona")
    var shortName: String = ""

    @Column(name = "Nazwa")
    var Name: String = ""

    @Column(name = "LokalizacjaStara")
    var oldLocation: String = ""

    @Column(name = "IloscPoczatkowa")
    var startNumber: Double = 0.0

    @Column(name = "IloscKoncowa")
    var endNumber: Double = 0.0

    @Column(name = "uzytkownik")
    var user: String = ""
}