//package com.stroke.stroke_android.room_database
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.stroke.stroke_android.room_database.dao.UserDao
//import com.stroke.stroke_android.room_database.entity.UserEntity
//
//@Database(
//    entities = [
//        UserEntity::class,
//    ],
//    version = 1
//)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun moviesDao(): UserDao
//    companion object {
//        fun create(applicationContext: Context): AppDatabase {
//            return Room.databaseBuilder(
//                applicationContext,
//                AppDatabase::class.java, "AppDatabase"
//            ).allowMainThreadQueries()
//                .build()
//        }
//    }
//}