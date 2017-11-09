package demo.igeak.com.samplelist.sample;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by igeak on 2017/11/8.
 */


public class ClassItem implements Parcelable {

    public String className;
    public String itemName;

    public ClassItem(String className, String itemName) {
        this.className = className;
        this.itemName = itemName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.className);
        dest.writeString(this.itemName);
    }

    protected ClassItem(Parcel in) {
        this.className = in.readString();
        this.itemName = in.readString();
    }

    public static final Parcelable.Creator<ClassItem> CREATOR = new Parcelable.Creator<ClassItem>() {
        @Override
        public ClassItem createFromParcel(Parcel source) {
            return new ClassItem(source);
        }

        @Override
        public ClassItem[] newArray(int size) {
            return new ClassItem[size];
        }
    };
}

