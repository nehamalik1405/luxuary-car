package com.a.luxurycar.code_files.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.a.luxurycar.R
import com.a.luxurycar.databinding.ActivityHomeBinding


import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    lateinit var imageViewMenu: ImageView
    lateinit var imageViewProfile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigation)
        imageViewMenu = findViewById(R.id.imgViewMenu)
        imageViewProfile = findViewById(R.id.imgViewProfile)

        menageClickEvents()

        imageViewProfile.setOnClickListener{
            openOrCloseDrawerProfile()
        }

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)

        binding.navRightView.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                val itemId = item.itemId

                if (itemId == R.id.nav_profiles) {

                }

                binding.drawerLayout.closeDrawer(GravityCompat.START)
                return true
            }
        })


        val navInflater = navHostFragment.navController.navInflater
        val graph = navInflater.inflate(R.navigation.nav_home)

        navController.setGraph(graph, intent.extras)

        NavigationUI.setupWithNavController(
            binding.navView,
            navController
        ) // to connect drawer menu to nav control
        NavigationUI.setupWithNavController(
            bottomNavigation,
            navController
        ) // to connect bottom navigation menu to nav control
        NavigationUI.setupWithNavController(
            binding.navRightView,
            navController
        )

        binding.navView.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                val itemId = item.itemId

                if (itemId == R.id.nav_contact) {

                }

                binding.drawerLayout.closeDrawer(GravityCompat.START)
                return true
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun menageClickEvents() {
        imageViewMenu.setOnClickListener {
            openOrCloseDrawer()
        }
    }

    private fun openOrCloseDrawerProfile() {
        binding.drawerLayout.openDrawer(GravityCompat.END)
    }

    private fun openOrCloseDrawer() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)

        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        val builder1 = AlertDialog.Builder(this)
        builder1.setMessage("Are You Sure You Want to Exit the App?")
        builder1.setCancelable(true)
        builder1.setPositiveButton("Yes") { dialog, id -> super.onBackPressed() }
        builder1.setNegativeButton("No") { dialog, id -> dialog.cancel() }
        val alert11 = builder1.create()
        alert11.show()
    }
    }
