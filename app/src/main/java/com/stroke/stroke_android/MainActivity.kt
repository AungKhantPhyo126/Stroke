package com.stroke.stroke_android

import android.annotation.SuppressLint
import android.graphics.RenderEffect
import android.graphics.Shader
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewTreeObserver
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var contentHasLoaded = false
    var keep = true
    var DELAY = 1000L
    var animationDelay = 6000L
    @RequiresApi(Build.VERSION_CODES.S)
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition {
            keep
        }
        splashScreen.setOnExitAnimationListener{splashView->
            splashView.view.setBackgroundResource(R.drawable.gradient_animation)
            val animation = splashView.view.background as AnimationDrawable
            animation.setEnterFadeDuration(10)
            animation.setExitFadeDuration(10)
            animation.start()
            val runner = Runnable {
                splashView.remove()
                setContentView(R.layout.activity_main)
            }
            val handler = Handler()
            handler.postDelayed(runner, animationDelay)
        }
        val runner = Runnable { keep = false }
        val handler = Handler()
        handler.postDelayed(runner, DELAY)
//
    }

    fun setUpSplashScreen(splashScreen: SplashScreen){
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (contentHasLoaded) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else false
                }
            }
        )
    }
}