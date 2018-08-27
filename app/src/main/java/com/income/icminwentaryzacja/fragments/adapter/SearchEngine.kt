package com.income.icminwentaryzacja.fragments.adapter

import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminwentaryzacja.fragments.adapter.viewmodel.ViewModel
import java.util.*

class SearchEngine(private val items: List<ViewModel>) {

    private val _items: Int

    init {
        _items = items.size
    }

    fun search(query: String): MutableList<ViewModel> {

        try {
            Thread.sleep(200)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val result = LinkedList<ViewModel>()

        for (i in 0 until _items) {
            if ((items[i] as ItemViewModel).item.name.toLowerCase().contains(query.toLowerCase())
                    || (items[i] as ItemViewModel).item.code.toLowerCase().contains(query.toLowerCase())) {
                result.add(items[i])
            }
        }
        return result
    }
}