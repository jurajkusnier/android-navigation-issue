package com.juraj.navigationissue

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val navController = supportFragmentManager.findNavController(R.id.nav_host_fragment)
        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.activity_main_bottom_navigation_view)
        setupWithNavController(bottomNavigationView, navController)
    }
}

@Throws(IllegalStateException::class)
fun FragmentManager.findNavController(@IdRes id: Int): NavController {
    val fragment = findFragmentById(id) ?: throw IllegalStateException("Fragment is not found for id:$id")
    return NavHostFragment.findNavController(fragment)
}