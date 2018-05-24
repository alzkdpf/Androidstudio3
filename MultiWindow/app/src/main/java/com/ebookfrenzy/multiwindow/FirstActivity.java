package com.ebookfrenzy.multiwindow;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if(checkFreeform() == true)
        {
            Toast.makeText(this,"enabled", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"disabled", Toast.LENGTH_SHORT).show();
        }

    }

    //다중 창 통지 확인


    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);

        if(isInMultiWindowMode){
            Toast.makeText(this,"multiple window", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"single window", Toast.LENGTH_SHORT).show();
        }
    }

    public void launchIntent(View view) {
        Intent i = new Intent(this, SecondActivity.class);



        i.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT|
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK|
                Intent.FLAG_ACTIVITY_NEW_TASK);

        Rect rect = new Rect(0, 0, 100, 100);
        ActivityOptions options = ActivityOptions.makeBasic();
        ActivityOptions bounds = options.setLaunchBounds(rect);

        startActivity(i, bounds.toBundle());
    }

    //자유형식 지원확인
    public Boolean checkFreeform() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_FREEFORM_WINDOW_MANAGEMENT);
    }
}
