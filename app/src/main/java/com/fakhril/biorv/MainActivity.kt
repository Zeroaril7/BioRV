package com.fakhril.biorv

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rv : RecyclerView
    private val dataImage = ArrayList<Galeri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!onBoardingFinished()) {
            val intent = Intent(this, OnBoarding::class.java)
            startActivity(intent)
            overridePendingTransition(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
            finish()
        }


        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()

        rv = findViewById(R.id.table)
        rv.setHasFixedSize(true)
        rv.layoutManager = GridLayoutManager(this, 2)

        val adapter = GaleriAdapter(dataImage)
        rv.adapter = adapter
        addData()
    }

    private fun addData() {
        dataImage.add(Galeri(R.drawable.f1))
        dataImage.add(Galeri(R.drawable.f2))
        dataImage.add(Galeri(R.drawable.f3))
        dataImage.add(Galeri(R.drawable.f4))
        dataImage.add(Galeri(R.drawable.f5))
        dataImage.add(Galeri(R.drawable.f6))
        dataImage.add(Galeri(R.drawable.f7))
        dataImage.add(Galeri(R.drawable.f8))
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref = getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}