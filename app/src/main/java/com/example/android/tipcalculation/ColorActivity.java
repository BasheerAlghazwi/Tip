package com.example.android.tipcalculation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Switch;

/**
 * Created by android on 3/20/18.
 */

public class ColorActivity extends AppCompatActivity {
    private int color;
    private RadioGroup group;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        group = findViewById(R.id.RG);
        color = 0xFF000000;

        group.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch(i){
                            case R.id.whiteButton:
                            color = 0xFFFFFFFF; break;
                            case R.id.cayanButton:
                            color = 0xFF00FFFF; break;
                            case R.id.BlackButton:
                            color=0xFFFFFF00; break;
                        }
                    }
                }
        );

    }
    public void onBackPressed(){
        Intent data = new Intent();
        data.putExtra("COLOR", color);
        setResult(RESULT_OK,data);
    }
}
