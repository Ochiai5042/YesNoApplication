package com.toshiki.yesnoapplication;

import android.graphics.Color;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.toshiki.yesnoapplication.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomOnClickListener listainer = new CustomOnClickListener();
        findViewById(R.id.mainLayout).setOnClickListener(listainer);

    }
    class CustomOnClickListener implements View.OnClickListener{
        int count = 0;
        @Override
        public void onClick(View view) {
            Log.d("CustomOnClickListainer", "クリックされたよ");
            TextView t = (TextView)findViewById(R.id.pe);
            ConstraintLayout crLayout = (ConstraintLayout)findViewById(R.id.mainLayout);
            Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);

            if(this.count > 20) {
                crLayout.setBackgroundColor(Color.RED);
                t.setText("いい加減にしろ");
                t.setTextColor(Color.BLACK);
                v.vibrate(10000);
            }else {
                this.count++;
                Log.d("CustomOnClickListainer", String.valueOf(count));
                v.vibrate(100);
                int resRandom = (int) (Math.random() * 2);
                if (resRandom == 1) {
                    crLayout.setBackgroundColor(Color.BLACK);
                    t.setText("No");
                    t.setTextColor(Color.WHITE);
                } else {
                    crLayout.setBackgroundColor(Color.WHITE);
                    t.setText("Yes");
                    t.setTextColor(Color.BLACK);
                }
            }
        }
    }
}
