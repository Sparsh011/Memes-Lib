package com.example.meme_lib.util

import com.example.meme_lib.network.ApiService
import com.example.meme_lib.network.Meme
import com.example.meme_lib.network.Memes
import kotlinx.coroutines.*

class MemesLib {
    private val retrofitInstance = ApiService()

    fun getMultipleMemes(count: Int, callback: (Memes?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = retrofitInstance.getMemes(count)
                if (response.isSuccessful) {
                    val memes = response.body()
                    withContext(Dispatchers.Main) {
                        callback(memes)
                        return@withContext
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        callback(null)
                        return@withContext
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callback(null)
                    return@withContext
                }
            } finally {
                coroutineContext.cancel()
            }
        }
    }

    fun getSingleMeme(callback: (Meme?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = retrofitInstance.getMeme()
                if (response.isSuccessful) {
                    val meme = response.body()
                    withContext(Dispatchers.Main) {
                        callback(meme)
                        return@withContext
                    }
                }
                else{
                    withContext(Dispatchers.Main){
                        callback(null)
                        return@withContext
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callback(null)
                    return@withContext
                }
            } finally {
                coroutineContext.cancel()
            }
        }
    }
}



