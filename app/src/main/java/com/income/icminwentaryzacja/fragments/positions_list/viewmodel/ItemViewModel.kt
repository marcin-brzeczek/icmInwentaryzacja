package com.income.icminwentaryzacja.fragments.positions_list.viewmodel

import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.positions_list.ITypesFactory

class ItemViewModel(val item: Item): ViewModel() {
    override fun type(typesFactory: ITypesFactory): Int {
        return typesFactory.type(item)
    }
}