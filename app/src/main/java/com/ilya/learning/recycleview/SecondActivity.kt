package com.ilya.learning.recycleview


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val person_id = intent.getStringExtra(PERSON_ID)
        val person_id_text: TextView = findViewById(R.id.id_sec)
        person_id_text.setText(person_id)

        val person_name = intent.getStringExtra(PERSON_NAME)
        val person_name_text: TextView = findViewById(R.id.name_sec)
        person_name_text.setText(person_name)

        val back_button:TextView = findViewById(R.id.back_button)
        back_button.setOnClickListener { finish()
            }

    }
}