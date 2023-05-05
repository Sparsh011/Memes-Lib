package com.example.meme_lib.network

import okhttp3.Cache
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.dnsoverhttps.DnsOverHttps
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.net.InetAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit

class ApiService {
    private val appCache = Cache(File("cacheDir", "okhttpcache"), 10 * 1024 * 1024)

    private val bootstrapClient = OkHttpClient.Builder()
        .cache(appCache)
        .proxy(Proxy.NO_PROXY)
        .build()

    private val dns = DnsOverHttps.Builder()
        .client(bootstrapClient)
        .url("https://dns.google/dns-query".toHttpUrl())
        .bootstrapDnsHosts(InetAddress.getByName("8.8.4.4"), InetAddress.getByName("8.8.8.8"))
        .build()

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .dns(dns)
        .proxy(Proxy.NO_PROXY)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl("https://meme-api.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(ApiInterface::class.java)

    suspend fun getMemes(limit : Int) : Response<Memes>{
        return api.getMemes(limit)
    }
}