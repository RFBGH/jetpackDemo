package com.example.rfb.jetpackdemo.room

import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    fun insert(vararg students:Student);

    @Delete
    fun delete(student:Student)

    @Update
    fun update(student: Student)

    @Query("select * from student")
    fun getAll():List<Student>

    @Query("select * from student where name = :name")
    fun getByName(name:String):List<Student>

    @Query("select * from student where id in (:ids)")
    fun getByIds(ids : IntArray):List<Student>

    @Query("delete from student where id = :id ")
    fun deleteUserById(id:Int)

    @Query("update student set name = :updateName where id =  :id")
    fun update(id: Long, updateName: String)
}