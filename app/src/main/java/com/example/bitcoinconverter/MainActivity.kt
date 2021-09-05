package com.example.bitcoinconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bitcoinconverter.databinding.ActivityMainBinding

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
        if (naira == null) {
            binding.result.text = " "
            return
        }

        var bitAmount = naira * 3.18

        val roundUp = binding.switchOn.isChecked
        if (roundUp) {
            bitAmount = kotlin.math.ceil(bitAmount)
        }
        val inputText = binding.inputAmount.text

        //val bitResult = java.text.NumberFormat.getCurrencyInstance().format(bitAmount)
        binding.result.text = getString(R.string.bitcoin_amount,inputText, bitAmount.toString())
        //binding.result.text = getString(R.string.bitcoin_amount, bitResult)
    }
}