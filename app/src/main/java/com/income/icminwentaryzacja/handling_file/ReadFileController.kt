package com.income.icminwentaryzacja.handling_file

import android.net.Uri
import com.income.icminwentaryzacja.database.AppDatabase
import com.income.icminwentaryzacja.database.dto.Item
import com.income.icminwentaryzacja.database.dto.Location
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase
import com.income.icminwentaryzacja.fragments.location.ChooseLocationRoute
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction
import java.io.InputStreamReader
import java.io.LineNumberReader

class ReadFileController(val fragmentBase: FragmentBase) {

    private val items = mutableListOf<Item>()

     fun readFileContent(uri: Uri?): String {
        val inputStream = fragmentBase.activity.contentResolver.openInputStream(uri)
        val reader = LineNumberReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        reader.readLine() // read first line - the headers of columns

        var currentline = reader.readLine()
        while (currentline != null && reader.lineNumber > 1) {
            val arrayLine = currentline.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val item = Item()
            item.code = arrayLine[1]
            item.supportCode = arrayLine[2]
            item.shortName = arrayLine[3]
            item.name = arrayLine[4]
            item.oldLocation = arrayLine[5]
            item.startNumber = arrayLine[6].toDouble()
            item.itemState = ""
            items.add(item)
            currentline = reader.readLine()
        }
        inputStream.close()
        println(stringBuilder.toString())
        storageItems()
        return stringBuilder.toString()
    }

   private fun storageItems() {
        FlowManager.getDatabase(AppDatabase::class.java)
                .beginTransactionAsync(ProcessModelTransaction.Builder<Item>(
                        ProcessModelTransaction.ProcessModel<Item> { model, wrapper -> model?.save() }).addAll(items).build())  // add elements (can also handle multiple)
                .error { transaction, error -> }
                .success {
                    storageLocations()
                }.build().execute()
    }

    private fun storageLocations() {
        FlowManager.getDatabase(AppDatabase::class.java)
                .beginTransactionAsync(ProcessModelTransaction.Builder<Location>(
                        ProcessModelTransaction.ProcessModel<Location> { model, wrapper -> model?.save() }).addAll(items.distinctBy { it.oldLocation }.map { Location(name = it.oldLocation) }).build())  // add elements (can also handle multiple)
                .error { transaction, error -> }
                .success {
                    fragmentBase.navigateTo(ChooseLocationRoute())

                }.build().execute()
    }
}