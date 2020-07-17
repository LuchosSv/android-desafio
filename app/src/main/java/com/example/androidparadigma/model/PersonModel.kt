package com.example.androidparadigma.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonModel(

    @SerializedName("id")
    val personId: String,
    val nombre: String,
    val apellido: String,
    val ocupacion: String,
    val nacimiento: String

):Parcelable