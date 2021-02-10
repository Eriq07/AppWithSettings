package com.example.appwithsettings.Room;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.room.Room;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.util.List;

public class StudentRepository {

    private StudentDAO mStudentDAO;
    private LiveData<List<Student>> mAllWords;
    private WorkManager mWorkManager;


    public StudentRepository(Application application) {
        StudentDatabase db = StudentDatabase.getDatabase(application);
        mStudentDAO = db.studentDAO();
        // mAllWords = mWordDao.getAllWords();

        PagedList.Config config = (new PagedList.Config.Builder())
                .setPageSize(20)
                .setEnablePlaceholders(false)
                .setPrefetchDistance(10)
                .build();

        mAllWords = (new LivePagedListBuilder(mStudentDAO.getAllUsers(),config)).build();

        mWorkManager = WorkManager.getInstance(application);
    }

    LiveData<List<Student>> getAllWords() {
        return mAllWords;
    }

    void insert(Student student) {
        StudentDatabase.databaseWriteExecutor.execute(() -> {
            mStudentDAO.insert(student);
        });
    }

    public void deleteAll(){

//        MyWorker worker = new MyWorker()
        //      WorkManager.getInstance().enqueue(request);

        OneTimeWorkRequest blurRequest =
                new OneTimeWorkRequest.Builder(MyWorker.class)
                        .build();

        mWorkManager.enqueue(blurRequest);
    }
}
