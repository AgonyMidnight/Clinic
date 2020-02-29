package com.example.clinic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.clinic.personal_account.personal_account
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomNavigation: BottomNavigationView? = null
        var bottomPersonal = findViewById(R.id.navigation_lk) as Button
        var bottomService = findViewById(R.id.navigation_service) as Button
        var bottomTime = findViewById (R.id.navigation_timetable) as Button
        var bottomSupport = findViewById(R.id.navigation_support) as Button



        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            bottomNavigation = findViewById(R.id.bottom_navigation)

        }

    }


}
