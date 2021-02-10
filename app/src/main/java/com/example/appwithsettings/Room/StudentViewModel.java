package com.example.appwithsettings.Room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository mRepository;
    private LiveData<List<Student>> mAllStudents;

    public StudentViewModel(@NonNull Application application) {
        super(application);

        mRepository = new StudentRepository(application);
        mAllStudents = mRepository.getAllWords();
    }


}
