//package com.stroke.stroke_android.room_database.dao
//
//import androidx.room.*
//import com.stroke.stroke_android.room_database.entity.UserEntity
//
//@Dao
//interface UserDao {
//
//    @Query("SELECT * FROM user ")
//    fun getUser(type:String): UserEntity
//
//    //For Upcoming
////    @Transaction
////    @Query("SELECT * FROM movies where type=:type")
////    fun getUpcomingMovies(type:String):PagingSource<Int,UserEntity>
////
////    @Insert(onConflict = OnConflictStrategy.REPLACE)
////    suspend fun saveUpcomingMovies( upcomingMovies: List<UserEntity>)
////
////    @Query("DELETE FROM movies where type=:type")
////    suspend fun deleteUpcomingMovies(type: String)
////
////    //For Popular
////    @Transaction
////    @Query("SELECT * FROM movies where type=:type")
////    fun getPopularMovies(type:String):PagingSource<Int,UserEntity>
////
////    @Transaction
////    @Query("SELECT * FROM movies where isFav=:favorite")
////    fun getFavoriteMovies(favorite: Boolean = true ):PagingSource<Int,UserEntity>
////
////    @Insert(onConflict = OnConflictStrategy.REPLACE)
////    suspend fun savePopularMovies(popularMovies: List<UserEntity>)
//
////    @Query("DELETE FROM movies where type=:type")
////    suspend fun delete(type: String)
//
////    @Transaction
////    @Query("select * from movies where id=:id")
////    suspend fun getMovie(id:String):UserEntity
//
////    @Query("update movies set isFav = :favorite where  id = :id")
////    fun toggleFavorite(id: String, favorite: Boolean)
//}
//
