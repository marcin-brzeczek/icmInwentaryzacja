//package com.income.icminwentaryzacja
//
//import android.content.Context
//import android.content.Intent
//import android.graphics.Color
//import android.net.Uri
//import android.support.v7.widget.RecyclerView
//import android.text.format.DateFormat
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.raizlabs.android.dbflow.config.FlowManager
//import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper
//import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction
//import com.income.icminwentaryzacja.core.ItemRepository
//import java.io.BufferedReader
//import java.io.DataInputStream
//import java.io.FileInputStream
//import java.io.InputStreamReader
//import java.util.*
//
//
//class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
//
//    private val mItems: MutableList<Item>
//    private val mOnClickListener: View.OnClickListener
//
//
//    init {
////        mItems = mutableListOf()
//        mItems = ItemRepository.getAll()
//        mOnClickListener = View.OnClickListener { v ->
//            val item = v.tag as Item
//            item.updatedAt = Calendar.getInstance()
//            item.save()
//            notifyDataSetChanged()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        return ViewHolder(layoutInflater.inflate(R.layout.item, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = mItems[position]
//        val date = item.updatedAt.timeInMillis
//
//        val color = "#" + date.toString().substring(7)
//        holder.card?.setCardBackgroundColor(Color.parseColor(color))
//        holder.title?.text = color
//        holder.date?.text = DateFormat.format("hh:mm:ss", Date(date))
//
//        with(holder.container) {
//            this?.let {
//                tag = item
//                setOnClickListener(mOnClickListener)
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return mItems.size
//    }
//
//    fun add() {
//        val item = Item()
//        mItems.add(0, item)
//        item.save()
//        notifyItemInserted(0)
//    }
//
//    fun addAll(items: List<Item>) {
//        for (item in items) {
//            mItems.add(0, item)
//            item.save()
//            notifyItemInserted(0)
//        }
//    }
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val card = view.card
//        val container = view.container
//        val title = view.title
//        val date = view.date
//    }
//
//
//    public fun saveToDBFromFile( context: Context, contentUri: Uri?){
//
//
////        readTextFromUri(getPathDeprecated(context,contentUri), context)
//
//    }
//    //    @Throws(IOException::class)
//    private fun readTextFromUri(path: String?, context: Context): String {
//        val fis = FileInputStream(path)
//        val `in` = DataInputStream(fis)
//        val reader = BufferedReader(InputStreamReader(`in`))
//        val stringBuilder = StringBuilder()
//
//        reader.useLines { lines ->
//            lines.forEach {
//                val arrayLine = it.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//                val item = Item()
//                item.code = arrayLine[0]
//                item.supportCode = arrayLine[1]
//                item.shortName = arrayLine[2]
//                item.Name = arrayLine[3]
//                item.oldLocation = arrayLine[4]
//                item.startNumber = arrayLine[5].toDouble()
//                item.endNumber = if(arrayLine[6] !=null && arrayLine[6].length>0) arrayLine[6].toDouble() else 0.0
//
//                mItems.add(item)
//            }
//        }
////        while ((line = reader.readLine()) != null) {
////                val arrayLine = line.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
////
////                val item = Item()
////                item.code = arrayLine[0]
////                item.supportCode = arrayLine[1]
////                item.shortName = arrayLine[2]
////                item.Name = arrayLine[3]
////                item.oldLocation = arrayLine[4]
////                item.startNumber = arrayLine[5].toDouble()
////                item.endNumber = arrayLine[6].toDouble()
////
////                mItems.add(item)
////
//////                DatabaseBO.getInstance().getDokPozListChoosen()
//////                        .add(DokumentPozycja(arrayLine[1], arrayLine[2], arrayLine[3], arrayLine[4],
//////                                arrayLine[5], arrayLine[6], arrayLine[7], arrayLine[8], arrayLine[9], null, null))
////
////                stringBuilder.append(line)
////
////        }
//        `in`.close()
//        storage(context)
//
//        return stringBuilder.toString()
//    }
//
//
////    fun getRealPathFromURI(context: Context, contentUri: Uri?): String {
////        var cursor: Cursor? = null
////        try {
////            val proj = arrayOf(MediaStore.Images.Media.DATA)
////            cursor = context.getContentResolver().query(contentUri, proj, null, null, null)
////            val column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
////            cursor.moveToFirst()
////            return cursor.getString(column_index)
////        } finally {
////            if (cursor != null) {
////                cursor.close()
////            }
////        }
////    }
//
//
//    fun storage(context: Context) {
//
//        FlowManager.getDatabase(AppDatabase::class.java)
//                .beginTransactionAsync(ProcessModelTransaction.Builder<Item>(
//                        object : ProcessModelTransaction.ProcessModel<Item> {
//                            override fun processModel(model: Item?, wrapper: DatabaseWrapper?) {
//
//                                model?.save()
//                            }
//
//                        }).addAll(mItems).build())  // add elements (can also handle multiple)
//                .error { transaction, error -> }
//                .success {
//                    context.startActivity(Intent(context, SecondActivity::class.java))
//
//                }.build().execute()
//    }
//
//}
//
//
