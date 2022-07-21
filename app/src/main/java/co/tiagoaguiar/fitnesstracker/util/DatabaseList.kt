package co.tiagoaguiar.fitnesstracker.util

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.tiagoaguiar.fitnesstracker.model.ItemListCalcu
import co.tiagoaguiar.fitnesstracker.model.ListDao

@Database(entities = [ItemListCalcu::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class  DatabaseList() : RoomDatabase() {

    abstract fun listDao(): ListDao

    companion object{
        private var INSTANCE: DatabaseList? = null

        fun getInstance(context: Context): DatabaseList {
            return if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        DatabaseList::class.java,
                        "fitness_tracker"
                    ).build()
                }
                INSTANCE as DatabaseList
            } else {
                INSTANCE as DatabaseList
            }

        }
    }
}