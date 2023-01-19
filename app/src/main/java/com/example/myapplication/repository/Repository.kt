package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.Post

interface Repository {

    fun get ():LiveData<Post>
    fun like()
    fun repost()
}
