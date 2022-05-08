package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.Random
import androidx.fragment.app.Fragment

class FirstFragment :Fragment(){

    lateinit var countNumber: CountNumber
    override fun onAttach(context: Context) {
        super.onAttach(context)
        countNumber = context as CountNumber
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainView = inflater.inflate(R.layout.fragment_secondary,container,false)
        val countMainNum = requireArguments().getInt("countNum",0)
        val randNum=Random().nextInt(countMainNum)+1
        val randInfo:TextView = mainView.findViewById(R.id.random_info)
        val number:TextView = mainView.findViewById(R.id.number)
        randInfo.text=String.format(getString(R.string.random_info),countMainNum)
        number.text= randNum.toString()
        callCount(randNum)
        return mainView
    }
    private fun callCount(randNum:Int){
        countNumber.countNum(randNum)
    }
}