package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerViewAdapter
    val nameDatas= mutableListOf<NameData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.recycler_view)
        val addButton:ImageButton=findViewById(R.id.add_name)
        val nameEditText:EditText=findViewById(R.id.write_name)

        addButton.setOnClickListener{
            adapter.addData(NameData(nameEditText.text.toString()))
        }
        adapter.setOnItemClickListener {
            val builder=AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.ask_delete))
                .setPositiveButton(getString(R.string.choice_yes)){
                        _,_-> adapter.removeData(it)
                }
                .setNegativeButton(getString(R.string.choice_no)){
                        dialog,_->dialog.dismiss()
                }
            builder.show()
        }
        adapter.setOnItemLongClickListener {

        }
    }



}