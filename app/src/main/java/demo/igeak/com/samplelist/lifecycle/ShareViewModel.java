package demo.igeak.com.samplelist.lifecycle;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import demo.igeak.com.http.model.User;

/**
 * Created by igeak on 2017/11/29.
 */

public class ShareViewModel extends ViewModel{
    MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
    public void selected(User user){
        userMutableLiveData.setValue(user);
    }
    public LiveData<User> getSelected(){
        return userMutableLiveData;
    }
}
