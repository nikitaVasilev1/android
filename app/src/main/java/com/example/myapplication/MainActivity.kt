package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

       val viewModel by viewModels<PostViewModel>()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                text.text = post.content
                date.text = post.published
                like.setImageResource(
                    if (post.likedByMe) R.drawable.liked else R.drawable.like
                )
                likeText.text = post.numberOfReactrion(post.likes)
                repostText.text = post.numberOfReactrion(post.reposts)
            }
        }

            binding.like.setOnClickListener {
                viewModel.like()
            }

            binding.repost.setOnClickListener {
              viewModel.repost()
        }

    }
}
