package com.example.a074_roomdatabase

import android.app.Application

class AplikasiSiswa : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        // Panggil ContainerDataApp yang sekarang berada di package repositori
        container = ContainerDataApp(this)
    }
}