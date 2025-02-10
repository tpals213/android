package com.example.favorite

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.favorite.databinding.ActivityDetailBinding
import com.example.favorite.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("POSITION", 0)

        val data = listData[position]
        val name = data["name"].toString()
        val birthday = data["birthday"].toString()
        val explain = resources.getString(data["explain"].toString().toInt())

        binding.detailImage.setImageResource(data["image"].toString().toInt())
        binding.detailName.text = name
        binding.detailBirthday.text = birthday
        binding.detailExplain.text = explain

        binding.btnShare.setOnClickListener {
            val subject = "[${name}]을 추천합니다."
            val message = "추천명 : #${name}\n생년월일 : ${birthday}\n\n${explain}"

            val sentIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sentIntent, null)
            startActivity(shareIntent)
        }

    }
}