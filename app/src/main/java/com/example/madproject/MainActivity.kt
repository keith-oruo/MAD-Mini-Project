package com.example.madproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This activity now serves as an entry point to launch the authentication flow.
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish() // Finish this activity so the user can't navigate back to it.
    }
}
