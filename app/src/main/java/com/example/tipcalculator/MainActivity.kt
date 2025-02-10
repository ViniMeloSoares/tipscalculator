package com.example.tipcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

 private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.brOptionOne.setOnCheckedChangeListener { _, isChecked -> }
        binding.brOptionTwo.setOnCheckedChangeListener { _, isChecked -> }
        binding.brOpitionThree.setOnCheckedChangeListener { _, isChecked -> }

       binding.btnClean.setOnClickListener {  }



    }
}