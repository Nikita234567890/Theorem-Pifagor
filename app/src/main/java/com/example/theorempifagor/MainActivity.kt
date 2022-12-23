package com.example.theorempifagor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.theorempifagor.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClick(view : View){
        var res = getString(R.string.Result) + getResult()
        if (!isEmpty()) binding.tvResult.text = res
        
    }

   private fun isEmpty(): Boolean{
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = getString(R.string.Error)
            if (edB.text.isNullOrEmpty()) edB.error = getString(R.string.Error)
            return edA.text.isNullOrEmpty() && edB.text.isNullOrEmpty()

        }
    }
    private fun getResult ():String{
        var a: Double
        var b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
            return sqrt(a.pow(2) + b.pow(2)).toString()
        }
    }
}