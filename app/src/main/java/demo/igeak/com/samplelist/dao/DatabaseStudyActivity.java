package demo.igeak.com.samplelist.dao;

import android.arch.persistence.room.Room;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import demo.igeak.com.database.room.Address;
import demo.igeak.com.database.room.AppDatabase;
import demo.igeak.com.database.room.Student;
import demo.igeak.com.samplelist.R;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DatabaseStudyActivity extends AppCompatActivity {

    private static final String TAG = "star";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_study);

       // new Thread(new DatabaseRunnable(this)).start();
        //new TaskAsync().execute();

        createDabaseWithRX();

        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("xxx");
            }
        });

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
                Log.d(TAG, "emit 1");
                e.onNext(1);
            }
        });

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
                Log.d(TAG, "onNext: " + integer);
            }
        };



        //observable.subscribe(consumer);
//thread...
//        observable.subscribeOn(Schedulers.newThread()).
//                observeOn(AndroidSchedulers.mainThread()).
//                subscribe(consumer);
//
//        observable.subscribeOn(Schedulers.newThread()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.d(TAG, "After observeOn(mainThread), current thread is: " + Thread.currentThread().getName()+"the interger is:"+integer);
//            }
//        }).observeOn(Schedulers.io()).doOnNext(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.d(TAG, "After observeOn(io), current thread is : " + Thread.currentThread().getName()+"the interger is:"+integer);
//            }
//        }).subscribe(consumer);


        //map

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).map(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer integer) throws Exception {
//                return "This is result"+integer;
//            }
//        }).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d(TAG,s);
//            }
//        });

        //flatMap

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).subscribeOn(Schedulers.newThread()).flatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(Integer integer) throws Exception {
//
//                Log.d(TAG, "the thread is:"+Thread.currentThread().getName());
//
//                List<String> list = new ArrayList<>();
//                for (int i = 0 ;i <3; i++) {
//                    list.add("I am Value "+integer);
//                }
//
//                return Observable.fromIterable(list).delay(10, TimeUnit.SECONDS);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d(TAG,s);
//            }
//        });

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).subscribeOn(Schedulers.newThread()).concatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(Integer integer) throws Exception {
//
//                Log.d(TAG, "the thread is:"+Thread.currentThread().getName());
//
//                List<String> list = new ArrayList<>();
//                for (int i = 0 ;i <3; i++) {
//                    list.add("I am Value "+integer);
//                }
//
//                return Observable.fromIterable(list).delay(10, TimeUnit.SECONDS);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.d(TAG,s);
//            }
//        });


        //Observable.create(new O)


    }

    public void createDabaseWithRX(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                callDatabase(getApplicationContext());
                e.onNext("ok");
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG,"database create");
            }
        });
    }

    public class TaskAsync extends AsyncTask<Void,Void,Void>{



        @Override
        protected Void doInBackground(Void... voids) {
            callDatabase(getApplicationContext());
            return null;
        }
    }

    public void callDatabase(Context context){
        AppDatabase appDatabase = Room.databaseBuilder(context,AppDatabase.class,"sample.db").build();

        Student student = new Student();
        student.firstName = "wong";
        student.lastName = "star";
        student.age = 10;
        student.sex = "1";
        Address address = new Address();
        address.postCode = 100;
        address.state = "1";
        address.street = "hello";
        student.address = address;
        appDatabase.studentDao().inserStudent(student);
    }


    public class DatabaseRunnable implements  Runnable{

        private Context context;
        public DatabaseRunnable(Context context){
            this.context = context;
        }

        @Override
        public void run() {
            callDatabase(this.context);
        }
    }

}
