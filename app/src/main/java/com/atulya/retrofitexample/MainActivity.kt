package com.atulya.retrofitexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.atulya.retrofitexample.databinding.ActivityMainBinding
import com.atulya.retrofitexample.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val TAG = "#MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val repository = Repository.get()

        binding.rvCharacter.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        lifecycleScope.launch(Dispatchers.IO) {

            try {
                val people = repository.fetchPeople()
                Log.d(TAG, "onCreate: $people")
                launch(Dispatchers.Main) {
                    binding.rvCharacter.adapter = Adapter(people)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}