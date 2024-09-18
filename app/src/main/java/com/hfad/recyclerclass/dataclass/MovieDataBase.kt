package com.hfad.recyclerclass.dataclass

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hfad.recyclerclass.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [MovieDataClass::class], version = 1, exportSchema = false)
abstract class MovieDataBase: RoomDatabase() {
    abstract fun dao(): DAO

    companion object{
        @Volatile
        private var INSTANCE : MovieDataBase? = null

        fun getInstance(context: Context): MovieDataBase{
            if (INSTANCE == null){
                synchronized(MovieDataBase::class.java){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDataBase::class.java,
                        "name"
                    ).addCallback(object :Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                getInstance(context).dao().insert(getAllMovies())
                            }
                        }
                    }).build()
                }
            }
            return INSTANCE!!
        }

        private fun getAllMovies(): List<MovieDataClass> {

            return arrayListOf(
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Jurrasic", R.drawable.jurasic2),
                MovieDataClass(0, "Batman", R.drawable.batman),
                MovieDataClass(0, "Endgame", R.drawable.endgame),
                MovieDataClass(0, "Hulk", R.drawable.hulk2),
                MovieDataClass(0, "Inception", R.drawable.inception),
                MovieDataClass(0, " Jumanji", R.drawable.jumanji),
                MovieDataClass(0, "Lucy", R.drawable.lucy),
                MovieDataClass(0, "Spiderman", R.drawable.spiderman),
                MovieDataClass(0, "Venom", R.drawable.venom),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Jumanji", R.drawable.jumanji),
                MovieDataClass(0, "Lucy", R.drawable.lucy),
                MovieDataClass(0, "Spiderman", R.drawable.spiderman),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.inception),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Inception", R.drawable.inception),
                MovieDataClass(0, "Avatar", R.drawable.avatar),
                MovieDataClass(0, "Venom", R.drawable.venom),
                MovieDataClass(0, "Jumanji", R.drawable.jumanji),
                MovieDataClass(0, "Endgame", R.drawable.endgame),
                MovieDataClass(0, "Inception", R.drawable.inception),
                MovieDataClass(0, "Hulk", R.drawable.hulk2),
                MovieDataClass(0, "Venom", R.drawable.venom),
                MovieDataClass(0, "Jumanji", R.drawable.jumanji),
                MovieDataClass(0, "Spiderman", R.drawable.spiderman),
                MovieDataClass(0, "Lucy", R.drawable.lucy),

            )
        }
    }
}