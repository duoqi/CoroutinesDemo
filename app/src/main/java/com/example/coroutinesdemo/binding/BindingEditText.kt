package com.example.coroutinesdemo.binding

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter

/**
 * @author tdq
 *
 * @date 2020/7/15.
 * @description：描述
 */
@BindingAdapter(value = ["afterTextChanged"])
fun EditText.afterTextChanged(action: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            action(s.toString())
        }
    })
}