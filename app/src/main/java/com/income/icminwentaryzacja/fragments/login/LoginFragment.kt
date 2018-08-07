package com.income.icminwentaryzacja.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.dto.User
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsRoute
import com.income.icminwentaryzacja.utilities.inflate
import kotlinx.android.synthetic.main.fragment_login.view.*

const val READ_REQUEST_CODE = 99

class LoginFragment : FragmentBase() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_login, container) {
                val isEmptyDatabase: Boolean = dbContext.isEmpty
                val buttonTitle: String = if (isEmptyDatabase) "Wczytaj plik CSV" else "Otwórz istniejącą bazę"
                btnOpenFile.setText(buttonTitle)

                btnOpenFile.setOnClickListener {
                    if (isEmptyDatabase) {
                        btnOpenFile.setText("Wczytaj plik CSV")
                        selectCSVFile()
                    } else {
                        btnOpenFile.setText("Otwórz istniejącą bazę")
                        navigateTo(ScanPositionsRoute())
                    }
                    User(etLogin.text.toString()).save()
                }
                setHasOptionsMenu(true)
            }
}