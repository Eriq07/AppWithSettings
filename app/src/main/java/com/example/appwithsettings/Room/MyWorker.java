package com.example.appwithsettings.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    StudentDAO worKerDao;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

        //Getting DAO
        StudentDatabase db = StudentDatabase.getDatabase(getApplicationContext());
        worKerDao = db.studentDAO();
    }

    @NonNull
    @Override
    public Result doWork() {
        deleteAllWordsBackground();

        return Result.success();
    }

    public void deleteAllWordsBackground(){

        worKerDao.deleteAll();
    }
}
