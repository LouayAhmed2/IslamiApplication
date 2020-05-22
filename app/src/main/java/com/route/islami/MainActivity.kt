package com.route.islami

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.adapter.SuraAdapter


class MainActivity : AppCompatActivity() {

    lateinit var adapter:SuraAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // PagerSnapHelper().attachToRecyclerView(recycler_view)
    }
}
