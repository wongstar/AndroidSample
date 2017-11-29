package demo.igeak.com.database.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

import demo.igeak.com.database.greendao.User;
import io.reactivex.Flowable;

/**
 * Created by igeak on 2017/11/20.
 */
@Dao
public interface IStudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertStudents(Student... students);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void inserStudent(Student student);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateStudent(Student student);

    @Delete
    public void deleteStudent(Student student);

    @Query("SELECT * FROM students")
    public Student[] loadAllStudents();

    @Query("select * from students where age > :minAge")
    public Student[] loadAllStudentsOlderThan(int minAge);


    @Query("SELECT * FROM students WHERE age> :minAge AND age< :maxAge")
    public Student[] loadAllStudentsBetweenAges(int minAge,int maxAge);

    @Query("SELECT first_name,last_name FROM students")
    public List<NameTuple> loadFullName();

    @Query("SELECT * FROM STUDENTS WHERE id = :id")
    public Flowable<Student> loadUserById(int id);

    @Query("SELECT * FROM STUDENTS")
    public Cursor loadUserByCusor();

}
