package co.tiagoaguiar.fitnesstracker.model

import androidx.room.*

@Dao
interface ListDao {

    @Insert
    fun insert(itemListCalcu: ItemListCalcu)

    @Query("SELECT * FROM ItemListCalcu WHERE type = :type")
    fun getListCalcuByType(type: String?): List<ItemListCalcu>

    @Query("SELECT * FROM ItemListCalcu WHERE id = :id")
    fun getCalcuById(id: Int?): ItemListCalcu

    @Delete
    fun deleteItem(itemListCalcu: ItemListCalcu)

    @Update
    fun updateItem(itemListCalcu: ItemListCalcu)
}