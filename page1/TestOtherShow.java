package com.quincy.myditu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 百度地图也能这么玩
 * 
 * @author quincy
 * 
 */
public class TestOtherShow extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// MapView mMapView = new MapView(this, new BaiduMapOptions());
		setContentView(R.layout.activity_testothershow);
		// FrameLayout fl_container =
		// (FrameLayout)findViewById(R.id.fl_container);
		// fl_container.addView(mMapView);

		ListView lv_listview = (ListView) findViewById(R.id.lv_listview);

		View view = View.inflate(TestOtherShow.this, R.layout.list_baidumap,null);
		com.baidu.mapapi.map.TextureMapView inner_bmapView = (com.baidu.mapapi.map.TextureMapView)view. findViewById(R.id.inner_bmapView);

		// 解决百度地图滑动拦截问题
		final View vMap = inner_bmapView.getChildAt(0);
		vMap.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					vMap.getParent().requestDisallowInterceptTouchEvent(true);
				} else {
					vMap.getParent().requestDisallowInterceptTouchEvent(true);
				}
				return false;
			}
		});
		lv_listview.addHeaderView(view);
		lv_listview.setAdapter(new BaiduMapAdapter());
	}

	class BaiduMapAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 30;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//TextView view = new TextView(getApplicationContext());
			//view.setText("测试数据---" + position);
			View view = View.inflate(TestOtherShow.this, R.layout.list_baidumap,null);
			com.baidu.mapapi.map.TextureMapView inner_bmapView = (com.baidu.mapapi.map.TextureMapView)view. findViewById(R.id.inner_bmapView);
			return view;
		}

	}
}
