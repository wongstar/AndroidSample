package demo.igeak.com.samplelist.sample.recycler;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by igeak on 2017/11/8.
 */


public class ClassItem implements Parcelable {


    public String itemName;
    public Intent intent;

    public ClassItem(String itemName,Intent intent) {

        this.itemName = itemName;
        this.intent = intent;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemName);
        dest.writeParcelable(this.intent, flags);
    }

    protected ClassItem(Parcel in) {
        this.itemName = in.readString();
        this.intent = in.readParcelable(Intent.class.getClassLoader());
    }

    public static final Creator<ClassItem> CREATOR = new Creator<ClassItem>() {
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

