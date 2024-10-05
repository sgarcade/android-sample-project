package com.david.taskmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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


        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item1 -> {
                    val intent = Intent(this, TaskListActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_item2 -> {
                    startActivity(Intent(this, CompletedTasksActivity::class.java))
                    true
                }
                R.id.nav_item3 -> {
                    startActivity(Intent(this, PendingTasksActivity::class.java))
                    true
                }
                R.id.nav_item4 -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                R.id.action_logout -> {
                    finish()
                    true
                }
                else -> false
            }
        }

        val buttonAddTask = findViewById<Button>(R.id.buttonAddTask)
        buttonAddTask.setOnClickListener {

            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }
}
