package com.income.icminventory.fragments.adapter.viewmodel

import android.content.Context
import com.income.icminventory.database.dto.Location
import com.income.icminventory.fragments.adapter.ITypesFactory

class LocationViewModel(val item: Location, val context: Context) : ViewModel() {

    override fun type(typesFactory: ITypesFactory): Int {
        return typesFactory.type(item)
    }
}