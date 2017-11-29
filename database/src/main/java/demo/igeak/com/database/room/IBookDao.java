package demo.igeak.com.database.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.database.Cursor;

/**
 * Created by igeak on 2017/11/20.
 */
@Dao
public interface IBookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBook(Book book);

    @Query("SELECT * FROM BOOK")
    public Cursor queryAllBook();

}
