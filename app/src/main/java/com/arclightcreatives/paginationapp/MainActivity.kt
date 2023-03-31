package com.arclightcreatives.paginationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.arclightcreatives.paginationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.recyclerMain.layoutManager = LinearLayoutManager(this@MainActivity)

        //recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)
        val adapter = LegothemeAdapter(this)
        binding.recyclerMain.adapter = adapter

        val userViewModel = ViewModelProvider(this,LegothemeViewmodelFactory(this)).get(LegothemeViewmodel::class.java)
        userViewModel.getData().observe(this, object : Observer<PagedList<LegoTheme>> {
            override fun onChanged(t: PagedList<LegoTheme>?) {
                adapter.submitList(t)
            }
        })
    }
}