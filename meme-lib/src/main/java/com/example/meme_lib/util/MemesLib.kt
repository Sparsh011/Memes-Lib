package com.example.meme_lib.util

import android.content.Context
import com.example.meme_lib.network.ApiService
import com.example.meme_lib.network.Meme
import com.example.meme_lib.network.Memes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesLib(private val context: Context) {
    private val retrofitInstance = ApiService()

    fun getMultipleMemes(count: Int, callback: (Memes?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = retrofitInstance.getMemes(count)
                if (response.isSuccessful) {
                    val memes = response.body()
                    callback(memes)
                }
            } catch (e: Exception) {
                callback(null)
            }
        }
    }

    fun getSingleMeme(callback: (Meme?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = retrofitInstance.getMeme()
                if (response.isSuccessful) {
                    val meme = response.body()
                    callback(meme)
                }
            } catch (e: Exception) {
                callback(null)
            }
        }
    }
}



