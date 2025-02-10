package com.example.favorite

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.favorite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listView.adapter =
            SimpleAdapter(
                this,
                listData,
                R.layout.list_item,
                arrayOf("image", "name"),
                intArrayOf(R.id.image, R.id.name)
            )

        binding.listView.setOnItemClickListener {
//                                                parent, view, position, id ->
//            Toast.makeText(this@MainActivity, "${listData[position]["name"]}을 선택했습니다", Toast.LENGTH_SHORT).show()
            _, _, position, _ ->
                startActivity(
                    Intent(this@MainActivity, DetailActivity::class.java)
                        .apply {
                            putExtra("POSITION", position)
                        }
                )
        }

    }
}