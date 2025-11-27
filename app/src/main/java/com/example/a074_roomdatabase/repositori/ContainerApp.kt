package com.example.a074_roomdatabase.repositori

import android.app.Application
import android.content.Context
import com.example.a074_roomdatabase.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp(private val context: Context):
    ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            DatabaseSiswa.getDatabase(context).siswaDao()
        )
    }
}

class AplikasiSiswa : Application() {
    /* AppController instance digunakan oleh kelas kelas lainnya untuk mendapatkan dependensi*/
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}