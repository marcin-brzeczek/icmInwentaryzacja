package com.income.icminventory.fragments.abstraction

import com.income.icminventory.activities.MainActivity
import com.income.icminventory.fragments.information.InfoFragment

interface ActionBarManager {

    fun setActionBar(fragmentBase: FragmentBase) {
        fragmentBase.let {
            if (it is InfoFragment)
                (it.activity as MainActivity).supportActionBar?.hide()
            else
                (it.activity as MainActivity).supportActionBar?.show()
        }
    }
}