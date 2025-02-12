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
import com.google.android.material.snackbar.Snackbar
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

 private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val formatUS = NumberFormat.getCurrencyInstance(Locale.US)

        binding.rgPercentage.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId != -1){
        binding.edtPercentual.apply {
            setText("")
            isFocusable = false
            isClickable = false
                }
            }
        }

        binding.edtPercentual.setOnClickListener {
        binding.rgPercentage.clearCheck()
        binding.edtPercentual.apply {
            isFocusableInTouchMode = true
            isClickable = true
            }
        }

        binding.btnCalculator.setOnClickListener {
            val totalTableTemp = binding.edtTieTotal.text
            val NpeopleTemp = binding.edtNumberOfPeople.text

            if (totalTableTemp?.isEmpty() == true || NpeopleTemp?.isEmpty() == true)
                Snackbar
                    .make(binding.tilTieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            else {

            val totalTable: Float = totalTableTemp.toString().toFloat()
            val NPeople: Int = NpeopleTemp.toString().toInt()

            var percentage = 0
            if (binding.edtPercentual.text.toString().isNotEmpty()){
                percentage = binding.edtPercentual.text.toString().toInt()
           }else{
            when (binding.rgPercentage.checkedRadioButtonId){
                  binding.brOptionOne.id -> percentage = 10
                  binding.brOptionTwo.id -> percentage = 15
                  binding.brOpitionThree.id -> percentage = 20
              }
           }
            val TotalTemp = totalTable/NPeople
            val tips = TotalTemp * percentage /100
            val totalWithTips = TotalTemp + tips

            binding.TvResultTotal.text = "Total per person with Tips: ${formatUS.format(totalWithTips)}"
            binding.TvResultTable.text ="Total per person: ${formatUS.format(TotalTemp)}"
        }
      }
        binding.btnClean.setOnClickListener {

        binding.TvResultTotal.text = ""
        binding.TvResultTable.text = ""
        binding.edtPercentual.setText("")
        binding.edtTieTotal.setText("")
        binding.edtNumberOfPeople.setText("")
        binding.brOptionOne.isChecked = false
        binding.brOptionTwo.isChecked = false
        binding.brOpitionThree.isChecked = false

        }
    }
}