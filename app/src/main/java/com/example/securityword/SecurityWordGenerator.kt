package com.example.securityword

import android.content.Context
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

class SecurityWordGenerator(private val context: Context) {

    private val words: List<String> by lazy {
        context.resources.openRawResource(R.raw.english_words).bufferedReader().useLines { it.toList() }
    }

    fun generateWord(salt: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd-HH", Locale.getDefault())
        val datetimeString = dateFormat.format(Date())
        val combinedInput = "$datetimeString-$salt"
        val hexDigest = sha256(combinedInput)
        val hashInt = hexDigest.substring(0, 16).toBigInteger(16)
        val index = (hashInt % words.size.toBigInteger()).toInt()
        return words[index]
    }

    private fun sha256(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}
