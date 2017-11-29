package demo.igeak.com.http.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import demo.igeak.com.http.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by igeak on 2017/11/28.
 */

public class ServcieFactory {

    public static final String BASE_URL ="https://api.github.com";

    private Api api;

    private ServcieFactory() {
        api = getServcie();
    }

    public static volatile ServcieFactory mInstance;


    public static ServcieFactory getInstance(){
        if (mInstance == null ){
            synchronized (ServcieFactory.class) {
                if (mInstance == null ){
                    mInstance = new ServcieFactory();
                }
            }
        }

        return mInstance;
    }


    private  Api getServcie() {
      return  new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build()
                .create(Api.class);

    }






    public LiveData<User> getUsersDetail(String userId){
        final MutableLiveData<User> data = new MutableLiveData<>();
        api.getUserDetail(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return data;
    }


    public LiveData<List<User>> getUsers() {

        final MutableLiveData<List<User>> data = new MutableLiveData<>();

        api.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }

        });
        return data;
    }






}
