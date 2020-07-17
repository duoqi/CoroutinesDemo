package com.example.coroutinesdemo.ui

import android.app.Dialog
import android.content.Context
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.coroutinesdemo.R

/**
 * @author taodq
 * @date 2019/8/12.
 * @description：进度框
 */
class NetProgressDialog(context: Context) : Dialog(context) {

    private lateinit var ivProgress: ImageView
    private lateinit var tvInfo: TextView

    init {
        initDialog()
    }

    private fun initDialog() {
        setContentView(R.layout.view_loading_dialog)
        ivProgress = findViewById(R.id.img)
        tvInfo = findViewById(R.id.tv_tip)
    }

    fun setTextTip(tip: String) {
        tvInfo.text = tip
    }

    /**
     * 展示对话框
     */
    fun showDialog() {
        val animation = AnimationUtils.loadAnimation(context, R.anim.anim_dialog_load)
        // 显示动画
        ivProgress.startAnimation(animation)
        show()

    }

    /**
     * 取消对话框
     */
    fun closeDialog() {
        ivProgress.clearAnimation()
        dismiss()
    }

}