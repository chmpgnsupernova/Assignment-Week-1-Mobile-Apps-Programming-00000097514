package com.example.lab_week_01_00000097514

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener   {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()
            val idInput = findViewById<TextInputEditText>(R.id.id_input)
                ?.text.toString().trim()

            if (nameInput.isNotEmpty() && idInput.length == 11) {
                nameDisplay.text = "${getString(R.string.name_greet)} $nameInput\n ${getString(R.string.id_greet)} $idInput"
            }

            else if (idInput.length != 11 && idInput.isNotEmpty()) {
                Toast.makeText(this, "Student ID must be exactly 11 digits", Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
            else if (nameInput.isEmpty() && idInput.isNotEmpty()) {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
            else if (idInput.isEmpty() && nameInput.isNotEmpty()) {
                Toast.makeText(this, getString(R.string.id_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
            else {
                Toast.makeText(this, getString(R.string.all_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }
    }
}
