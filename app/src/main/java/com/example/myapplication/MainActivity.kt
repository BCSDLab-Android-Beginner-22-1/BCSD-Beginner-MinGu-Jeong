package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val changeActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastButton: Button = findViewById(R.id.toast)
        val countButton: Button = findViewById(R.id.count)
        val randomButton: Button = findViewById(R.id.random)
        val countNumEditable: TextView=findViewById(R.id.number)    //xml파일의 number를 Editable형으로 받음
        var countNum: Int = countNumEditable.toString().toInt()     //Editable형을 String으로 변환 후 Int로 변환

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
        }
    }
}