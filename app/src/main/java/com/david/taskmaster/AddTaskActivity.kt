package com.david.taskmaster

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import java.util.Calendar

class AddTaskActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var tvStartDate: TextView
    private lateinit var tvEndDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        val backButton = findViewById<ImageButton>(R.id.button_back)
        backButton.setOnClickListener {
            finish()
        }


        tvStartDate = findViewById(R.id.tv_start_date)
        tvEndDate = findViewById(R.id.tv_end_date)

        tvStartDate.setOnClickListener { showDatePickerDialog(true) }
        tvEndDate.setOnClickListener { showDatePickerDialog(false) }

        val btnAddTask = findViewById<Button>(R.id.btn_add_task)
        btnAddTask.setOnClickListener {
        //TODO: Agregar funcionalidad guardado tarea
        }
    }

    private fun showDatePickerDialog(isStartDate: Boolean) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                if (isStartDate) {
                    tvStartDate.text = date
                } else {
                    tvEndDate.text = date
                }
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }
}
