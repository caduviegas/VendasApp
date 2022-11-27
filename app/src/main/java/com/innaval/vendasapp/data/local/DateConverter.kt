package com.innaval.vendasapp.data.local

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun toDate(date: Long): Date{
        return Date(date)
    }

    @TypeConverter
    fun fromDate(date:Date):Long{
        return date.time
    }
}