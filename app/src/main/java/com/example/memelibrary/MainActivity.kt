package com.example.memelibrary

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.meme_lib.util.MemesLib

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img = findViewById<ImageView>(R.id.image)

        val button = findViewById<Button>(R.id.btn_make_request)
        val pb = findViewById<ProgressBar>(R.id.pb)
        pb.visibility = View.GONE


        button.setOnClickListener {
            pb.visibility = View.VISIBLE
            val memesLib = MemesLib()

//            memesLib.getMultipleMemes(4) { response ->
//                val memes = response!!.memes // necessary
//                Toast.makeText(applicationContext, "${memes.size}", Toast.LENGTH_SHORT).show()
//
//                Glide.with(this@MainActivity)
//                    .load(memes[0].url)
//                    .into(img)
//            }

//            memesLib.getSingleMeme { response ->
//                val meme = response!!
//                Glide.with(this@MainActivity)
//                    .load(meme.url)
//                    .into(img)
//            }
        }
    }
}