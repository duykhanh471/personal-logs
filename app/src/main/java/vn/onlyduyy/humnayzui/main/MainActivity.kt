package vn.onlyduyy.humnayzui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //toolbar
        setSupportActionBar(binding.materialToolbar)
        //bottom nav view with nav controller
        val navigationHost = supportFragmentManager.findFragmentById(R.id.mainNavView) as NavHostFragment
        controller = navigationHost.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationView, controller)
    }
}