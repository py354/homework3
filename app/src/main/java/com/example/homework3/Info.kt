package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework3.databinding.ActivityInfoBinding
import com.example.homework3.databinding.ActivityMainBinding

const val WARRIOR_ID_PARAM = "WarriorID"

class Info : AppCompatActivity() {
    lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra(WARRIOR_ID_PARAM, 0)
        val warrior = Repository.army[position]

        with(binding) {
            image.setImageResource(warrior.img)
            name.text = warrior.name
            val desc = "\t" + warrior.description.repeat(5)
            description.text = desc
        }

        binding.back.setOnClickListener {
            finish()
        }
    }
}