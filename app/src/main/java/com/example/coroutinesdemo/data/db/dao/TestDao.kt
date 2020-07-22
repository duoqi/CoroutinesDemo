package com.example.coroutinesdemo.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coroutinesdemo.data.db.entity.TestBean

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(testBeans: List<TestBean>)

    @Query("SELECT * FROM t_test")
    fun selectAll(): LiveData<List<TestBean>>
}