package com.vinnymac.swipelistexample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.fortysevendeg.android.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.android.swipelistview.SwipeListView;


public class MainActivity extends Activity {

	private SwipeListView swipeListView;
	
	private ArrayList<String> values;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		swipeListView = (SwipeListView) findViewById(R.id.example_list);
		
		final ArrayAdapter<String> adapter = (ArrayAdapter<String>) buildDummyData();
		
		swipeListView.setSwipeListViewListener(new BaseSwipeListViewListener() {
			@Override
			public void onOpened(int position, boolean toRight) {
			}

			@Override
			public void onClosed(int position, boolean fromRight) {
			}

			@Override
			public void onListChanged() {
			}

			@Override
			public void onMove(int position, float x) {
			}

			@Override
			public void onStartOpen(int position, int action, boolean right) {
				Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
			}

			@Override
			public void onStartClose(int position, boolean right) {
				Log.d("swipe", String.format("onStartClose %d", position));
			}

			@Override
			public void onClickFrontView(int position) {
				Log.d("swipe", String.format("onClickFrontView %d", position));
			}

			@Override
			public void onClickBackView(int position) {
				Log.d("swipe", String.format("onClickBackView %d", position));
			}

			@Override
			public void onDismiss(int[] reverseSortedPositions) {
				for (int position : reverseSortedPositions) {
					adapter.remove(adapter.getItem(position));
					
				}
			}
		});
		
		swipeListView.setAdapter(adapter);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public ListAdapter buildDummyData() {
		final int SIZE = 20;
		values = new ArrayList<String>();
		for (int i = 0; i < SIZE; i++) {
			values.add("Item " + i);
		}
		return new ArrayAdapter<String>(this, R.layout.list_row, R.id.example_row_tv_title, values);
	}
	/**
	 * Settings Options for SwipeListView
	 * 
	 * SettingsManager settings = SettingsManager.getInstance();
	swipeListView.setSwipeMode();
	swipeListView.setSwipeActionLeft();
	swipeListView.setSwipeActionRight();
	swipeListView.setOffsetLeft(convertDpToPixel());
	swipeListView.setOffsetRight(convertDpToPixel());
	swipeListView.setAnimationTime();
	swipeListView.setSwipeOpenOnLongPress();*/

}
