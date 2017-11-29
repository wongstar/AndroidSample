package demo.igeak.com.database.room;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by igeak on 2017/11/20.
 */

public class NameTuple {
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "last_name")
    public String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
