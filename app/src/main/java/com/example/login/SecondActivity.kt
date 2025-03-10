package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var txtName: EditText
    private lateinit var txtPass: EditText
    private lateinit var btnGoToThirdActivity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtName = findViewById(R.id.txtName)
        txtPass = findViewById(R.id.txtPass)
        btnGoToThirdActivity = findViewById(R.id.btnGoToThirdActivity)
        setupEventListeners()
    }

    private fun setupEventListeners() {
        btnGoToThirdActivity.setOnClickListener {
            val name = txtName.text.toString()
            val pass = txtPass.text.toString()

            if((name == "admin" && pass == "admin")|| (name == "rodri" && pass == "123"))
            {
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("clientName", name)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "credentials incorrect", Toast.LENGTH_SHORT).show()
            }

        }
    }
}