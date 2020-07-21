package com.example.coroutinesdemo.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.coroutinesdemo.base.BaseRepository
import com.example.coroutinesdemo.data.db.entity.TestBean
import kotlinx.coroutines.flow.Flow

class Blank3Repository : BaseRepository() {

    fun getTestDatas(): Flow<PagingData<TestBean>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 25),
            pagingSourceFactory = { Blank3DataSource() }
        ).flow
    }
}

class Blank3DataSource() : PagingSource<Int, TestBean>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TestBean> {
        return try {
            val page = params.key ?: 0
            val datas = mutableListOf<TestBean>()
            for (data in 1..100) {
                datas.add(
                    TestBean(
                        data.toString(),
                        "1",
                        imageUrl = "22",
                        description = "343",
                        growZoneNumber = 1,
                        wateringInterval = 2
                    )
                )
            }
            LoadResult.Page(
                //需要加载的数据
                data = datas,
                //如果可以往上加载更多就设置该参数，否则不设置
                prevKey = null,
                //加载下一页的key 如果传null就说明到底了
                nextKey = page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}