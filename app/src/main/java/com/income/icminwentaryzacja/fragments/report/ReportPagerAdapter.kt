package com.income.icminwentaryzacja.fragments.report

import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.support.v13.app.FragmentPagerAdapter
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.fragments.login.LoginFragment
import com.income.icminwentaryzacja.fragments.positions_list.ListFragment
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsFragment


const val LOGIN_POSITION = 0
const val LIST_POSITION = 1
const val SCAN_POSISITON = 2

class ReportPagerAdapter(fragmentManager: FragmentManager, context: Context) : FragmentPagerAdapter(fragmentManager) {

    private val _itemList = context.resources.getStringArray(R.array.report_fragment_tab_names)!!

    override fun getPageTitle(position: Int): CharSequence? = _itemList[position]

    override fun getItem(position: Int): Fragment = when (position) {

        LOGIN_POSITION -> LoginFragment()
        LIST_POSITION -> ListFragment()
        SCAN_POSISITON -> ScanPositionsFragment()

        else -> throw IndexOutOfBoundsException()
    }

    override fun getCount() = _itemList.size
}