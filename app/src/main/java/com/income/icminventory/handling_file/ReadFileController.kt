package com.income.icminventory.handling_file

import android.net.Uri
import com.income.icminventory.database.AppDatabase
import com.income.icminventory.database.dto.Item
import com.income.icminventory.database.dto.Location
import com.income.icminventory.fragments.abstraction.FragmentBase
import com.income.icminventory.fragments.location.ChooseLocationRoute
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction
import java.io.InputStreamReader
import java.io.LineNumberReader

class ReadFileController(val fragmentBase: FragmentBase) {

    private val items = mutableListOf<Item>()

    private val locations = mutableListOf<Location>()

    fun readPositionsFileContent(uri: Uri?): String {
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

    fun readLocationsFileContent(uri: Uri?): String {
        val inputStream = fragmentBase.activity.contentResolver.openInputStream(uri)
        val reader = LineNumberReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        reader.readLine() // read first line - the headers of columns

        var currentline = reader.readLine()
        while (currentline != null && reader.lineNumber > 1) {
            val arrayLine = currentline.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val location = Location()
            location.name = arrayLine[1]
            locations.add(location)
            currentline = reader.readLine()
        }
        inputStream.close()
        println(stringBuilder.toString())
        storageLocations()
        return stringBuilder.toString()
    }

    private fun storageItems() {
        FlowManager.getDatabase(AppDatabase::class.java)
            .beginTransactionAsync(ProcessModelTransaction.Builder<Item>(
                ProcessModelTransaction.ProcessModel<Item> { model, wrapper -> model?.save() }).addAll(items).build())  // add elements (can also handle multiple)
            .error { transaction, error -> }
            .success {
                saveLocationsOfItems()
            }.build().execute()
    }

    private fun storageLocations() {
        val existLocations = fragmentBase.dbContext.locations.queryList()
        FlowManager.getDatabase(AppDatabase::class.java)
            .beginTransactionAsync(ProcessModelTransaction.Builder<Location>(
                ProcessModelTransaction.ProcessModel<Location> { model, wrapper -> model.save() })
                .addAll(
                    locations
                        .distinctBy { it.name }
                        .filterNot { newLocation ->
                            existLocations.find { existLocation ->
                                newLocation.name == existLocation.name
                            } != null
                        }

                ).build())  // add elements (can also handle multiple)

            .error { transaction, error -> }
            .success {
                //                saveLocationsOfItems()
            }.build().execute()
    }

    private fun saveLocationsOfItems() {
        FlowManager.getDatabase(AppDatabase::class.java)
            .beginTransactionAsync(ProcessModelTransaction.Builder<Location>(
                ProcessModelTransaction.ProcessModel<Location> { model, wrapper -> model?.save() }).addAll(items.distinctBy { it.oldLocation }.map { Location(name = it.oldLocation) }).build())  // add elements (can also handle multiple)
            .error { transaction, error -> }
            .success {
                fragmentBase.navigateTo(ChooseLocationRoute())

            }.build().execute()
    }
}