package com.example.securityword

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val saltEditText = findViewById<EditText>(R.id.saltEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)

        saltEditText.setText(sharedPreferences.getString("salt", "PASSword"))

        saveButton.setOnClickListener {
            val newSalt = saltEditText.text.toString()
            sharedPreferences.edit().putString("salt", newSalt).apply()
            Toast.makeText(this, R.string.salt_saved, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
