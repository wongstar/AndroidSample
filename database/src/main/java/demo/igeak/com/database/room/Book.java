package demo.igeak.com.database.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by igeak on 2017/11/20.
 */

@Entity(tableName = "book", indices = {@Index("title")})
//,foreignKeys = @ForeignKey(entity = Student.class, parentColumns = "id", childColumns = "user_id")
public class Book {
    @PrimaryKey
    public int bookId;
    public String title;
    @ColumnInfo(name = "user_id")
    public int userId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
