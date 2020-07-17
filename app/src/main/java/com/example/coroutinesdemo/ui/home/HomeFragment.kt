package com.example.coroutinesdemo.ui.home

import android.widget.Toast
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import com.example.coroutinesdemo.R
import com.example.coroutinesdemo.base.BaseVMFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseVMFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_home
    private val mViewModel: HomeViewModel by viewModel()

    override fun initView() {
        mBinding.setVariable(BR.viewModel, mViewModel)
    }

    override fun startObserve() {
        mViewModel.apply {
            uiState.observe(this@HomeFragment, Observer { it ->
//                if (it.isLoading) showProgressDialog()
//
//                it.isSuccess?.let {
//                    dismissProgressDialog()
//                    findNavController().navigateUp()
//                }
//
//                it.isError?.let { err ->
//                    dismissProgressDialog()
//                    activity?.toast(err)
//                }
                if(it.isLoading){

                }
                it.isSuccess?.let {
                    Toast.makeText(activity,it.access_token,Toast.LENGTH_SHORT).show()
                }
                it.isError?.let {
                    Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
                }
            })

        }

    }


}