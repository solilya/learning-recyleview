package com.ilya.learning.recycleview

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView



internal class PersonAdapter(val persons: ArrayList<Persons>,var mContext: Context)  : RecyclerView.Adapter<PersonAdapter.PersonHolder>()  {


        internal inner class PersonHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {
            var person_id_text: TextView = view.findViewById(R.id.person_id)
            var person_name_text: TextView = view.findViewById(R.id.person_name)

            init {
                view.setOnClickListener(this)
            }

            override fun onClick(v: View) {
                mContext.startActivity(Intent(mContext, SecondActivity::class.java).apply
                {
                    putExtra(PERSON_ID, person_id_text.text)
                    putExtra(PERSON_NAME, person_name_text.text)
                })

            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.person_view, parent, false)
            return PersonHolder(itemView)
        }

    override fun onBindViewHolder(holder: PersonAdapter.PersonHolder, position: Int) {
        val person = persons[position]
        holder.apply {
            person_id_text.text = person.id.toString()
            person_name_text.text = person.name
        }
    }

    override fun getItemCount() = persons.size
}