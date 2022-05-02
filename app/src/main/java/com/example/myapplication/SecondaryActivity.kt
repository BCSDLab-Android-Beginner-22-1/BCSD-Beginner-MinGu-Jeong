package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Random


class SecondaryActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        var countNum=intent.getIntExtra("countNum",0)
        var randNum=Random().nextInt(countNum)+1
        val randInfo:TextView = findViewById(R.id.random_info)
        var number:TextView=findViewById(R.id.number)
        randInfo.text=String.format(getString(R.string.random_info),randNum)
        number.text= randNum.toString()
        val intent = Intent(this, MainActivity:: class.java)
        intent.putExtra("randNum",randNum)
    }
}