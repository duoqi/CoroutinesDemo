package com.example.coroutinesdemo

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class Blank2Adapter(layoutResId: Int = R.layout.item_blank2) :
    BaseQuickAdapter<String, BaseViewHolder>(layoutResId), LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.text, item)
    }
}