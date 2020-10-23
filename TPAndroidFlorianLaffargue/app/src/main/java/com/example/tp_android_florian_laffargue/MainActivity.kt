package com.example.tp_android_florian_laffargue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val andVersionArray = Array<Pizza>(5, { Pizza() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seedItems()

        andVersionRecyclerView.layoutManager = LinearLayoutManager(this)
        andVersionRecyclerView.adapter = PizzaAdapter(andVersionArray)

    }

    fun seedItems() {
        var nameArray = resources.getStringArray(R.array.andVersionName)
        val imgArray = intArrayOf(R.drawable.pizza1, R.drawable.pizza2, R.drawable.pizza3, R.drawable.pizza4, R.drawable.pizza5)
        var descArray = resources.getStringArray(R.array.andVersionDesc)
        for (i in 0..nameArray.size -1)
            andVersionArray[i] = Pizza(nameArray[i], imgArray[i], descArray[i])
    }

}

