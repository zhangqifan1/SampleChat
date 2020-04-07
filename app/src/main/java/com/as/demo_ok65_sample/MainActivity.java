package com.as.demo_ok65_sample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View framelayout = findViewById(R.id.framelayout);
        final View defaul = findViewById(R.id.defaul);
        final View change = findViewById(R.id.change);


        framelayout.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int width = v.getWidth();
                int height = v.getHeight();

                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        float x = event.getX();
                        float y = event.getY();

                        //按下点 距上距下
                        int v1 = (int) Math.abs(height - y);
                        float min = Math.min(v1, y);

                        flag = !flag;
                        if (flag) {

                            Animator animator = ViewAnimationUtils.createCircularReveal(
                                    change,//作用在哪个View上面
                                    (int) x,
                                    (int) y,//扩散的中心点
                                    min,//开始扩散初始半径
                                    width);//扩散结束半径
                            animator.setDuration(1000);
                            animator.setInterpolator(new AccelerateInterpolator());

                            change.setVisibility(View.VISIBLE);
                            animator.start();

                            animator.addListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
//                                    tvshow.setVisibility(View.VISIBLE);
                                }
                            });

                        } else {

                            Animator animator = ViewAnimationUtils.createCircularReveal(
                                    change,//作用在哪个View上面
                                    (int) x,
                                    (int) y,//扩散的中心点
                                    width,//开始扩散初始半径
                                    min);//扩散结束半径
                            animator.setDuration(1000);
                            animator.setInterpolator(new AccelerateInterpolator());
                            animator.start();
                            animator.addListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    change.setVisibility(View.GONE);
//                                    tvshow.setVisibility(View.GONE);
                                }
                            });
                        }
                        break;

                    default:
                        break;
                }

                return false;
            }
        });
    }
}
