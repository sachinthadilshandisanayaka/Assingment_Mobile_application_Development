package com.dissanayake.assigment_mobileapplicationdevelopment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            val toSecondActivity = Intent(this, SecondActivity::class.java)
            startActivity(toSecondActivity)
        }
    }
}