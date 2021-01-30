package com.example.desafiowebservice.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.desafiowebservice.R
import com.example.desafiowebservice.domain.Result
import kotlinx.android.synthetic.main.activity_details_hq.*

class DetailsHQActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_hq)

        setSupportActionBar(tbDetailsHQ)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val hq = intent.getParcelableExtra<Result>("hq")

        Glide.with(this).load("${hq?.thumbnail?.path}.${hq?.thumbnail?.extension}").into(ivBackgroundHQ)
        Glide.with(this).load("${hq?.thumbnail?.path}.${hq?.thumbnail?.extension}").into(ivCoverHQ)

        tvTitleHQ.text = if (hq?.title != null) hq.title else "No data"

        tvDescHQ.text = if (hq?.description != null) hq.description else "No data"

        tvPublicationDateHQ.text = if (hq?.dates?.get(0)?.date != null) hq.dates?.get(0)?.date else "No data"

        tvPriceHQ.text = if (hq?.prices?.get(0)?.price != null) hq.prices?.get(0)?.price.toString() else "No data"

        tvNumPagesHQ.text = hq?.pageCount.toString()

        ivCoverHQ.setOnClickListener {
            startActivity(Intent(
                Intent(this, CoverHQActivity::class.java).apply {
                    putExtra("urlHQ", "${hq?.thumbnail?.path}.${hq?.thumbnail?.extension}")
                }
            ))
        }

        // Glide.with(this).load("${hq?.thumbnail?.path}.${hq?.thumbnail?.extension}").into()
    }
}