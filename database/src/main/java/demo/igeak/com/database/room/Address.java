package demo.igeak.com.database.room;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by igeak on 2017/11/20.
 */

public class Address {
    public String street;
    public String state;
    @ColumnInfo(name = "post_code")
    public int postCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}
