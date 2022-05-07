package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    var countNum:Int = 0
    private lateinit var countTextView: TextView
    private lateinit var changeActivity:ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toastButton: Button = findViewById(R.id.toast)
        val countButton: Button = findViewById(R.id.count)
        val randomButton: Button = findViewById(R.id.random)

        countTextView=findViewById(R.id.number)
        countTextView.text=countNum.toString()

        toastButton.setOnClickListener{
            Toast.makeText(this, "토스트 메시지 입니다!", Toast.LENGTH_LONG).show()
        }

        countButton.setOnClickListener{
            countNum++
            countTextView.text=countNum.toString()
        }

        changeActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode== RESULT_OK){
                val getNum =it.data!!.getIntExtra("randNum",0)
                countNum=getNum.toString().toInt()
                countTextView.text=countNum.toString()
            }
        }

        randomButton.setOnClickListener {
            val intent = Intent(this, SecondaryActivity:: class.java)
            intent.putExtra("countNum", countNum)
            changeActivity.launch(intent)
        }
    }
}