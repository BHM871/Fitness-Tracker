package co.tiagoaguiar.fitnesstracker.util

import androidx.room.TypeConverter
import java.util.*


object DateConverter {

    @JvmStatic
    @TypeConverter
    fun toDate(longDate: Long?): Date?{
        return if (longDate != null) Date(longDate) else null
    }

    @JvmStatic
    @TypeConverter
    fun fromDate(date: Date?): Long?{
        return date?.time
    }
}