package com.example.desafiowebservice.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.desafiowebservice.R
import kotlinx.android.synthetic.main.activity_details_hq.*

class DetailsHQActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_hq)

        setSupportActionBar(tbDetailsHQ)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        ivCoverHQ.setOnClickListener {
            llCoverHQExpanded.visibility = View.VISIBLE
        }

        ivCloseCoverHQExpanded.setOnClickListener {
            llCoverHQExpanded.visibility = View.GONE
        }
    }
}