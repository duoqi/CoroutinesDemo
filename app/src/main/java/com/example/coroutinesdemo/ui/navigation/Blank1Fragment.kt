package com.example.coroutinesdemo.ui.navigation

import android.os.Bundle
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

//        val lists = mutableListOf<TestBean>()
//        lists.add(TestBean("2${System.currentTimeMillis()}", "2", "3", 4, 5, "123"))
//        lifecycleScope.launch {
//            context?.let { it ->
//                val dao = AppDatabase.getInstance(it).testDao()
//                dao.insertAll(lists)
//                dao.selectAll().observe(viewLifecycleOwner, Observer {
//                    Log.e(TAG, it[0].plantId)
//                    Log.e(TAG, it.size.toString())
//                })
//            }
//
//        }
//        context?.let {
//            AppDatabase.getInstance(it).testDao().selectAll().observe(viewLifecycleOwner, Observer {
//                Log.e(TAG, it[0].plantId)
//                Log.e(TAG, it.size.toString())
//            })
//        }

    }

    override fun startObserve() {
    }

    companion object {
        private const val TAG = "Blank1Fragment"
    }

}