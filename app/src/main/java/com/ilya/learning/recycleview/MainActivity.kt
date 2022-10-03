package com.ilya.learning.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
    var viewModel: MyViewModel? = null



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

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel?.mutableLiveData?.setValue(persons)
        viewModel?.mutableLiveData?.observe(this, userListUpdateObserver)
        }

        var userListUpdateObserver: Observer<ArrayList<Persons>?> =
            Observer<ArrayList<Persons>?> { userArrayList ->
                adapter = PersonAdapter(userArrayList,this@MainActivity, )
                persrecview!!.layoutManager = LinearLayoutManager(this@MainActivity)
                persrecview!!.adapter = adapter
            }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        if (resultCode == RESULT_OK) {
            val person_id = data?.getStringExtra(PERSON_ID)
            val person_name = data?.getStringExtra(PERSON_NAME)
            persons.find { it.id.toString() == person_id }?.name=person_name!!
            viewModel?.mutableLiveData?.setValue(persons)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}