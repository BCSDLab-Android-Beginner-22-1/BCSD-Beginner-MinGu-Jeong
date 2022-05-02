package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val changeActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){  }
 //   private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   //     Log.e(TAG,"Log출력")

        val toastButton: Button = findViewById(R.id.toast)
        val countButton: Button = findViewById(R.id.count)
        val randomButton: Button = findViewById(R.id.random)
        val countNumEditable: TextView=findViewById(R.id.number)    //xml파일의 number를 Editable형으로 받음
        var countNum:Int = 0

        toastButton.setOnClickListener{
            Toast.makeText(this, "토스트 메시지 입니다!", Toast.LENGTH_LONG).show()
        }
        countButton.setOnClickListener{
            countNum++
            countNumEditable.text=countNum.toString()
        }
        randomButton.setOnClickListener {
            val intent = Intent(this, SecondaryActivity:: class.java)
            intent.putExtra("countNum",countNum)
            changeActivity.launch(intent)
            countNum=intent.getIntExtra("randNum",0)
            countNumEditable.text=countNum.toString()
        }

    }
}