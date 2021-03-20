package com.vend.test2.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast

/**
Created By Syed Ovais Akhtar On 3/20/21 4:28 PM2
 **/

fun <T> Context.routeTo(clazz: Class<T>) {
    Intent(this, clazz).also {
        startActivity(it)
    }
}

fun Context.displayToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

@SuppressLint("SetTextI18n")
fun TextView.setPriceText(price:String) {
    this.text = "Price : $price"
}

