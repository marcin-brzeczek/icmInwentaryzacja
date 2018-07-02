//package com.income.icminwentaryzacja
//
//import android.app.Activity
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.view.Menu
//import android.view.MenuItem
//import android.widget.Toast
//import com.income.icminwentaryzacja.database.AppDatabase
//import com.income.icminwentaryzacja.database.dto.Item
//import com.raizlabs.android.dbflow.config.FlowManager
//import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
//import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction
//import com.income.icminwentaryzacja.emkd_scan.EmdkWrapper
//import com.income.icminwentaryzacja.emkd_scan.OnScannerRead
//import java.io.IOException
//import java.io.InputStreamReader
//import java.io.LineNumberReader
//
//
//const val READ_REQUEST_CODE = 99
//
//class MainActivity : Activity(), OnScannerRead {
//
//    private val items = mutableListOf<Item>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        bOpenFile.setOnClickListener { selectCSVFile() }
//
//        try {
//            EmdkWrapper.initEmdk(this)
//        } catch (e: Exception) {
//            exceptionMessage("Błąd w inicjalizacji  Skanera: " + e.message)
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
////        listAdapter.add()
//        return true
//    }
//
//    fun selectCSVFile() {
//        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
//        intent.addCategory(Intent.CATEGORY_OPENABLE)
//        intent.type = "*/*"
//        startActivityForResult(Intent.createChooser(intent, "Open CSV"), READ_REQUEST_CODE)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
//        when (requestCode) {
//            READ_REQUEST_CODE -> {
//                if (resultCode == Activity.RESULT_OK) {
//
//                    try {
//                        //
//                        readFileContent(data.data)
////                        startActivity(Intent(this@DocumentListActivity, ScanDocPosActivity::class.java))
//
//                    } catch (e: IOException) {
//                        Toast.makeText(this, "Error read text" + e.toString(), Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        try {
//            EmdkWrapper.registerScannerListener(this)
//        } catch (e: Exception) {
//            exceptionMessage("Błąd w trakcie rejestracji Skanera: " + e.message)
//        }
//    }
//
//    public override fun onPause() {
//        super.onPause()
//        try {
//            EmdkWrapper.unregisterScannerListener()
//        } catch (e: Exception) {
//            exceptionMessage("Błąd w trakcie wyrejestrowania Skanera: " + e.message)
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        try {
//            EmdkWrapper.deinitEmkd()
//        } catch (e: Exception) {
//            exceptionMessage("Nie można zwolnić obiektu Skanera: " + e.message)
//        }
//    }
//
//    override fun onReadStatus(p0: String?) {
//    }
//
//    override fun exceptionMessage(text: String?) {
//        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
//    }
//
//    override fun onReadData(data: String?) {
//        tScan.setText(data)
//    }
//
//
//    private fun readFileContent(uri: Uri?): String {
//
//        val inputStream = contentResolver.openInputStream(uri)
//        val reader = LineNumberReader(InputStreamReader(
//                inputStream))
//        val stringBuilder = StringBuilder()
//
//        reader.readLine() // read first line - the headers of columns
//
//        var currentline = reader.readLine()
//
//
//        while (currentline != null && reader.lineNumber > 1) {
//
////            if (!currentline.contains("LokalizacjaStara")) {
//            val arrayLine = currentline.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//
////            stringBuilder.append(currentline + "\n")
//            val item = Item()
//            item.code = arrayLine[1]
//            item.supportCode = arrayLine[2]
//            item.shortName = arrayLine[3]
//            item.Name = arrayLine[4]
//            item.oldLocation = arrayLine[5]
//            item.startNumber = arrayLine[6].toDouble()
////            item.endNumber = arrayLine[7].toDouble()
//            items.add(item)
//
//            currentline = reader.readLine()
////            }
//        }
//        inputStream.close()
//        println(stringBuilder.toString())
//        storage()
//        return stringBuilder.toString()
//    }
//
//    fun storage() {
//
//        FlowManager.getDatabase(AppDatabase::class.java)
//                .beginTransactionAsync(ProcessModelTransaction.Builder<Item>(
//                        object : ProcessModelTransaction.ProcessModel<Item> {
//                            override fun processModel(model: Item?, wrapper: DatabaseWrapper?) {
//
//                                model?.save()
//                            }
//
//                        }).addAll(items).build())  // add elements (can also handle multiple)
//                .error { transaction, error -> }
//                .success {
//                    startActivity(Intent(this, SecondActivity::class.java))
//
//                }.build().execute()
//    }
//
//}
//
//
