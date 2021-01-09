package cl.jrod191.novaera.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TelefonoEntity::class, TelefonoDetailEntity::class], version = 1)
abstract class PhoneDatabase : RoomDatabase() {

    abstract fun getTelefonoDao() : TelefonoDao

    companion object {
        @Volatile
        private var INSTANCE: PhoneDatabase? = null

        fun getDatabase(context: Context): PhoneDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhoneDatabase::class.java,
                    "phone_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}