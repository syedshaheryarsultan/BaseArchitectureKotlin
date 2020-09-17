package com.example.basearchitecturekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.basearchitecturekotlin.model.PostResponse
import com.example.basearchitecturekotlin.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private var postViewModel : PostViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel!!.init()

        postViewModel!!.posts!!.observe(this, Observer<List<PostResponse?>?>{ posts ->

            Toast.makeText(this, "Api Fetched", Toast.LENGTH_LONG).show()

            for(post in posts.orEmpty()){

                val content2 = buildString {
                    append("\n")
                    append("ID: ${post?.id}")
                    append("\n")
                    append("User ID: ${post?.userId}")
                    append("\n")
                    append("Title: ${post?.title}")
                    append("\n")
                    append("Body: ${post?.body}")
                    append("\n")
                }

                textView.append(content2.toString())

            }

        })
    }
}
