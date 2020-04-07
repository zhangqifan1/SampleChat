package com.as.chatkaige;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.as.chatkaige.bean.MultiBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView rv = findViewById(R.id.rv);
        Button butSend = findViewById(R.id.butSend);
        final EditText et = findViewById(R.id.et);


        final List<MultiBean> list = new ArrayList<>();


        MultiBean left1 = new MultiBean(MultiBean.Type0, "左边第一条");
        MultiBean left2 = new MultiBean(MultiBean.Type0, "左边第二条");
        MultiBean left3 = new MultiBean(MultiBean.Type0, "左边第三条");
        MultiBean left4 = new MultiBean(MultiBean.Type0, "左边第四条");

        MultiBean right1 = new MultiBean(MultiBean.Type1, "右边第一条");
        MultiBean right2 = new MultiBean(MultiBean.Type1, "右边第二条");
        MultiBean right3 = new MultiBean(MultiBean.Type1, "右边第三条");
        MultiBean right4 = new MultiBean(MultiBean.Type1, "右边第四条");


        list.add(left1);
        list.add(left2);
        list.add(left3);
        list.add(left4);
        list.add(right1);
        list.add(right2);
        list.add(right3);
        list.add(right4);

        final MyChatAdapter myChatAdapter = new MyChatAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rv.setAdapter(myChatAdapter);
        rv.setLayoutManager(layoutManager);

        butSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    return;
                }

                et.setText("");

                list.add(new MultiBean(MultiBean.Type1, s));
                myChatAdapter.setNewData(list);

                rv.smoothScrollToPosition(list.size() - 1);
            }
        });


    }
}
