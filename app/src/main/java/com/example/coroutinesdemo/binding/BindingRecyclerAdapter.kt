package com.example.coroutinesdemo.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * @author tdq
 *
 * @date 2020/7/15.
 * @description：描述
 */
@BindingAdapter(value = ["adapter"])
fun RecyclerView.adapter(adapter: RecyclerView.Adapter<*>) {
    setAdapter(adapter)
}