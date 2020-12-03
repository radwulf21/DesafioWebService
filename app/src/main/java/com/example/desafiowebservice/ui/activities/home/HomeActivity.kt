package com.example.desafiowebservice.ui.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiowebservice.R
import com.example.desafiowebservice.service.repository
import com.example.desafiowebservice.ui.activities.DetailsHQActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HQAdapter.OnClickHQListener {
    lateinit var adapterHQ: HQAdapter
    lateinit var gridLayoutManager: GridLayoutManager

    private val viewModel by viewModels<HomeViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(tbHome)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        adapterHQ = HQAdapter(this, this)
        gridLayoutManager = GridLayoutManager(this, 3)
        rvHQ.adapter = adapterHQ
        rvHQ.layoutManager = gridLayoutManager
        rvHQ.hasFixedSize()

        viewModel.getHQ()
        viewModel.HQ.observe(this) {
            adapterHQ.addListHQ(it.data.results)
        }
    }

    override fun onClickHQ(position: Int) {
        val hq = adapterHQ.listHQ[position]

        startActivity(
            Intent(this, DetailsHQActivity::class.java).apply {
                putExtra("hq", hq)
            }
        )
    }
}