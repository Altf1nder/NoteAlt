package ru.altfinder.notealt

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.altfinder.notealt.database.room.dao.AppRoomDatabase
import ru.altfinder.notealt.database.room.dao.repository.RoomRepository
import ru.altfinder.notealt.model.Note
import ru.altfinder.notealt.utils.REPOSITORY
import ru.altfinder.notealt.utils.TYPE_FIREBASE
import ru.altfinder.notealt.utils.TYPE_ROOM

class MainViewModel (application: Application) : AndroidViewModel(application){

    val context = application

    fun initDatabase(type : String,onSuccess: ()-> Unit) {
        Log.d("checkData","MainViewModel initDatabase with type: $type" )
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}