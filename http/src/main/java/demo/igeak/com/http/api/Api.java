package demo.igeak.com.http.api;

import java.util.List;

import demo.igeak.com.http.model.User;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by igeak on 2017/11/28.
 */

public interface Api {

    @GET("users/{userId}")
    Call<User> getUserDetail(@Path("userId") String user);


    @GET("users")
    Call<List<User>> getUsers();

    @GET("users")
    Observable<List<User>> getUsersByRX();

}
