package com.example.lv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun BMI(cm: Int, kg: Int): Double {
            val m = cm.toDouble() /100
            return kg / (m.pow(2.0))
        }


        findViewById<Button>(R.id.button).setOnClickListener {
            val text = findViewById<View>(R.id.ime_prezime) as EditText
            val value = text.text.toString()
            val text2 = findViewById<View>(R.id.opis) as EditText
            val value2 = text2.text.toString()
            val textView = findViewById<TextView>(R.id.textView2)
            val textView2 = findViewById<TextView>(R.id.textView3)

            textView.text = value
            textView2.text = value2
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val text = findViewById<View>(R.id.cm) as EditText
            val value = Integer.parseInt(text.text.toString())
            val text2 = findViewById<View>(R.id.kg) as EditText
            val value2 = Integer.parseInt(text2.text.toString())
            val bmi = BMI(value,value2)

            Toast.makeText(this, bmi.toString(),
                Toast.LENGTH_LONG).show()


        }





    }
}