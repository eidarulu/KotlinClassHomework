package com.example.kotlinclasshomework

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d("Flow", "before creating flows")
        val flow = flow {
            for (i in 1..5) {
                delay(1000)
                Log.d("Flow", "Emitting value $i")
                emit(i)
            }
        }

        Log.d("Flow", "Collecting flows, entering the coroutine scope")
        lifecycleScope.launch {
            flow.collect {
                delay(2000)
                Log.d("Flow", "Received value $it")
            }
        }
    }
}