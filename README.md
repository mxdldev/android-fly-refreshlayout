# FlyRefreshLayout
FlyRefreshLayout是一个支持下拉刷新、上拉加载更多的自定义控件，支持RecyclerView，NestedScrollView，ScrollView 、ListView，GridView，能自定义HeadView和fooFooterView，基于SuperSwipeRefreshLayout开发，不但支持最基本的下拉刷新、上拉加载更多，还在其基础上扩展了是否启用下拉刷新、是否启用上拉加载更多、自动刷新，停止刷新、停止加载更多等功能，并对其下拉刷新监听器、上拉加载更多监听器进行了优化，使其调用更加的方便
### 主要功能

* 支持最基本的下拉刷新、上拉加载更多
* 支持自定义HeadView和FootView
* 支持自动刷新
* 支持启用、禁用下拉刷新
* 支持启用、进攻上拉加载更多
* 通用小菊花样式DaisyRefreshLayout
* 通用小箭头样式ArrowRefreshLayout
### 小菊花样式DaisyRefreshLayout使用步骤:
#### 1.创建布局文件
```
<?xml version="1.0" encoding="utf-8"?>
<com.fly.refresh.DaisyRefreshLayout
    android:id="@+id/refresh_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:android="http://schemas.android.com/apk/res/android">
    <android.support.v4.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>    
</com.fly.refresh.DaisyRefreshLayout>
```
#### 2.添加下拉刷新监听器
```
 DaisyRefreshLayout mRefreshLayout = findViewById(R.id.refresh_layout);
 mRefreshLayout.setOnRefreshListener(new DaisyRefreshLayout.OnRefreshListener() {
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
```
#### 3.添加上拉加载更多的监听器
```
 mRefreshLayout.setOnLoadMoreListener(new DaisyRefreshLayout.OnLoadMoreListener() {
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
```
#### 4.添加自动刷新监听器
```
 //自动刷新回调监听器
 mRefreshLayout.setOnAutoLoadListener(new DaisyRefreshLayout.OnAutoLoadListener() {
            @Override
            public void onAutoLoad() {
                Toast.makeText(getBaseContext(),"开始加载数据了",Toast.LENGTH_SHORT).show();
            }
        });
//自动刷新调用   
 mRefreshLayout.autoRefresh();
 ```
#### 4.停止刷新
```
mRefreshLayout.setRefreshing(false);
```
#### 5.停止加载更多
```
mRefreshLayout.setLoadMore(false);
```
#### 6.启用、禁用下拉刷新
```
mRefreshLayout.setEnableRefresh(b);
```
#### 7.启用、禁用上拉加载更多
```
mRefreshLayout.setEnableLoadMore(b)
```
### 小箭头样式ArrowRefreshLayout的使用
小箭头样式ArrowRefreshLayout的使用方法和DaisyRefreshLayout的使用类似我就不演示了
### 功能演示：
#### 小菊花样式DaisyRefreshLayout;小箭头样式DaisyRefreshLayout
<div align="left">
<img src="https://github.com/geduo83/FlyRefreshLayout/blob/master/app/src/main/assets/daisy.gif">
<img src="https://github.com/geduo83/FlyRefreshLayout/blob/master/app/src/main/assets/arrow.gif" style="margin-left:50px">  
</div>
