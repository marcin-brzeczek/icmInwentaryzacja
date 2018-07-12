package com.income.icminwentaryzacja.fragments.abstraction

import android.app.Fragment
import android.app.ListFragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.backstack.BackstackService
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.backstack.ROUTE_ARGUMENTS_KEY
import com.income.icminwentaryzacja.fragments.positions_list.empty_list.EmptyListRoute
import com.income.icminwentaryzacja.fragments.positions_list.scanned_list.ScannedListRoute
import com.income.icminwentaryzacja.fragments.scan_positions.ScanPositionsFragment
import dagger.android.AndroidInjection

abstract class FragmentBase : Fragment(), IOnResumeNotifier {
    private var onResumeListeners = mutableSetOf<((FragmentBase) -> Unit)>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        onResumeListeners.forEach { it.invoke(this) }
    }

    override fun addOnResumeListener(action: FragmentBase.() -> Unit) {
        onResumeListeners.add(action)
    }

    override fun removeOnResumeListener(action: FragmentBase.() -> Unit) {
        onResumeListeners.remove(action)
    }

    fun navigateBack() {
        BackstackService.get(activity).goBack()
    }

    fun navigateTo(route: BaseRoute, isReturnigResult: Boolean = false) {
        BackstackService.get(activity).goTo(route.apply {
            isReturning = isReturnigResult
            if (isReturning)
                returnRoute = arguments.getParcelable(ROUTE_ARGUMENTS_KEY)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.main, menu)
        when (this) {
            is ScanPositionsFragment -> {
                menu.findItem(R.id.sendData).setVisible(true)
                menu.findItem(R.id.listEmpty).setVisible(true)
                menu.findItem(R.id.listDesc).setVisible(true)
            }
            is ListFragment -> menu.findItem(R.id.sendData).setVisible(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> activity.finish()
            R.id.listEmpty -> navigateTo(EmptyListRoute())
            R.id.listDesc -> navigateTo(ScannedListRoute())
        }
        return super.onOptionsItemSelected(item)
    }
}