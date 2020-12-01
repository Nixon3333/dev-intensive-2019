package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.graphics.Rect
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_profile.*

/**
 * Created by Drygin Nikita on 25,Ноябрь,2020
 */

/*
fun Activity.hideKeyboard() {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(rootView.windowToken, 0)
}

fun Activity.isKeyboardOpen(): Boolean {
    val rect = Rect()
    rootView.getWindowVisibleDisplayFrame(rect)
    val heightDiff = rootView.rootView.height - (rect.bottom - rect.top);
    return heightDiff > 100
}

fun Activity.isKeyboardClosed(): Boolean {
    val rect = Rect()
    rootView.getWindowVisibleDisplayFrame(rect)
    val heightDiff = rootView.rootView.height - (rect.bottom - rect.top);
    return heightDiff < 100
}*/
