package com.firyal.jadwalsholatkotlin

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firyal.jadwalsholatkotlin.model.ItemsItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , SalatView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SalatPresenter(this).getDataFromApi("bandung")
    }

    override fun onDataFromApi(salat: ItemsItem) {
        subuh.text = salat.fajr
        dzuhur.text = salat.dhuhr
        ashar.text = salat.asr
        maghrib.text = salat.maghrib
        isya.text = salat.isha
    }

    override fun onErrorFromApi(throwable: Throwable) {
        error("error -----> ${throwable.localizedMessage}")
        Toast.makeText(this, "Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()


    }



}

