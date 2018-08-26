package com.income.icminwentaryzacja.backstack

import android.content.Context
import android.widget.Toast
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.fragments.report.ReportRoute
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.BackstackDelegate
import com.zhuinden.simplestack.HistoryBuilder
import com.zhuinden.simplestack.StateChange


/** Class that handles onBackPressed logic.
 * Shows the user confirmation message in a form of a toast on first backPress. Requires a second press to confirm exit */
class BackPressedHandler(private val backStackDelegate: BackstackDelegate) : Backstack.CompletionListener {
    private var isFinalBackPress = false

    override fun stateChangeCompleted(stateChange: StateChange) {
        if (stateChange.direction == StateChange.FORWARD || stateChange.direction == StateChange.REPLACE) resetFinalExit()
    }

    private fun resetFinalExit() {
        isFinalBackPress = false
    }

    private fun shouldExit(context: Context): Boolean {
        if (!isFinalBackPress) {
            Toast.makeText(context, R.string.exit_message, Toast.LENGTH_SHORT).show()
            isFinalBackPress = true
            return false
        }
        return isFinalBackPress
    }

    /** Method called on BackPressed in Activity
     * determining if we should exit application or not */
    fun handleBackPressed(context: Context): Boolean {
        val history = backStackDelegate.backstack.history
        if (history.size == 0) {
            return true
        }
        val lastElementKey = history[history.size - 1] as BaseRoute
        if (history.size == 1 ) {
//            return shouldExit(context)
        }
//        backstackHistoryChange(lastElementKey)
        return false
    }

    private fun backstackHistoryChange(lastElementRoute: BaseRoute) {
//        if (lastElementRoute.isBottomNavigationElement) {
//            backStackDelegate.backstack.setHistory(HistoryBuilder.single(ReportRoute()), StateChange.REPLACE)
//        } else {
            backStackDelegate.backstack.goBack()
        }
//    }
}
