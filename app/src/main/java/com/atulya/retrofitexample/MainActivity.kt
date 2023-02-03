package com.atulya.retrofitexample

import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.atulya.retrofitexample.databinding.ActivityMainBinding
import com.atulya.retrofitexample.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await

const val TAG = "#MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.rvCharacter.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        lifecycleScope.launch(Dispatchers.IO) {

            try {
                val res = ApiClient.apiService.fetchCharacter("1").await()
                Log.d(TAG, "onCreate: $res")
                launch(Dispatchers.Main) {
                    binding.rvCharacter.adapter = Adapter(res.result)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}