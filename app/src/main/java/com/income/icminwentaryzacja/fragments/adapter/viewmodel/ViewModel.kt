package com.income.icminwentaryzacja.fragments.adapter.viewmodel

import com.income.icminwentaryzacja.fragments.adapter.ITypesFactory

abstract class ViewModel {
    abstract fun type(typesFactory: ITypesFactory): Int
}