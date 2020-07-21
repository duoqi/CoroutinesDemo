package com.example.coroutinesdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.coroutinesdemo.views.NetProgressDialog

abstract class BaseVMActivity(useDataBinding: Boolean = true) :
    AppCompatActivity() {

    private val _useBinding = useDataBinding
    protected lateinit var mBinding: ViewDataBinding
    protected var netDialog: NetProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        netDialog = NetProgressDialog(this)
        startObserve()
        if (_useBinding) {
            mBinding = DataBindingUtil.setContentView(this, getLayoutResId())
            mBinding.lifecycleOwner = this
        } else setContentView(getLayoutResId())
        initView()
    }

    open fun getLayoutResId(): Int = 0
    abstract fun initView()
    abstract fun startObserve()

}