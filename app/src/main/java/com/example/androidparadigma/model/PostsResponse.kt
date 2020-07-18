package com.example.androidparadigma.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostsResponse(

    val userId: Int,
    val id: Int,
    val title: String,
    val body: String

):Parcelable