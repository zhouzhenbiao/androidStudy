package com.example.myapplication0001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;

public class MainActivity extends AppCompatActivity {

    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private Button btnTz;
    private Button btnButtonActivity;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        //类型名称	        说明
        //MAP_TYPE_NORMAL	普通地图（包含3D地图）
        //MAP_TYPE_SATELLITE	卫星图
        //MAP_TYPE_NONE	空白地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //开启地图的定位图层
        mBaiduMap.setMyLocationEnabled(true);

        //普通图
        Button btn_ptt = findViewById(R.id.btn_putongtu);
        btn_ptt.setOnClickListener((View view) -> {
            //关闭交通图
            mBaiduMap.setTrafficEnabled(false);
            //关闭热力图
            mBaiduMap.setBaiduHeatMapEnabled(false);


            mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
            Toast.makeText(MainActivity.this, "切换为普通图", Toast.LENGTH_LONG).show();
        });

        //卫星图
        Button btn_wxt = findViewById(R.id.btn_weixingtu);
        btn_wxt.setOnClickListener((View view) -> {
            //关闭交通图
            mBaiduMap.setTrafficEnabled(false);
            //关闭热力图
            mBaiduMap.setBaiduHeatMapEnabled(false);


            mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
            Toast.makeText(MainActivity.this, "切换为卫星图", Toast.LENGTH_LONG).show();
        });
        //路况图
        Button btn_lkt = findViewById(R.id.btn_lukuangtu);
        btn_lkt.setOnClickListener((View view) -> {
            //关闭热力图
            mBaiduMap.setBaiduHeatMapEnabled(false);


            //开启交通图
            mBaiduMap.setTrafficEnabled(true);
            mBaiduMap.setCustomTrafficColor("#ffba0101", "#fff33131", "#ffff9e19", "#00000000");
            //  对地图状态做更新，否则可能不会触发渲染，造成样式定义无法立即生效。
            MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(13);
            mBaiduMap.animateMapStatus(u);
            Toast.makeText(MainActivity.this, "切换为交通图", Toast.LENGTH_LONG).show();
        });
        //百度热力图
        Button btn_rlt = findViewById(R.id.btn_relitu);
        btn_rlt.setOnClickListener((View view) -> {
            //关闭交通图
            mBaiduMap.setTrafficEnabled(false);
            //开启热力图
            mBaiduMap.setBaiduHeatMapEnabled(true);

            mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
            Toast.makeText(MainActivity.this, "切换为热力图", Toast.LENGTH_LONG).show();
        });


        btnTz = findViewById(R.id.btn_tz);
        btnTz.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
            MainActivity.this.startActivity(intent);
        });
        btnButtonActivity = findViewById(R.id.btn_btn_activity);
        btnButtonActivity.setOnClickListener((View view) -> {
            Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
            MainActivity.this.startActivity(intent);
        });
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener((View view) -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            MainActivity.this.startActivity(intent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
}
