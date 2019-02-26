package com.refresh.demo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fly.refresh.ArrowRefreshLayout;
import com.fly.refresh.BaseRefreshLayout;
import com.fly.refresh.DaisyRefreshLayout;

public class ArrowActivity extends AppCompatActivity {
    public static final String TAG = DaisyActivity.class.getSimpleName();
    private ArrowRefreshLayout mRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrow);
        mRefreshLayout = findViewById(R.id.refresh_layout);
        mRefreshLayout.setOnRefreshListener(new ArrowRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.v(TAG,"refresh start");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.v(TAG,"response ok");
                        mRefreshLayout.setRefreshing(false);
                    }
                },1000 * 3);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new ArrowRefreshLayout.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                Log.v(TAG,"loadMore start");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.v(TAG,"response ok");
                        mRefreshLayout.setLoadMore(false);
                    }
                },1000 * 3);
            }
        });
        mRefreshLayout.setOnAutoLoadListener(new ArrowRefreshLayout.OnAutoLoadListener() {
            @Override
            public void onAutoLoad() {
                Toast.makeText(getBaseContext(),"开始加载数据了",Toast.LENGTH_SHORT).show();
            }
        });
        mRefreshLayout.autoRefresh();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        },1000 * 3);
    }
}
