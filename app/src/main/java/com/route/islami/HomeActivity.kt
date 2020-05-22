package com.route.islami

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        nav_view.setOnNavigationItemSelectedListener{

            var fragment: Fragment?=null
            if(it.itemId == R.id.navigation_quran){
                fragment = SurasFragment()
            }else if (it.itemId== R.id.navigation_sebha){
                fragment= SebhaFeragment()
            }else if (it.itemId==R.id.navigation_radio){
                fragment=RadioFragment()

            }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container,fragment?: SurasFragment())
                .commit()

            return@setOnNavigationItemSelectedListener true

        }
        nav_view.selectedItemId = R.id.navigation_quran
    }
}
