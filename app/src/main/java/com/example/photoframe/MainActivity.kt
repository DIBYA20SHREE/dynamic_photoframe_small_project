package com.example.photoframe

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    private lateinit var image: ImageView
    private var names = arrayOf("Harry Potter", "Hermione Granger", "Ron Weasley", "Draco Malfoy")

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val prev = findViewById<ImageButton>(R.id.IV2)
        val next = findViewById<ImageButton>(R.id.IV3)
        val text = findViewById<TextView>(R.id.TV)

        prev.setOnClickListener{
            val idCurrentImageString = "Img$currentImage"
            // convert string id into address associated with it

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (4+currentImage-1)%4

            val idImageToShowString = "Img$currentImage"
            // convert string id into address with it

            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id",packageName)

            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentImage]

        }
        next.setOnClickListener {
            val idCurrentImageString = "Img$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (4+ currentImage+1)%4
            val idImageToShowString = "Img$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentImage]
        }

    }
}