package com.example.myapplication1

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.promeni_anketu)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fabScan = findViewById<FloatingActionButton>(R.id.fab_scan)

        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home ->                         // TODO: Load Home Fragment
                    return@OnItemSelectedListener true

                R.id.nav_survey ->                         // TODO: Load Survey Fragment
                    return@OnItemSelectedListener true

                R.id.nav_ranking ->                         // TODO: Load Ranking Fragment
                    return@OnItemSelectedListener true

                R.id.nav_profile ->                         // TODO: Load Profile Fragment
                    return@OnItemSelectedListener true
            }
            false
        })

        fabScan.setOnClickListener { v: View? -> }
    }
}