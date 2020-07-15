package com.example.coroutinesdemo.ui.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @Description 登录返回实体
 *
 * @author taodq
 * @Date 2019-08-12.
 */
@Parcelize
data class User(
    val access_token: String,
    val areaCode: String,
    val expire: String,
    val expires_in: Int,
    val jti: String,
    val mobilePhone: String,
    val name: String,
    val refresh_token: String,
    val scope: String,
    val sex: String?,
    val tenantId: String,
    val tenantName: String,
    val token_type: String,
    val userId: String?,
    val username: String
) : Parcelable