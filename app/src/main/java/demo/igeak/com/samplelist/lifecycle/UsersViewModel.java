package demo.igeak.com.samplelist.lifecycle;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import demo.igeak.com.http.api.ServcieFactory;
import demo.igeak.com.http.model.User;

/**
 * Created by igeak on 2017/11/28.
 */

public class UsersViewModel extends ViewModel{
    private LiveData<List<User>> usrs;
    private ServcieFactory servcieFactory;

    public UsersViewModel(){
        servcieFactory = ServcieFactory.getInstance();
    }


    public void init() {
        if (usrs != null) {
            return;
        }
        usrs = servcieFactory.getUsers();
    }

    public LiveData<List<User>> getUsrs(){
        return this.usrs;
    }


}
