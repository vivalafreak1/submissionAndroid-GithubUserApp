package com.example.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username : String,
    var name : String,
    var location : String,
    var repository : String,
    var company : String,
    var follower : Int,
    var following : Int,
    var avatar : Int,
) : Parcelable
