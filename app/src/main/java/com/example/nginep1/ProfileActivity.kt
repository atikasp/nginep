package com.example.nginep1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnBack = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}