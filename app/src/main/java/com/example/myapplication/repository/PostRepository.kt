package com.example.myapplication.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Post

class PostRepository : Repository {

    private var post = Post(
        id = 1,
        author = "Нетология. Университет интернет - профессий",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия - помочь встать на путь роста и начать цепочку перемен - http://netolo.gy/fyb</string>",
        published = "21 мая в 18:36"
    )
    val data = MutableLiveData(post)

    override fun get() = data

    override fun like() {
        post = post.copy(
            likedByMe = !post.likedByMe,
            likes = if (post.likedByMe) post.likes - 1 else post.likes + 1
        )
        data.value = post
    }

    override fun repost() {
        post = post.copy(reposts = post.reposts + 10)
        data.value = post
    }

}
