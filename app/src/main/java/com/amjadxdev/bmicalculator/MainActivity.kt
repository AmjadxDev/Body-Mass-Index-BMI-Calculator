package com.amjadxdev.bmicalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amjadxdev.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnCalculate.setOnClickListener {
            calculateBMI()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun calculateBMI() {
        val height = viewBinding.edtHeight.text.toString().toFloatOrNull()
        val weight = viewBinding.edtWeight.text.toString().toFloatOrNull()

        if (weight != null && height != null) {
            val bmi = weight / (height / 100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal"
                bmi < 30 -> "Overweight"
                else -> "Obese"
            }
            viewBinding.tvResult.text = "BMI : $bmiResult\nCategory : $bmiCategory"
        }else{
            viewBinding.tvResult.text = "Invalid Input"
        }
    }
}