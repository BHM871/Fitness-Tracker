package co.tiagoaguiar.fitnesstracker.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

data class Button(
    val id: Int,
    @DrawableRes val img: Int,
    @StringRes val text: Int)

@Entity
data class ItemListCalcu(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "res")val res: Double,
    @ColumnInfo(name = "date")val date: Date = Date()
)