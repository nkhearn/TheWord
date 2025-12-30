package com.example.securityword

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var universalWordDisplay: TextView
    private lateinit var securityWordGenerator: SecurityWordGenerator
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        universalWordDisplay = findViewById(R.id.universalWordDisplay)
        securityWordGenerator = SecurityWordGenerator(this)

        runnable = Runnable {
            updateWord()
            handler.postDelayed(runnable, 1000 * 60) // Check every minute
        }
    }

    override fun onResume() {
        super.onResume()
        handler.post(runnable)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    private fun updateWord() {
        val sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val salt = sharedPreferences.getString("salt", "PASSword") ?: "PASSword"
        val word = securityWordGenerator.generateWord(salt)
        universalWordDisplay.text = word
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
