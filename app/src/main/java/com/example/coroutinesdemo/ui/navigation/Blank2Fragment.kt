package com.example.coroutinesdemo.ui.navigation

import android.util.Log
import androidx.navigation.Navigation
import com.example.coroutinesdemo.R
import com.example.coroutinesdemo.base.BaseVMFragment
import kotlinx.android.synthetic.main.fragment_blank2.*

class Blank2Fragment : BaseVMFragment(useDataBinding = false) {

    override fun getLayoutResId(): Int = R.layout.fragment_blank2

    override fun initView() {
        tvBlank2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.blank3Fragment)
        }
        val s = arguments?.getString("param1")
        Log.e("444", s!!)
    }

    override fun startObserve() {
    }

}