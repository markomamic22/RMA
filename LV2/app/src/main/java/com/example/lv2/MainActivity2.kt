package com.example.lv2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity2 : AppCompatActivity() {
    val myFragment = Fragment1()
    val myFragment2 = Fragment2()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2)

        title = "LV2"
        val button: Button = findViewById(R.id.bt_back)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.button_f1)
        button2.setOnClickListener {

            val fragment : Fragment?=

                supportFragmentManager.findFragmentByTag(myFragment::class.java.simpleName)
            if(fragment !is Fragment1){
                supportFragmentManager.beginTransaction()
                    .remove(myFragment2)
                    .add(R.id.fragment_1, myFragment,Fragment1::class.java.simpleName)
                    .commit()
            }

        }

        val button3: Button = findViewById(R.id.button_f2)
        button3.setOnClickListener {

            val fragment : Fragment?=

                supportFragmentManager.findFragmentByTag(myFragment2::class.java.simpleName)
            if(fragment !is Fragment2){
                supportFragmentManager.beginTransaction()
                    .remove(myFragment)
                    .add(R.id.fragment_1, myFragment2,Fragment2::class.java.simpleName)
                    .commit()
            }

        }

        val button4: Button = findViewById(R.id.bt_close)
        button4.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .remove(myFragment)
                .remove(myFragment2)
                .commit()


        }


    }


}