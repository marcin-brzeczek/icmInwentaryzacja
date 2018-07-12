package com.income.icminwentaryzacja.fragments.positions_list.adapter.viewmodel

import com.income.icminwentaryzacja.fragments.positions_list.adapter.ITypesFactory

abstract class ViewModel {
    abstract fun type(typesFactory: ITypesFactory): Int
}