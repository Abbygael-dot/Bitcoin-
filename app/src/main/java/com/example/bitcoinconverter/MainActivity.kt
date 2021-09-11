package com.example.bitcoinconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bitcoinconverter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener {
            convertToBit()
        }
    }

    private fun convertToBit() {
        val naira = binding.inputAmount.text.toString().toDoubleOrNull()
        if (naira == null || naira == 0.00) {
            displayAmount(estimatedAmount = 0.00)
            return
        }

        val bitAmount = (naira * 0.00000005345)
        var estimatedAmount = String.format("%.2f", bitAmount).toDouble()

        val roundUp = binding.switchOn.isChecked
        if (roundUp) {
            estimatedAmount = kotlin.math.round(estimatedAmount)
        }

        displayAmount(estimatedAmount)
    }

    private fun displayAmount(estimatedAmount: Double) {
        val bitResult = NumberFormat.getNumberInstance().format(estimatedAmount)
        binding.result.text = getString(R.string.bitcoin_amount, bitResult)
    }
}