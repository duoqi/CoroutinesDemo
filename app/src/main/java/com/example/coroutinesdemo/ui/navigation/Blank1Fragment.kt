package com.example.coroutinesdemo.ui.navigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.coroutinesdemo.R
import com.example.coroutinesdemo.base.BaseVMFragment
import kotlinx.android.synthetic.main.fragment_blank1.*

class Blank1Fragment : BaseVMFragment(useDataBinding = false) {

    override fun getLayoutResId(): Int = R.layout.fragment_blank1

    override fun initView() {
        tvBlank1.setOnClickListener {
            findNavController(this).navigate(R.id.blank2Fragment, Bundle().apply {
                putString("param1", "222")
            })
        }

        Log.e("Blank1Fragment", "initView")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Blank1Fragment", "onAttach")
    }

    override fun startObserve() {
    }

}