package com.income.icminwentaryzacja.activities.abstraction

import android.app.Fragment
import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.zhuinden.simplestack.BackstackDelegate
import com.zhuinden.simplestack.HistoryBuilder
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import com.income.icminwentaryzacja.R
import com.income.icminwentaryzacja.backstack.BackPressedHandler
import com.income.icminwentaryzacja.backstack.BackstackService
import com.income.icminwentaryzacja.backstack.BaseRoute
import com.income.icminwentaryzacja.backstack.FragmentStateChanger
import org.jetbrains.annotations.Contract
import javax.inject.Inject

abstract class ActivityBase : AppCompatActivity(), StateChanger, HasFragmentInjector {

    /**
     * layout must have frame layout with id content_holder to work properly
     */
    abstract val layoutId: Int
    abstract val startRoute: BaseRoute

    private lateinit var backStackDelegate: BackstackDelegate
    private lateinit var fragmentStateChanger: FragmentStateChanger
    private lateinit var backPressHandler: BackPressedHandler

    @Inject
    internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun fragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        backStackDelegate = BackstackDelegate(null)
        backPressHandler = BackPressedHandler(backStackDelegate)
        backStackDelegate.addStateChangeCompletionListener(backPressHandler)

        backStackDelegate.onCreate(savedInstanceState, lastCustomNonConfigurationInstance, HistoryBuilder.single(startRoute))
        backStackDelegate.registerForLifecycleCallbacks(this)
//
        fragmentStateChanger = FragmentStateChanger(fragmentManager, R.id.content_holder)
        backStackDelegate.setStateChanger(this)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val toolbar = findViewById(R.id.toolbarMenu) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onRestart() {
        AndroidInjection.inject(this)
        super.onRestart()
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.topNewState<BaseRoute>() != stateChange.topPreviousState<BaseRoute>()) {
            fragmentStateChanger.handleStateChange(stateChange)
        }
        completionCallback.stateChangeComplete()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any = backStackDelegate.onRetainCustomNonConfigurationInstance()

    override fun onBackPressed() {
        if (backPressHandler.handleBackPressed(this)) {
//            super.onBackPressed()
        } else {
            fragmentManager.popBackStack()
        }
    }

    @Contract("null -> null")
    override fun getSystemService(name: String?): Any? = name?.let {
        if (it == BackstackService.TAG) {
            backStackDelegate.backstack
        } else {
            super.getSystemService(it)
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            findFocusedItem(event)
        }
        return super.dispatchTouchEvent(event)
    }

    private fun findFocusedItem(event: MotionEvent) {
        if (currentFocus is EditText) {
            clearEditText(event)
        }
    }

    private fun clearEditText(event: MotionEvent) {
        val outRect = Rect()
        currentFocus.getGlobalVisibleRect(outRect)
        if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
            currentFocus.clearFocus()
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
 }
