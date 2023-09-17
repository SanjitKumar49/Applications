package com.sanjit49.fragmentapp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.sanjit49.fragmentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.button.setOnClickListener {
           fragementChenge(Fragment1())
        }
        binding.button2.setOnClickListener {
            fragementChenge(Fragment2())

        }
    }

    private fun fragementChenge(fragment: Fragment) {
val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()
    }

}

/*

binding.button.setOnClickListener {
    // fragementChenge(Fragment1())
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment,Fragment1())
        addToBackStack(null)
        commit()
    }
}

supportFragmentManager.beginTransaction().apply {
    replace(R.id.flFragment,Fragment1())
    commit()
}  */