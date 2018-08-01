package com.income.icminwentaryzacja.fragments.new_position

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.utilities.inflate
import kotlinx.android.synthetic.main.fragment_new_position.view.tvCode
import kotlinx.android.synthetic.main.fragment_new_position.view.btnSave
import kotlinx.android.synthetic.main.fragment_new_position.view.etName


class NewItemFragment : FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_new_position, container) {

                val item: Item? = arguments.getParcelable(NEW_ITEM_KEY)
                tvCode.text = item?.code

                btnSave.setOnClickListener {
                    item?.name = etName.text.toString()
                    item?.save()
                    item?.let {
                        Toast.makeText(activity.baseContext, "Zapisano pozycję", Toast.LENGTH_SHORT).show()
                        navigateBack()  }
                }
                setHasOptionsMenu(true)
            }
}


