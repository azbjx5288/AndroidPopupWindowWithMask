package com.example.popupwindowwithmask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_popup);


        final TestPopupWindow testPopupWindow = new TestPopupWindow(this, new int[]{R.id.pop_location, R.id.pop_group, R.id.pop_list});

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testPopupWindow.showAsDropDown(textView);
            }
        });

        testPopupWindow.setOnItemClickListener(new TestPopupWindow.OnItemClickListener() {
            @Override
            public void OnItemClick(View v) {
                switch (v.getId()) {
                    case R.id.pop_location:
                        Toast.makeText(MainActivity.this, "地址", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pop_group:
                        Toast.makeText(MainActivity.this, "分组", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pop_list:
                        Toast.makeText(MainActivity.this, "清单", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
