package com.income.icminwentaryzacja.fragments.adapter.viewmodel

import android.content.Context
import com.income.icminwentaryzacja.database.dto.Location
import com.income.icminwentaryzacja.fragments.adapter.ITypesFactory

class LocationViewModel(val item: Location, val context: Context) : ViewModel() {

    override fun type(typesFactory: ITypesFactory): Int {
        return typesFactory.type(item)
    }
}