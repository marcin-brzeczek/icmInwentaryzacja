package com.income.icminwentaryzacja.fragments.positions_list.viewmodel

import com.income.icminwentaryzacja.fragments.positions_list.ITypesFactory

abstract class ViewModel {
    abstract fun type(typesFactory: ITypesFactory): Int
}