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
    var follower : String,
    var following : String,
    var avatar : Int,
) : Parcelable
