package com.al.bowlight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.al.bowlight.view.ColorPickerView;
import com.al.bowlight.view.TempControlView;

public class MainActivity extends AppCompatActivity {

    private ColorPickerView mPickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView test = findViewById(R.id.test);
        mPickerView = findViewById(R.id.light_view);

        mPickerView.setColorChangedListener(new ColorPickerView.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                test.setText(color+"");
            }
        });




//        TempControlView tempControl = findViewById(R.id.temp_control);
//        // 设置三格代表温度1度
//        tempControl.setAngleRate(3);
//        tempControl.setTemp(16, 37, 16);
//
//        tempControl.setOnTempChangeListener(new TempControlView.OnTempChangeListener() {
//            @Override
//            public void change(int temp) {
//                Toast.makeText(MainActivity.this, temp + "°", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        tempControl.setOnClickListener(new TempControlView.OnClickListener() {
//            @Override
//            public void onClick(int temp) {
//                Toast.makeText(MainActivity.this, temp + "°", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
