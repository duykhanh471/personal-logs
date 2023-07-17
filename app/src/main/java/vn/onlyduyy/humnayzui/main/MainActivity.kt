package vn.onlyduyy.humnayzui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
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
        controller = findNavController(R.id.fragmentContainerView)
        binding.bottomNavigationView.setupWithNavController(controller)


    }
}