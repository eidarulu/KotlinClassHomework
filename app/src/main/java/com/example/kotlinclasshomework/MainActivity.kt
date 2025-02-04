package com.example.kotlinclasshomework

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var analytics: Analytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        analytics.onShown()



        // Coroutine Ex
        /*CoroutineScope(Dispatchers.IO + CoroutineName("My first coroutine")).launch {
            delay(3000)
            Log.d("COROUTINE", "Name of thread inside coroutine: ${Thread.currentThread().name}")
            Log.d("COROUTINE", "Name of coroutine inside coroutine: ${coroutineContext[CoroutineName.Key]}")
        }
        Log.d("COROUTINE", "name of thread outside coroutine: ${Thread.currentThread().name}")*/

        /*
        // Flow Ex
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
        }*/
    }
}