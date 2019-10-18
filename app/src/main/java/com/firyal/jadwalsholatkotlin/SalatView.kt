package com.firyal.jadwalsholatkotlin

import android.content.ClipData
import com.firyal.jadwalsholatkotlin.model.ItemsItem

interface SalatView {
    fun onDataFromApi(salat : ItemsItem)
    fun onErrorFromApi(throwable: Throwable)


}