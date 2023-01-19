package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.PostRepository
import com.example.myapplication.repository.Repository

class PostViewModel:ViewModel() {
    private  val repository: Repository = PostRepository()
    val data = repository.get()
    fun like() = repository.like()
    fun repost() = repository.repost()
}
