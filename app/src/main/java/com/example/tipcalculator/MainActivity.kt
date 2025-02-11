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

        binding.edtPercentual.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
               binding.rgPercentage.clearCheck()
            }
        }

        binding.btnCalculator.setOnClickListener {
            val totalTable: Float = binding.edtTieTotal.text.toString().toFloat()
            val NPeople: Int = binding.edtNumberOfPeople.text.toString().toInt()

            var percentage = 0
            if (binding.edtPercentual.text.toString().isNotEmpty()){
                percentage = binding.edtPercentual.text.toString().toInt()
            } else{

        binding.brOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 10
            }
        }
        binding.brOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 15
            }
        }
        binding.brOpitionThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 20
            }
          }
        }
            val TotalTemp = totalTable/NPeople
            val tips = TotalTemp * percentage /100
            val totalWithTips = TotalTemp + tips

            println(totalWithTips)
        }


       binding.btnClean.setOnClickListener {  }



    }
}