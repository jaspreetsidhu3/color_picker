package com.example.colorpack;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {
private RelativeLayout relativeLayout1;
private RelativeLayout relativeLayout2;
private RelativeLayout relativeLayout3;
private Button buttonrefresh;
private Button buttonload;
private Button set;
    int cv11=0;
    int cv21=0;
    int cv31=0;
    int cv12=0;
    int cv22=0;
    int cv32=0;
    int cv13=0;
    int cv23=0;
    int cv33=0;
public Random random;
private String arrayListprime[]={"#FFDE03","#0336FF","#0091EA","#F57F17","#546E7A"};
private String arrayListsec[]={"#0336FF","#FFDE03","#00B0FF","#F9A825","#607D8B"};
private String arrayListthird[]={"#FF0266","#FF0266","#40C4FF","#FBC02D","#B0BEC5"};
private TextView textprime;
private TextView textsec;
private EditText textthird;
private Button btnremove;
static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Test", "onCreate: ");
        setContentView(R.layout.activity_main);

        set=findViewById(R.id.set);
        relativeLayout1=findViewById(R.id.relative1);
        relativeLayout2=findViewById(R.id.relative2);
        relativeLayout3=findViewById(R.id.relative3);
        buttonrefresh=findViewById(R.id.refresh);
        textprime=findViewById(R.id.primetext);
        textsec=findViewById(R.id.primesec);
        textthird=findViewById(R.id.primethird);
        buttonload=findViewById(R.id.load);
        textprime.setTextColor(Color.rgb(0,0,0));
        textsec.setTextColor(Color.rgb(0,0,0));
        textthird.setTextColor(Color.rgb(0,0,0));
        btnremove=findViewById(R.id.remove);
        buttonrefresh.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                random=new Random();

                int i=random.nextInt(arrayListprime.length);
                relativeLayout1.setBackgroundColor(Color.parseColor(arrayListprime[i]));
                relativeLayout2.setBackgroundColor(Color.parseColor(arrayListsec[i]));
                relativeLayout3.setBackgroundColor(Color.parseColor(arrayListthird[i]));
                textprime.setText(arrayListprime[i]);
                textsec.setText(arrayListsec[i]);
                textthird.setText(arrayListthird[i]);
               // Drawable drawable=relativeLayout1.getBackground();
                //int c=((ColorDrawable) drawable).getColor();
                //Toast.makeText(getApplicationContext(),""+c,Toast.LENGTH_LONG).show();

            }
        });
        buttonload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SeekBar seekBar1=findViewById(R.id.seek1);
                final SeekBar seekBar2=findViewById(R.id.seek2);
                final SeekBar seekBar3=findViewById(R.id.seek3);
                i++;
                if(i%2==0){
                    seekBar1.setVisibility(GONE);
                    seekBar2.setVisibility(GONE);
                    seekBar3.setVisibility(GONE);
                    btnremove.setVisibility(View.VISIBLE);
                    set.setVisibility(View.VISIBLE);
                    buttonrefresh.setVisibility(View.VISIBLE);

                }
                else{
                    seekBar1.setVisibility(View.VISIBLE);
                    seekBar2.setVisibility(View.VISIBLE);
                    seekBar3.setVisibility(View.VISIBLE);
                    btnremove.setVisibility(GONE);
                    set.setVisibility(GONE);
                    buttonrefresh.setVisibility(GONE);
                    relativeLayout1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();


                            seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv12=progress;
                                    relativeLayout1.setBackgroundColor(Color.rgb(cv12,0,0));
                                    //Toast.makeText(getContext(),""+progress,Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                            seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv22=progress;
                                    relativeLayout1.setBackgroundColor(Color.rgb(cv12,cv22,0));

                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                            seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv32=progress;
                                    relativeLayout1.setBackgroundColor(Color.rgb(cv12,cv22,cv32));

                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                        }
                    });
                    relativeLayout2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();


                            seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv11=progress;
                                    relativeLayout2.setBackgroundColor(Color.rgb(cv11,cv21,cv31));
                                    //Toast.makeText(getContext(),""+progress,Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                            seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv21=progress;
                                    relativeLayout2.setBackgroundColor(Color.rgb(cv11,cv21,0));

                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                            seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv31=progress;
                                    relativeLayout2.setBackgroundColor(Color.rgb(cv11,cv21,cv31));

                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                        }
                    });
                    relativeLayout3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();

                            seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv13=progress;
                                    relativeLayout3.setBackgroundColor(Color.rgb(cv13,0,0));
                                    //Toast.makeText(getContext(),""+progress,Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                            seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv23=progress;
                                    relativeLayout3.setBackgroundColor(Color.rgb(cv13,cv23,0));

                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                            seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    cv33=progress;
                                    relativeLayout3.setBackgroundColor(Color.rgb(cv13,cv23,cv33));

                                }

                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {

                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });
                        }
                    });
                }


            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one="#FFFFFF";
                String two="#FFFFFF";
                String thire="#FFFFFF";
                one=textprime.getText().toString().trim();
                two=textsec.getText().toString().trim();
                thire=textthird.getText().toString().trim();
                try{


                if(TextUtils.isEmpty(one) && TextUtils.isEmpty(two) && TextUtils.isEmpty(thire)){
                    Toast.makeText(getApplicationContext(),"Fill",Toast.LENGTH_SHORT).show();

                }
                if(!one.equals("") && !two.equals("") && !thire.equals("")){
                    relativeLayout3.setBackgroundColor(Color.parseColor(thire));
                    relativeLayout2.setBackgroundColor(Color.parseColor(two));
                    relativeLayout1.setBackgroundColor(Color.parseColor(one));

                }
                else {
                    if (TextUtils.isEmpty(one)) {
                        if (TextUtils.isEmpty(two)) {
                            relativeLayout3.setBackgroundColor(Color.parseColor(thire));
                        } else {
                            relativeLayout2.setBackgroundColor(Color.parseColor(two));

                        }
                    }
                    if (TextUtils.isEmpty(two)) {
                        if (TextUtils.isEmpty(one)) {
                            relativeLayout3.setBackgroundColor(Color.parseColor(thire));

                        } else {
                            relativeLayout1.setBackgroundColor(Color.parseColor(one));

                        }
                    }
                    if (TextUtils.isEmpty(thire)) {
                        if (TextUtils.isEmpty(one)) {
                            relativeLayout2.setBackgroundColor(Color.parseColor(two));


                        } else {
                            relativeLayout1.setBackgroundColor(Color.parseColor(one));

                        }
                    }
                }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are giving wrong input color",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        buttonload.setVisibility(View.VISIBLE);
        buttonrefresh.setVisibility(View.VISIBLE);
        set.setVisibility(View.VISIBLE);
        btnremove.setVisibility(View.VISIBLE);
    }
}
