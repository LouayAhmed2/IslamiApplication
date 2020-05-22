package com.route.islami

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler()
            .postDelayed({
                startMainActivity()
            },2000);
    }

    private fun startMainActivity() {
        val intent = Intent(this@SplashActivity,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
