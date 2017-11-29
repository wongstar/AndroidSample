package demo.igeak.com.database.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by igeak on 2017/11/20.
 */

@Database(entities = {Student.class,Teacher.class,Book.class},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract IStudentDao studentDao();
    public abstract IBookDao bookDao();
}
