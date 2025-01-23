package com.example.activityandfragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TwoColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_two_color)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        settingButtons()

    }

    private fun settingButtons(){
        val blueButton = findViewById<Button>(R.id.button_blue_fragment)
        val redButton = findViewById<Button>(R.id.button_red_fragment)

        redButton.setOnClickListener {
            // 트랜잭션
            val fragmentTrans = supportFragmentManager.beginTransaction()
            fragmentTrans.replace(R.id.fragmentFrame, RedFragment())
            fragmentTrans.commit()
        }
        blueButton.setOnClickListener {
            val fragmentTrans = supportFragmentManager.beginTransaction()
            fragmentTrans.replace(R.id.fragmentFrame, BlueFragment())
            fragmentTrans.commit()
        }




    }
}