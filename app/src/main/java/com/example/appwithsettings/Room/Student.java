package com.example.appwithsettings.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {
    @PrimaryKey
    public int rollno;

    @ColumnInfo(name = "student_name")
    public String student_name;

    @ColumnInfo(name = "contactno")
    public String contactno;

    @ColumnInfo(name = "gender")
    public String gender;

    public Student(int rollno, String student_name, String contactno, String gender) {
        this.rollno = rollno;
        this.student_name = student_name;
        this.contactno = contactno;
        this.gender = gender;
    }
}
