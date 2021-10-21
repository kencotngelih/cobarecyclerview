package com.robby.cobarecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){

    private val contacts: MutableList<Contact> = mutableListOf()

    fun addContacts(contacts: List<Contact>) {
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }

    fun addContact(contact: Contact) {
        this.contacts.add(contact)
        notifyDataSetChanged()
    }


    inner class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view ) {
        fun bind(itemContact: Contact) = itemView.run {
            val tvItemName: TextView = findViewById(R.id.tvNama)
            val tvItemNoHp: TextView = findViewById(R.id.tvHp)
            val tvItemEmail: TextView = findViewById(R.id.tvEmail)
            val tvItemAdress: TextView = findViewById(R.id.tvAlamat)

            tvItemName.text = itemContact.name
            tvItemNoHp.text = itemContact.noHp.toString()
            tvItemEmail.text = itemContact.email
            tvItemAdress.text = itemContact.address
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.layout_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}