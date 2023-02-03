package com.atulya.retrofitexample

import android.app.Application
import com.atulya.retrofitexample.repository.Repository

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Repository.init()
    }
}