package com.example.desafiowebservice.ui.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiowebservice.R
import com.example.desafiowebservice.ui.activities.DetailsHQActivity
import com.example.desafiowebservice.ui.adapters.HQAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HQAdapter.OnClickHQListener {
    lateinit var adapterHQ: HQAdapter
    lateinit var gridLayoutManager: GridLayoutManager

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(tbHome)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        adapterHQ = HQAdapter(this)
        gridLayoutManager = GridLayoutManager(this, 3)
        rvHQ.adapter = adapterHQ
        rvHQ.layoutManager = gridLayoutManager
        rvHQ.hasFixedSize()

        viewModel.fillListHQ()
        viewModel.listHQ.observe(this) {
            adapterHQ.addListHQ(it)
        }
    }

    override fun onClickHQ(position: Int) {
        val intent = Intent(this, DetailsHQActivity::class.java)
        startActivity(intent)

    }
}