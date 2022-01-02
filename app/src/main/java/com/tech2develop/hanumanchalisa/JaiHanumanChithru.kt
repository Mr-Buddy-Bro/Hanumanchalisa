package com.tech2develop.hanumanchalisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class JaiHanumanChithru : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jai_hanuman_chithru)
    }

    fun btnBackPress2(view: android.view.View) {
        onBackPressed()
    }
}