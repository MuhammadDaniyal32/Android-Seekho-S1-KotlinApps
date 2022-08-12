package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happybirthday.R.string.tip_amount
import com.example.happybirthday.databinding.ActivityTipCalculaterBinding
import java.text.NumberFormat


class Tip_calculater : AppCompatActivity() {
    private lateinit var binding: ActivityTipCalculaterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* setContentView(R.layout.activity_tip_calculater)*/
        binding = ActivityTipCalculaterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }

    }
    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(tip_amount, formattedTip)
    }
}
