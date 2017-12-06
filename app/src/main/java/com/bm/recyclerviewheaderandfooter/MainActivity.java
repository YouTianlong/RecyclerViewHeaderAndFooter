package com.bm.recyclerviewheaderandfooter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EasyRecyclerView recyclerView;
    private List<String> data;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add("0000");
        data.add("1111");
        data.add("2222");
        data.add("3333");
        data.add("4444");
        data.add("5555");
        data.add("6666");
        data.add("7777");
        data.add("8888");
        data.add("9999");

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        addHeader();
        addFooter();
    }

    private void addFooter() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_header, null, false);
        View inflate1 = LayoutInflater.from(this).inflate(R.layout.layout_header1, null, false);
        recyclerView.addFooterView(inflate);
        recyclerView.addFooterView(inflate1);
        TextView textView = inflate.findViewById(R.id.tv_header);
        textView.setText("11111111111111111111");
        TextView textView1 = inflate1.findViewById(R.id.tv_header1);
        ImageView imageView = inflate1.findViewById(R.id.iv_header1);
        textView1.setText("22222222222222222222");
        imageView.setImageResource(R.mipmap.ic_launcher_round);
    }

    private void addHeader() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_header, null, false);
        View inflate1 = LayoutInflater.from(this).inflate(R.layout.layout_header1, null, false);
        recyclerView.addHeaderView(inflate);
        recyclerView.addHeaderView(inflate1);
        TextView textView = inflate.findViewById(R.id.tv_header);
        textView.setText("11111111111111111111");
        TextView textView1 = inflate1.findViewById(R.id.tv_header1);
        ImageView imageView = inflate1.findViewById(R.id.iv_header1);
        textView1.setText("22222222222222222222");
        imageView.setImageResource(R.mipmap.ic_launcher_round);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(MainActivity.this);
            RecyclerView.LayoutParams layoutParams =
                    new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 300);
            textView.setLayoutParams(layoutParams);
            return new MyHolder(textView);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
           TextView tv = (TextView) holder.itemView;
           tv.setGravity(Gravity.CENTER);
           tv.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{

            public MyHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
