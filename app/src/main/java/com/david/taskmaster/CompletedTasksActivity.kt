package com.david.taskmaster


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompletedTasksActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private val completedTaskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completed_tasks)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadCompletedTasks()

        taskAdapter = TaskAdapter(completedTaskList)
        recyclerView.adapter = taskAdapter
    }

    private fun loadCompletedTasks() {

        completedTaskList.apply {
            add(Task("Ir al gimnasio", "Hacer una rutina de ejercicios", "02/10/2024", true))
            add(Task("Reunión de trabajo", "Preparar la presentación para la reunión", "04/10/2024", true))
            add(Task("Preparar la comida", "Cocinar para la familia", "07/10/2024", true))
            add(Task("Revisar correos", "Contestar los correos pendientes", "09/10/2024", true))
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
