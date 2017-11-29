package demo.igeak.com.database.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

/**
 * Created by igeak on 2017/11/20.
 */

@Entity(tableName = "teacher")
public class Teacher {
    @PrimaryKey
    public int id;
    public String firstName;
    public String lastName;
    public String sex;

    @Ignore
    public Bitmap picture;
}
