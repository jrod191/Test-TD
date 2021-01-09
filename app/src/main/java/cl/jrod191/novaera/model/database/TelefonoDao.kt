package cl.jrod191.novaera.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.jrod191.novaera.domain.model.Telefono
import cl.jrod191.novaera.data.remote.TelefonoModel

@Dao
interface TelefonoDao {
    @Query("SELECT * FROM phone_table")
    fun getSmallInfo() : LiveData<List<Telefono>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhone(phoneList : List<TelefonoEntity>)

    @Query("SELECT * FROM phone_detail_table WHERE id=:id")
    fun getSingleDetail(id: Int) : LiveData<TelefonoModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailPhone(phoneDetail : TelefonoDetailEntity)
}
