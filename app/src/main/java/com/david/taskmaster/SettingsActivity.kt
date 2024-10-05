package com.david.taskmaster
import android.widget.ArrayAdapter
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SettingsActivity : AppCompatActivity() {

    private lateinit var switchNotifications: Switch
    private lateinit var spinnerTheme: Spinner
    private lateinit var buttonAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        switchNotifications = findViewById(R.id.switch_notifications)
        spinnerTheme = findViewById(R.id.spinner_theme)
        buttonAbout = findViewById(R.id.button_about)


        val themes = arrayOf("Claro", "Oscuro", "Sistema")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, themes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTheme.adapter = adapter


        buttonAbout.setOnClickListener {
            Toast.makeText(this, "TaskMaster realizada por David Santiago Galeano Ariza", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
