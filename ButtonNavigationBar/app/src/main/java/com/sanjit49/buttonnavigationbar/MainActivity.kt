package com.sanjit49.buttonnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sanjit49.buttonnavigationbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()
        val thirdFragment=ThirdFragment()


        setCurrentFragment(firstFragment)
          binding.btnNavigationView.setOnNavigationItemSelectedListener {
              when (it.itemId){
                  R.id.miHome -> setCurrentFragment (firstFragment)
                  R.id.miMessage->setCurrentFragment(secondFragment)
                  R.id.miProfile -> setCurrentFragment (thirdFragment)
              }
              true
          }
        binding.btnNavigationView.getOrCreateBadge(R.id.miMessage).apply {
            number=100
            isVisible=true
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply{
        replace(R.id.flFragment,fragment)
        commit()

    }

}