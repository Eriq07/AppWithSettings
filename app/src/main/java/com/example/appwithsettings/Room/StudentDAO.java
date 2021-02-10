package com.example.appwithsettings.Room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student student);

    // This method will create a DataSource for Paging. It will provide Number of Items required to
    // show on a page. DataSource.Factory is used to creating a DataSource.
    @Query("SELECT * from student_table ORDER BY rollno ASC")
    public abstract DataSource.Factory<Integer, Student> getAllUsers();

    @Query("SELECT * from student_table ORDER BY rollno ASC")
    LiveData<List<Student>> getAllWords();

    @Insert
    Long insertTask(Student student);

   @Update
    void updateTask(Student student);

    @Query("DELETE FROM student_table")
    void deleteAll();

    @Query("SELECT * from student_table LIMIT 1")
    Student[] getAnyWord();



}
