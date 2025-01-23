package com.example.activityandfragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 버튼 세팅
        settingButtons()
    }

    private fun settingButtons(){
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            // 버튼을 클릭 했을 때 처리
            // ::class.java 붙이기
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }
}