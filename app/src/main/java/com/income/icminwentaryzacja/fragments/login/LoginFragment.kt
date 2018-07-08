package com.income.icminwentaryzacja.fragments.login

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.database.AppDatabase
import com.income.icminwentaryzacja.database.DBContext
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.database.dto.User
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsRoute
import com.income.icminwentaryzacja.utilities.inflate
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction
import kotlinx.android.synthetic.main.fragment_login.view.*
import java.io.InputStreamReader
import java.io.LineNumberReader
import javax.inject.Inject

const val READ_REQUEST_CODE = 99

class LoginFragment : FragmentBase() {

    private val items = mutableListOf<Item>()

    @Inject
    lateinit var dbContext: DBContext

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

    fun selectCSVFile() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        startActivityForResult(Intent.createChooser(intent, "Open CSV"), READ_REQUEST_CODE)
    }

    private fun readFileContent(uri: Uri?): String {

        val inputStream = activity.contentResolver.openInputStream(uri)
        val reader = LineNumberReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        reader.readLine() // read first line - the headers of columns

        var currentline = reader.readLine()
        while (currentline != null && reader.lineNumber > 1) {

//            if (!currentline.contains("LokalizacjaStara")) {
            val arrayLine = currentline.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

//            stringBuilder.append(currentline + "\n")
            val item = Item()
            item.code = arrayLine[1]
            item.supportCode = arrayLine[2]
            item.shortName = arrayLine[3]
            item.name = arrayLine[4]
            item.oldLocation = arrayLine[5]
            item.startNumber = arrayLine[6].toDouble()
//            item.endNumber = arrayLine[7].toDouble()
            items.add(item)

            currentline = reader.readLine()
//            }
        }
        inputStream.close()
        println(stringBuilder.toString())
        storage()
        return stringBuilder.toString()
    }

    fun storage() {
        FlowManager.getDatabase(AppDatabase::class.java)
                .beginTransactionAsync(ProcessModelTransaction.Builder<Item>(
                        ProcessModelTransaction.ProcessModel<Item> { model, wrapper -> model?.save() }).addAll(items).build())  // add elements (can also handle multiple)
                .error { transaction, error -> }
                .success {
                    navigateTo(ScanPositionsRoute())
                }.build().execute()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            READ_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {

                    data?.data?.let {

                        if (!it.path.contains(".csv")) {
                            Toast.makeText(activity.baseContext, "Wybrany plik nie jest formatu csv!", Toast.LENGTH_SHORT).show()
                            return
                        } else {
                            readFileContent(it)
                        }
                    }
                }
            }
        }
    }

//    private fun showAlertDialog() {
//        val fm = activity.fragmentManager
//        val alertDialog = ProgressDialogFragment()
//        alertDialog.show(fm, "fragment_alert")
//    }

}


