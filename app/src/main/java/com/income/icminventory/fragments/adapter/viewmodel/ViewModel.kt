package com.income.icminventory.fragments.adapter.viewmodel

import com.income.icminventory.fragments.adapter.ITypesFactory

abstract class ViewModel {
    abstract fun type(typesFactory: ITypesFactory): Int
}