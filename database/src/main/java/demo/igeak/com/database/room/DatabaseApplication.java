package demo.igeak.com.database.room;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.util.Log;

/**
 * Created by igeak on 2017/11/20.
 */

public class DatabaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
//        Log.e("star","application click..");
//        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"sample.db").build();
//
//        Student student = new Student();
//        student.firstName = "wong";
//        student.lastName = "star";
//        student.age = 10;
//        student.sex = "1";
//        Address address = new Address();
//        address.postCode = 100;
//        address.state = "1";
//        address.street = "hello";
//        student.address = address;
//        appDatabase.studentDao().inserStudent(student);
    }
}
