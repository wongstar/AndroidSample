package demo.igeak.com.samplelist.lifecycle;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.igeak.common.LogUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.igeak.com.samplelist.R;
import demo.igeak.com.samplelist.dao.DatabaseStudyActivity;

/**
 * Created by igeak on 2017/11/24.
 */

public class MyLocationActivity extends AppCompatActivity {

    private MyLocationListener myLocationListener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("onCreate........................");
        myLocationListener = new MyLocationListener(getLifecycle());
        setContentView(R.layout.lifecycle_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnJump)
    public void onClick(View view){
        Intent intent = new Intent(this, DatabaseStudyActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d("onResume........................");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d("onRestart........................");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy........................");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d("onStart........................");
    }
}
