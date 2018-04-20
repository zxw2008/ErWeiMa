package view.zhengxiaolong.bw.com.erweima;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEwm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MPermissions.requestPermissions(MainActivity.this, 100,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET,
                Manifest.permission.WAKE_LOCK,
                Manifest.permission.READ_EXTERNAL_STORAGE
        );
    }

    @PermissionGrant(100)
    public void requestSdcardSuccess() {
        Toast.makeText(this, "获取权限成功!", Toast.LENGTH_SHORT).show();
    }

    @PermissionDenied(100)
    public void requestSdcardFailed() {
        Toast.makeText(this, "获取权限失败!", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mBtnEwm = (Button) findViewById(R.id.btn_Ewm);
        mBtnEwm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_Ewm:
                OptionsScannerActivity.gotoActivity(this);
                break;
        }
    }
}
