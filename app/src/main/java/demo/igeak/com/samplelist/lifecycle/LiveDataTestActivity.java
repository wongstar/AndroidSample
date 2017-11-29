package demo.igeak.com.samplelist.lifecycle;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.location.Location;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.igeak.common.LogUtil;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.igeak.com.samplelist.R;

public class LiveDataTestActivity extends AppCompatActivity {

    private MutableLiveData<Integer> integerMutableLiveData;
    @BindView(R.id.tvNumber)
    TextView tvNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_test);
        ButterKnife.bind(this);

        integerMutableLiveData = new MutableLiveData<>();
        getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                tvNumber.setText(""+integer);
            }
        });
        LocationLiveData.get(getApplicationContext()).observe(this, new Observer<Location>(){
            @Override
            public void onChanged(@Nullable Location location) {
                LogUtil.d("location change...");
            }
        });
    }

    private LiveData<Integer> getNumber() {
        return integerMutableLiveData;
    }

    @OnClick(R.id.btnChange)
    public void click(View view){
        Random random = new Random();
        //called from the main thread..
        integerMutableLiveData.setValue(random.nextInt(200));
    }

 }
