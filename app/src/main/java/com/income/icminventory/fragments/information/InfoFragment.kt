package com.income.icminventory.fragments.information

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminventory.R
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.utilities.inflate
import kotlinx.android.synthetic.main.fragment_info.*

class  InfoFragment :  FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_info, container, false){
              setActionBar(this@InfoFragment)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back.setOnClickListener { navigateBack() }
    }
}