package com.udacity.shoestore.adapters

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import android.widget.EditText

@InverseBindingAdapter(attribute = "android:text")
fun getDouble(view: EditText): Double {
    return try {
        view.text.toString().toDouble()
    } catch (e: NumberFormatException) {
        0.0
    }
}

@BindingAdapter("android:text")
fun setDoubleToEditText(view: EditText, value: Double) {
    if (value != 0.0) {
        view.setText(value.toString())
    }
}
