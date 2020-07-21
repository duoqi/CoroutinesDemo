package com.example.coroutinesdemo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesdemo.data.db.entity.TestBean
import com.example.coroutinesdemo.databinding.ItemBlank2Binding

class Blank3Adapter :
    PagingDataAdapter<TestBean, Blank3Adapter.Blank3ViewHolder>(Blank3DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Blank3ViewHolder {
        return Blank3ViewHolder(
            ItemBlank2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Blank3ViewHolder, position: Int) {
        val data = getItem(position)
        data?.let { holder.bind(it) }
    }

    class Blank3ViewHolder(private val binding: ItemBlank2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                Log.e(TAG, binding.bean!!.plantId)
            }
        }

        fun bind(item: TestBean) {
            binding.apply {
                bean = item
                executePendingBindings()
            }
        }

    }

    companion object{
        private const val TAG = "Blank3Adapter"
    }
}

private class Blank3DiffCallback : DiffUtil.ItemCallback<TestBean>() {
    override fun areItemsTheSame(oldItem: TestBean, newItem: TestBean): Boolean {
        return oldItem.plantId == newItem.plantId
    }

    override fun areContentsTheSame(oldItem: TestBean, newItem: TestBean): Boolean {
        return oldItem == newItem
    }

}


