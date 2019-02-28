# FlyRefreshLayout
FlyRefreshLayout刷新组件基于SuperSwipeRefreshLayout进行二次开发，增加了通用小菊花样式DaisyRefreshLayout刷新控件和通用小箭头样式ArrowRefreshLayout刷新控件，支持RecyclerView，NestedScrollView，ScrollView 、ListView，GridView，能自定义HeadView和FooterView，不但支持最基本的下拉刷新、上拉加载更多，还在其基础上扩展了是否启用下拉刷新、是否启用上拉加载更多、增加了自动刷新功能，优化了下拉刷新监听器、上拉加载更多监听器，增加了自动刷新监听器，使其调用更加的方便
### 主要功能
* 支持最基本的下拉刷新、上拉加载更多
* 支持自定义HeadView和FootView
* 支持自动刷新
* 支持启用、禁用下拉刷新
* 支持启用、进攻上拉加载更多
* 通用小菊花样式DaisyRefreshLayout
* 通用小箭头样式ArrowRefreshLayout
### 功能演示：
#### 小菊花样式DaisyRefreshLayout;小箭头样式DaisyRefreshLayout
<div align="left">
<img src="https://github.com/geduo83/FlyRefreshLayout/blob/master/app/src/main/assets/daisy.gif">
<img src="https://github.com/geduo83/FlyRefreshLayout/blob/master/app/src/main/assets/arrow.gif" style="margin-left:100px">  
</div>

### 类关系图
* 基本类图
![](https://img-blog.csdnimg.cn/20190228103457115.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
* FootView关系图<br>
![](https://img-blog.csdnimg.cn/20190228103614680.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
* HeadView关系图<br>
![](https://img-blog.csdnimg.cn/20190228103714141.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dlZHVvXzgz,size_16,color_FFFFFF,t_70)
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

### 问题反馈
在使用中有任何问题，请在下方留言，或加入Android、Java开发技术交流群<br>
QQ群：810970432<br>
email：geduo_83@163.com<br>
![](https://img-blog.csdnimg.cn/20190126213618911.png)<br>
### 关于作者
```
var geduo_83 = {
    nickName  : "门心叼龙",
    site : "http://www.weibo.com/geduo83"
}
```
### License
```
Copyright (C)  menxindiaolong, FlyCloud Framework Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
