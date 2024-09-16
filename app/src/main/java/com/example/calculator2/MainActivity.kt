package com.example.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private var input = ""
    private var operator = ""
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        // Set up button click listeners
        setupButtons()
    }

    private fun setupButtons() {
        // Angka-angka
        val numberButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9
        )

        // Tambahkan listener untuk tombol angka
        for (id in numberButtons) {
            findViewById<Button>(id).setOnClickListener {
                onDigitPressed((it as Button).text.toString())
            }
        }

        // Operator-operator
        findViewById<Button>(R.id.btnPlus).setOnClickListener { onOperatorPressed("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener { onOperatorPressed("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { onOperatorPressed("*") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { onOperatorPressed("/") }

        // Tombol sama dengan (=)
        findViewById<Button>(R.id.btnEqual).setOnClickListener { onEqualPressed() }
    }

    private fun onDigitPressed(digit: String) {
        input += digit
        tvResult.text = input
    }

    private fun onOperatorPressed(op: String) {
        operand1 = input.toDouble()
        operator = op
        input = ""
    }

    private fun onEqualPressed() {
        operand2 = input.toDouble()
        val result = when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }
        tvResult.text = result.toString()
        input = result.toString() // Simpan hasil untuk operasi berikutnya
    }
}
