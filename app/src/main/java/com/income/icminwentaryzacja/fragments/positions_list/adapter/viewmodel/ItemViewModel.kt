package com.income.icminwentaryzacja.fragments.positions_list.adapter.viewmodel

import android.content.Context
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.positions_list.adapter.IStatusResult
import com.income.icminwentaryzacja.fragments.positions_list.adapter.ITypesFactory
import com.income.icminwentaryzacja.fragments.positions_list.adapter.ItemStatus

class ItemViewModel(val item: Item, val context: Context) : ViewModel(), IStatusResult {

    override fun type(typesFactory: ITypesFactory): Int {
        return typesFactory.type(item)
    }

    override fun getStatus(): ItemStatus {

        with(item) {
            if (startNumber > endNumber)
                return ItemStatus.Brak

            if (startNumber < endNumber)
                return ItemStatus.Nadwyzka
        }
        return ItemStatus.Zgodny
    }
}