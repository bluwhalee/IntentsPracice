package com.example.intentspracice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            Intent(Intent.ACTION_MAIN).also{
                it.`package` = "com.google.android.youtube"
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.btnEmail).setOnClickListener {
            Intent(Intent.ACTION_SEND).apply{
                type="text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("t@t.com"))
                putExtra(Intent.EXTRA_SUBJECT, arrayOf("Example Subject"))
                putExtra(Intent.EXTRA_TEXT, arrayOf("hemlo"))
                if(intent.resolveActivity(packageManager) != null)
                {
                    startActivity(this)
                }
            }

        }
    }
}