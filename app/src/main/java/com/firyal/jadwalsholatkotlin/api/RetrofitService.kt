package com.firyal.jadwalsholatkotlin.api

import com.firyal.jadwalsholatkotlin.model.ResponseSholat
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService{
    @GET("{city}.json?key=1a33e1af585fcc9ccfd3e90fb1170802")
    fun getApi(@Path("city") city : String ): Call<ResponseSholat>

    companion object{
        fun create() : RetrofitService{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://muslimsalat.com/")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }



}