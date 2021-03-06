package com.example.coroutinesdemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.coroutinesdemo.views.NetProgressDialog

abstract class BaseVMFragment(useDataBinding: Boolean = true) : Fragment() {

    private val _useBinding = useDataBinding
    protected lateinit var mBinding: ViewDataBinding

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun startObserve()
    protected var netDialog: NetProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        netDialog = activity?.let { NetProgressDialog(it) }
        return if (_useBinding) {
            mBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
            mBinding.root
        } else
            inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (_useBinding) mBinding.lifecycleOwner = this
        initView()
        startObserve()
        super.onViewCreated(view, savedInstanceState)
    }

}