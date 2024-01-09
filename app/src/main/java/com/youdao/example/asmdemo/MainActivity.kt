package com.youdao.example.asmdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.youdao.example.asmdemo.R

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_time).setOnClickListener {
            test()
        }
    }

    private fun test() {
        Log.d(TAG, "rrrrrr")
    }
}