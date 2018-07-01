package com.income.icminwentaryzacja.fragments.positions_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.DBContext
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import javax.inject.Inject

class ListFragment : FragmentBase() {

    @Inject
    lateinit var databaseContext: DBContext

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)

    }
}


