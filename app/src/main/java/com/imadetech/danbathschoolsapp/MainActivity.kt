package com.imadetech.danbathschoolsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        onNewIntent(intent)

        val Dambath: LinearLayout = findViewById(R.id.danbath)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide)
        Dambath.startAnimation(slideAnimation)

/*
        val slideAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slide2)
        val dot: ImageView = findViewById(R.id.dotsimage)
        dot.startAnimation(slideAnimation2)



        val slideAnimation3 = AnimationUtils.loadAnimation(this, R.anim.slide3)
        val loading: ImageView = findViewById(R.id.loading)
        loading.startAnimation(slideAnimation3)
*/
        val slideAnimation4 = AnimationUtils.loadAnimation(this, R.anim.slidedown)
        val dropbottom: ImageView = findViewById(R.id.drop_bottom)
        dropbottom.startAnimation(slideAnimation4)

        val slideAnimation5 = AnimationUtils.loadAnimation(this, R.anim.slideup)
        val droptop: ImageView = findViewById(R.id.drop_top)
        droptop.startAnimation(slideAnimation5)
    }


    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val extras = intent.extras
        if (extras != null) {
            if (extras.containsKey("title")) {
                val notificationtitle = extras.getString("title")
                if (notificationtitle!!.contains("Update")) {
                    val background: Thread = object : Thread() {
                        override fun run() {
                            try {
                                val intent2 = Intent(Intent.ACTION_VIEW)
                                intent2.data = Uri.parse("market://details?id=com.imadetech.danbathschoolsapp")
                                try {
                                    startActivity(intent2)
                                } catch (e: Exception) {
                                    intent2.data = Uri.parse("https://play.google.com/store/apps/details?id=com.imadetech.danbathschoolsapp")
                                }
                                // Thread will sleep for 5 seconds
                                sleep((3 * 1000).toLong())

                                // After 5 seconds redirect to another intent


                                //Remove activity
                                finish()
                            } catch (e: Exception) {
                            }
                        }
                    }
                    // start thread
                    background.start()
                    val i = Intent(baseContext, Main2Activity::class.java)
                    startActivity(i)
                    /*
                } else if (notificationtitle.contains("Calender")) {
                    val intent2 = Intent(this@MainActivity, newsletter::class.java)
                    intent2.putExtra("activity", "Calender")
                    intent2.putExtra("category", "Update Calender")
                    startActivity(intent)
                    finish()
                } else if (notificationtitle.contains("Newsletter")) {
                    val intent2 = Intent(this@MainActivity, newsletter::class.java)
                    intent2.putExtra("activity", "Newsletter")
                    intent2.putExtra("category", "Upload Newsletters")
                    startActivity(intent)
                    finish()
                } else if (notificationtitle.contains("Event")) {
                    val intent2 = Intent(this@MainActivity, newsletter::class.java)
                    intent2.putExtra("activity", "Events")
                    intent2.putExtra("category", "Upload Upcoming Event")
                    startActivity(intent)
                    finish()
                } else if (notificationtitle.contains("Assignment")) {
                    val intent2 = Intent(this@MainActivity, selectstudentclass::class.java)
                    intent2.putExtra("activity", "assignment")
                    startActivity(intent)
                    finish()
                } else if (notificationtitle.contains("Timetable")) {
                    val intent2 = Intent(this@MainActivity, newsletter::class.java)
                    intent2.putExtra("activity", "Timetable")
                    intent2.putExtra("category", "Update Timetable")
                    startActivity(intent)
                    finish()

                     */
                } else {
                    val background: Thread = object : Thread() {
                        override fun run() {
                            try {
                                // Thread will sleep for 5 seconds
                                sleep((3 * 1000).toLong())

                                // After 5 seconds redirect to another intent
                                val i = Intent(baseContext, Main2Activity::class.java)
                                startActivity(i)

                                //Remove activity
                                finish()
                            } catch (e: Exception) {
                            }
                        }
                    }
                    // start thread
                    background.start()
                }
            } else {
                /****** Create Thread that will sleep for 5 seconds */
                val background: Thread = object : Thread() {
                    override fun run() {
                        try {
                            // Thread will sleep for 5 seconds
                            sleep((3 * 1000).toLong())

                            // After 5 seconds redirect to another intent
                            val i = Intent(baseContext, Main2Activity::class.java)
                            startActivity(i)

                            //Remove activity
                            finish()
                        } catch (e: Exception) {
                        }
                    }
                }
                // start thread
                background.start()
            }
        } else {
            /****** Create Thread that will sleep for 5 seconds */
            val background: Thread = object : Thread() {
                override fun run() {
                    try {
                        // Thread will sleep for 5 seconds
                        sleep((3 * 1000).toLong())

                        // After 5 seconds redirect to another intent
                        val i = Intent(baseContext, Main2Activity::class.java)
                        startActivity(i)

                        //Remove activity
                        finish()
                    } catch (e: Exception) {
                    }
                }
            }
            // start thread
            background.start()
        }
    }

}
