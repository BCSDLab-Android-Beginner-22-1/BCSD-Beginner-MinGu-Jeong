package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var countNum:Int = 0
    private lateinit var countTextView: TextView
    private lateinit var changeActivity:ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alertDialogButton: Button = findViewById(R.id.alert_dialog)
        val countButton: Button = findViewById(R.id.count)
        val randomButton: Button = findViewById(R.id.random)

        countTextView=findViewById(R.id.number)
        countTextView.text=countNum.toString()

        alertDialogButton.setOnClickListener{
            val builder=AlertDialog.Builder(this)
            builder.setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.positive_button,
                    DialogInterface.OnClickListener { dialog, id ->
                        countNum=0
                        countTextView.text=countNum.toString()
                })
                .setNeutralButton(R.string.neutral_button,
                    DialogInterface.OnClickListener{ dialog, id ->
                        Toast.makeText(this,getString(R.string.toast_message),Toast.LENGTH_LONG).show()
                    })
                .setNegativeButton(R.string.negative_button,
                    DialogInterface.OnClickListener{ dialog, id ->
                        dialog.dismiss()
                    })
            builder.show()
        }

        countButton.setOnClickListener{
            countNum++
            countTextView.text = countNum.toString()
        }

        changeActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val getNum =it.data!!.getIntExtra("randNum",0)
                countNum = getNum.toString().toInt()
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