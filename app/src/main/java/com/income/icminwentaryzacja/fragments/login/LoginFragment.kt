package com.income.icminwentaryzacja.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.backstack.ROUTE_ARGUMENTS_KEY
import com.income.icminwentaryzacja.database.dto.User
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsRoute
import com.income.icminwentaryzacja.utilities.inflate
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_login, container) {

                btnOpenFile.setOnClickListener {
                  navigateTo(ScanPositionsRoute())
                    User(etLogin.text.toString()).save()
                }

            }

//
//    override fun onClick(v: View?) {
//        if (v == bNextLogin) {
//            BackstackService.get(activity).goTo(ListRoute())
//        }
//
//    }
}


