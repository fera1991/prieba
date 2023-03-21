package com.example.ejemplolab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var numberEditText: EditText
    private lateinit var actionResultButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        setLisener()
    }

    private fun binding(){
        numberEditText = findViewById(R.id.number_edit_text)
        actionResultButton = findViewById(R.id.action_calculate_button)
        resultTextView = findViewById(R.id.result_text_view)
    }

    private fun setLisener(){
        actionResultButton.setOnClickListener {
            val number = numberEditText.text.toString()

            if (number.isNullOrEmpty()){
                Toast.makeText(this, "El Dato esta Vacio!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            result(number.toFloat())
        }
    }
    private fun result(number: Float){
        if (number <= 5){
            resultTextView.text = "Muy Mal"
            resultTextView.setTextColor(ContextCompat.getColor(this, R.color.obese))
        }
        if (number >= 6 && number <= 8){
            resultTextView.text = "Acceptable"
            resultTextView.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
        }
        if (number > 8 && number <= 10){
            resultTextView.text = "Excelente"
            resultTextView.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
        }
    }
}