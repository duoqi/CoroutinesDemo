package com.example.coroutinesdemo.ui.navigation

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesdemo.R
import com.example.coroutinesdemo.data.adapters.Blank3Adapter
import com.example.coroutinesdemo.base.BaseVMFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class Blank3Fragment : BaseVMFragment() {

    private val mAdapter by lazy { Blank3Adapter() }
    private val mViewModel: Blank3ViewModel by viewModel()

    override fun getLayoutResId(): Int = R.layout.fragment_blank3

    override fun initView() {
        mBinding.setVariable(BR.adapter, mAdapter)
    }

    override fun startObserve() {
        mViewModel.getTestBeans().observe(this, Observer {
            lifecycleScope.launchWhenCreated {
                mAdapter.submitData(it)
            }
        })
    }

}