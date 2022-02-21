package com.danielakanfe.videochatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ContactsActivity : AppCompatActivity(){
    private val TAG = "ContactsActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.contacts_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.add_contact -> {
                Log.d(TAG, "onOptionsItemSelected: ${item.itemId}")
                Toast.makeText(applicationContext, "THIS", Toast.LENGTH_SHORT).show()
                true
            }
            else -> true

        }
    }
}