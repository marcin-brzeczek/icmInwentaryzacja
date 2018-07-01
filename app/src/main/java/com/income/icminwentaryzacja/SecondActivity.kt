//package com.income.icminwentaryzacja
//
//import android.app.Activity
//import android.os.Bundle
//import android.view.Menu
//import android.view.MenuItem
//
//class SecondActivity : Activity() {
//    lateinit var listAdapter: MainAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second)
//
//
//        with(list) {
//            setHasFixedSize(true)
//            layoutManager = LinearLayoutManager(this@SecondActivity)
//            listAdapter = MainAdapter()
//            adapter = listAdapter
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        listAdapter.addAll(listOf(Item(), Item(), Item()))
//        list.smoothScrollToPosition(0)
//        return true
//
//    }
//}
//
