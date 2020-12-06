package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AddInvertebrates extends AppCompatActivity {

    Spinner Invertebrates;
    Button Cancel;
    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invertebrates);

        Invertebrates = findViewById(R.id.spinnerChooseInverte);
        Cancel = findViewById(R.id.ButtonInverteCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        final ArrayAdapter adapterInverte =  ArrayAdapter.createFromResource(this,R.array.ArrayInvertebrates,R.layout.spinner_item);
        adapterInverte.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Invertebrates.setAdapter(adapterInverte);





        Cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Cancel.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    startActivity(new Intent(getApplicationContext(),AddAnimal.class));
                    overridePendingTransition(R.anim.slide_in_left,
                            R.anim.slide_out_right);}
                return true;
            }
        });
    }
}