package com.example.testerapp;

import android.icu.util.Calendar;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String testStr = "";
    private List<Integer> testList = new ArrayList<>();
    final Handler handler = new Handler();
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);


        final TextView t = findViewById(R.id.testText);

        handler.post(new Runnable() {
            @Override
            public void run() {
                android.icu.util.Calendar now = android.icu.util.Calendar.getInstance();
                int day = now.get(android.icu.util.Calendar.DAY_OF_WEEK);
                int hour = now.get(android.icu.util.Calendar.HOUR_OF_DAY);
                int minutes = now.get(Calendar.MINUTE);

                String dayStr = "";

                if (day == 1) {
                    dayStr = "Sunday";
                } else if (day == 2) {
                    dayStr = "Monday";
                } else if (day == 3) {
                    dayStr = "Tuesday";
                } else if (day == 4) {
                    dayStr = "Wednesday";
                } else if (day == 5) {
                    dayStr = "Thursday";
                } else if (day == 6) {
                    dayStr = "Friday";
                } else if (day == 7) {
                    dayStr = "Saturday";
                }
                testStr = dayStr + " " + hour + ":" + minutes;
                t.setText(testStr);
                handler.postDelayed(this, 500);
            }
        });

        Button b = findViewById(R.id.testButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView tw = findViewById(R.id.buttonTV);
                final TextView viewer = findViewById(R.id.finalTest);
                tw.setVisibility(View.VISIBLE);
                Random random = new Random();
                int randomNum = random.nextInt(testList.size());
                int realNum = testList.get(randomNum);
                oscillate(tw, testList, realNum);
                viewer.setVisibility(View.VISIBLE);
                viewer.setText(""+realNum);
            }
        });
    }

    public void oscillate(final TextView tw, final List<Integer> testList, final int finalValue) {
        final MediaPlayer drum = MediaPlayer.create(this, R.raw.drum);
        drum.start();
        drum.setLooping(true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 600);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 1200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 1200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 1800);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tw.setText("" + testList.get(index));
                increaseIndex(testList);
            }
        }, 2400);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drum.setLooping(false);
                drum.stop();
                tw.setText("" + finalValue);
                makeNoise();
            }
        }, 3000);
    }

    public void increaseIndex(List<Integer> testList) {
        index++;
        if (index == testList.size()) {
            index = 0;
        }
    }

    public void makeNoise() {
        MediaPlayer tada = MediaPlayer.create(this, R.raw.tada);
        tada.start();
    }
}
