package com.income.icminventory.fragments.adapter

import com.income.icminventory.fragments.adapter.viewmodel.ItemViewModel
import com.income.icminventory.fragments.adapter.viewmodel.ViewModel
import java.util.LinkedList

class SearchEngine {


    fun search(query: String, items: List<ViewModel>): MutableList<ViewModel> {

        try {
            Thread.sleep(200)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val result = LinkedList<ViewModel>()

        for (i in 0 until items.size) {
            if ((items[i] as ItemViewModel).item.name.toLowerCase().contains(query.toLowerCase())
                || (items[i] as ItemViewModel).item.code.toLowerCase().contains(query.toLowerCase())
                || (items[i] as ItemViewModel).item.supportCode.toLowerCase().contains(query.toLowerCase())) {
                result.add(items[i])
            }
        }
        return result
    }
}