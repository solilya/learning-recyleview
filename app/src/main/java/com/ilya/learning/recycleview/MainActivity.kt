package com.ilya.learning.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


const val PERSON_ID =
    "com.ilya.learning.recycleview.person_id"
const val PERSON_NAME =
    "com.ilya.learning.recycleview.person_name"

class MainActivity : AppCompatActivity() {

    var persons = arrayListOf<Persons>()
    private lateinit var persrecview: RecyclerView
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 0..20)
        {
            val per=Persons()
            persons.add(per)
        }

        persrecview = findViewById(R.id.person_list)
        adapter = PersonAdapter(persons,this)
        val layoutManager = LinearLayoutManager(applicationContext)
        persrecview.layoutManager = layoutManager
        persrecview.adapter = adapter


    }


}