package com.example.desafiowebservice.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.desafiowebservice.R
import kotlinx.android.synthetic.main.activity_cover_hq.*

class CoverHQActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover_hq)

        val urlHQ = intent.getStringExtra("urlHQ")

        Glide.with(this).load(urlHQ).into(ivCoverHQExpanded)
    }
}