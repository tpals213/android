package com.example.slider

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.slider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var position = 0

    private val imageList = listOf(R.drawable.dog, R.drawable.horse, R.drawable.kitten)
    private val quoteList = listOf(
        "스스로를 존경하면 다른 사람도 당신을 존경할 것이다.\n공자",
        "스스로를 행복하다고 생각하지 않는 사람은 행복하지 않다.\n사이러스",
        "권력은 대부분 부패하며, 절대 권력은 절대적으로 부패한다.\n액톤 경"
    )

    private val matrix = ColorMatrix(
        floatArrayOf(
            0.393f, 0.769f, 0.189f, 0f, 0f,
            0.349f, 0.686f, 0.168f, 0f, 0f,
            0.293f, 0.609f, 0.134f, 0f, 0f,
            0f, 0f, 0f, 1f, 0f,
        )
    )
    private val filter = ColorMatrixColorFilter(matrix)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding.textView.text = "안녕하세요"
        movePosition(0)
        binding.btnLeft.setOnClickListener {
            movePosition(-1)
        }
        binding.btnRight.setOnClickListener {
            movePosition(1)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun movePosition(num:Int) {
        position += num
        if (position >= imageList.size) {
            position = 0
        } else if (position < 0) {
            position = imageList.size - 1
        }
        binding.textView.text = quoteList[position]
        binding.imageView2.setImageResource(imageList[position])
        binding.imageView2.colorFilter = filter
    }





}