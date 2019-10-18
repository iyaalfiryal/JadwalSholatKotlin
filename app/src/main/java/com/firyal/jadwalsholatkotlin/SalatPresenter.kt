package com.firyal.jadwalsholatkotlin

import android.content.ClipData
import android.content.Context
import com.firyal.jadwalsholatkotlin.api.RetrofitService
import com.firyal.jadwalsholatkotlin.model.ItemsItem
import com.firyal.jadwalsholatkotlin.model.ResponseSholat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SalatPresenter(context : Context) {
    val salatView = context as SalatView

    fun getDataFromApi(city : String){
        RetrofitService.create()
            .getApi( city )
            .enqueue(object : Callback<ResponseSholat> {
                override fun onFailure(call: Call<ResponseSholat>, t: Throwable) {

                    salatView.onErrorFromApi(t)
                }

                override fun onResponse(
                    call: Call<ResponseSholat>,
                    response: Response<ResponseSholat>
                ) {
                    salatView.onDataFromApi(response.body()?.items?.get(0) as ItemsItem)
                }

            })
    }
}