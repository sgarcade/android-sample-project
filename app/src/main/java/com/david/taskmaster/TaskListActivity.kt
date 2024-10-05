package com.david.taskmaster

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadTasks()

        taskAdapter = TaskAdapter(taskList)
        recyclerView.adapter = taskAdapter
    }

    private fun loadTasks() {
        taskList.apply {
            add(Task("Hacer mercado", "Comprar verduras, frutas y lácteos", "01/10/2024", false))
            add(Task("Ir al gimnasio", "Hacer una rutina de ejercicios", "02/10/2024", true))
            add(Task("Lavar la ropa", "Lavar y secar la ropa", "03/10/2024", false))
            add(Task("Reunión de trabajo", "Preparar la presentación para la reunión", "04/10/2024", true))
            add(Task("Limpiar la casa", "Limpiar el polvo y pasar la aspiradora", "05/10/2024", false))
            add(Task("Cita médica", "Ir al chequeo médico anual", "06/10/2024", false))
            add(Task("Preparar la comida", "Cocinar para la familia", "07/10/2024", true))
            add(Task("Entrega de proyecto", "Enviar el proyecto final a tiempo", "08/10/2024", false))
            add(Task("Revisar correos", "Contestar los correos pendientes", "09/10/2024", true))
            add(Task("Sacar al perro", "Sacar al perro al parque", "10/10/2024", false))
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
