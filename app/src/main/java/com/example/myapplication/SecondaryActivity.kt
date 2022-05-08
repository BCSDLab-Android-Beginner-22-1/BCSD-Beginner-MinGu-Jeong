package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class SecondaryActivity:AppCompatActivity(),CountNumber {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val countMainNum=intent.getIntExtra("countNum",0)
        val fragment: Fragment = FirstFragment()
        val arguments=Bundle().apply {
            putInt("countNum",countMainNum)
        }
        fragment.arguments=arguments
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_view,fragment)
            .commit()
    }
    override fun countNum(randNum: Int) {
        returnNum(randNum)
    }
    private fun returnNum(randNum: Int) {
        val intent = Intent(this,MainActivity::class.java).apply {
            putExtra("randNum",randNum)
        }
        setResult(RESULT_OK, intent)
    }
}