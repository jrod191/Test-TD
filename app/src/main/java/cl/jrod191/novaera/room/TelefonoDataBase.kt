package cl.jrod191.novaera.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TelefonoEntity::class, TelefonoDetailEntity::class], version = 1)

abstract class TelefonoDataBase : RoomDatabase() {

    abstract fun getPhoneDao() : TelefonoDao

    companion object {
        @Volatile
        private var INSTANCE: TelefonoDataBase? = null

        fun getDatabase(context: Context): TelefonoDataBase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TelefonoDataBase::class.java,
                    "phone_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}