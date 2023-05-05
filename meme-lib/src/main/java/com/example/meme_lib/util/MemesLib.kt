package com.example.meme_lib.util

import com.example.meme_lib.network.ApiService
import com.example.meme_lib.network.Memes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesLib {
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

    fun getSingleMeme(callback: (Memes?) -> Unit){

    }
}
