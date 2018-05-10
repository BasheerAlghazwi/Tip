package com.example.android.tipcalculation;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {
    private EditText BillAmount;
    private EditText Party;
    private EditText Tip;
    private EditText total;
    private CheckBox checkBox;
    private SeekBar seekBar;
    private RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BillAmount = findViewById(R.id.B);
        Party=findViewById(R.id.party);
        Tip=findViewById(R.id.T);
        total=findViewById(R.id.tot);
        checkBox=findViewById(R.id.checkbox);
        seekBar=findViewById(R.id.Seekbar);
        layout = findViewById(R.id.col);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }
    public void buttonPressed(View v){
        Intent i = new Intent(this,ColorActivity.class);
        startActivityForResult(i,1 );
        String intput = BillAmount.getText().toString();
        String p = Party.getText().toString();
        float billa = Float.parseFloat(intput);
        float pa = Float.parseFloat(p);
        seekBar.getProgress();
        float tip = billa*seekBar.getProgress()/100;
        float tota = (billa+tip);
        if (checkBox.isChecked()){
            tota = tota/pa;
        }else{
            total.setText("$"+String.format("%.2f",tota));
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        int color = data.getIntExtra(" COLOR", 0xFFFF0000);
        layout.setBackgroundColor(color);
    }

    public void calculat(View v){
        String intput = BillAmount.getText().toString();
        String p = Party.getText().toString();
        float billa = Float.parseFloat(intput);
        float pa = Float.parseFloat(p);
        seekBar.getProgress();
        float tip = billa*seekBar.getProgress()/100;
        float tota = (billa+tip);
        if (checkBox.isChecked()){
            tota = tota/pa;
        }else{
            total.setText("$"+String.format("%.2f",tota));
        }



    }

}
