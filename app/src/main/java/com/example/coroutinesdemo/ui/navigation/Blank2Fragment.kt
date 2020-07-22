package com.example.coroutinesdemo.ui.navigation

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.coroutinesdemo.R
import com.example.coroutinesdemo.base.BaseVMFragment
import com.example.coroutinesdemo.data.adapters.Blank2Adapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class Blank2Fragment : BaseVMFragment() {

    private val mViewModel: Blank2ViewModel by viewModel()

    private val mAdapter by lazy { Blank2Adapter() }
    private val datas = mutableListOf<String>()

    override fun getLayoutResId(): Int = R.layout.fragment_blank2

    override fun initView() {
        mBinding.setVariable(BR.adapter, mAdapter)
        mAdapter.loadMoreModule.setOnLoadMoreListener {
            mViewModel.getData()
        }
        mAdapter.data = datas
        mViewModel.getData()
        mAdapter.setOnItemClickListener { _, _, _ ->
            NavHostFragment.findNavController(this).navigate(R.id.blank3Fragment)
        }


    }

    override fun startObserve() {
        mViewModel.run {
            uiState.observe(viewLifecycleOwner, Observer {
                it?.let {
                    datas.addAll(it)
                    mAdapter.loadMoreModule.isEnableLoadMore = true
                    mAdapter.loadMoreModule.loadMoreComplete()
                }
            })
        }
    }

}