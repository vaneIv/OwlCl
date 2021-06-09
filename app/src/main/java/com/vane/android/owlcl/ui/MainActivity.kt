package com.vane.android.owlcl.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.vane.android.owlcl.R
import com.vane.android.owlcl.databinding.ActivityMainBinding
import com.vane.android.owlcl.util.contentView
import com.vane.android.owlcl.util.hide
import com.vane.android.owlcl.util.show

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            val navController = Navigation.findNavController(this@MainActivity, R.id.nav_host)
            bottomNav.setupWithNavController(navController)

            //Hide bottom nav on screens which don't require it
            lifecycleScope.launchWhenResumed {
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    when (destination.id) {
                        R.id.myCourses, R.id.featured, R.id.search -> bottomNav.show()
                        else -> bottomNav.hide()
                    }
                }
            }
        }
    }
}