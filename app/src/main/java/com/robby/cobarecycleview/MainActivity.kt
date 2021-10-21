package com.robby.cobarecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvContact: RecyclerView by lazy {
        findViewById(R.id.rvContact)
    }

    private val btnAddContant: Button by lazy {
        findViewById(R.id.btnAddContact)
    }

    private val contactAdapter: ContactAdapter by lazy {
        ContactAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContact.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvContact.adapter = contactAdapter

        val dataContact = Constant.contacts
        contactAdapter.addContacts(dataContact)

        btnAddContant.setOnClickListener {
            contactAdapter.addContact(Constant.budi)
            contactAdapter.addContact(Constant.ayu)
            contactAdapter.addContact(Constant.agus)
        }

    }
}