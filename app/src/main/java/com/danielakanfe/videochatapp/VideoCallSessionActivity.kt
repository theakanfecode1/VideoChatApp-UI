package com.danielakanfe.videochatapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.MotionEventCompat

class VideoCallSessionActivity : AppCompatActivity() {
    private lateinit var remoteUserView : CardView
    var mPosX : Float = 0.0f
    var mPosY : Float = 0.0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call_session)


        remoteUserView = findViewById(R.id.local_user_view)
        
        remoteUserView.setOnTouchListener { v, event ->
            val screenWidth = resources.displayMetrics.widthPixels
            val screenHeight = resources.displayMetrics.heightPixels
            val width = v.layoutParams.width
            val height = v.layoutParams.height
            when(MotionEventCompat.getActionMasked(event)){
                MotionEvent.ACTION_DOWN -> {
                    mPosX = v.x - event.rawX
                    mPosY = v.y - event.rawY
                    true
                }

                MotionEvent.ACTION_UP -> {
                    v.performClick()
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    if (width == screenWidth && height == screenHeight){}
                    else{
                        v.animate().x(event.rawX + mPosX)
                            .y(event.rawY + mPosY)
                            .setDuration(0).start()
                        if (event.rawX + mPosX + width > screenWidth) {
                            v.animate()
                                .x(screenWidth - width.toFloat())
                                .setDuration(0)
                                .start();
                        }
                        if (event.rawX + mPosX < 0) {
                            v.animate()
                                .x(0.0f)
                                .setDuration(0)
                                .start();
                        }
                        if (event.rawY + mPosY + height > screenHeight) {
                            v.animate()
                                .y(screenHeight - height.toFloat())
                                .setDuration(0)
                                .start();
                        }
                        if (event.rawY + mPosY < 0) {
                            v.animate()
                                .y(0.0f)
                                .setDuration(0)
                                .start();
                        }

                    }
                    true
                }
                else -> true
            }
        }


    }



    private fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}