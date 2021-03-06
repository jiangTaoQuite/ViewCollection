package com.kevin.android.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;

import com.kevin.android.R;
import com.kevin.android.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Class: MainActivity </br>
 * Description: text page </br>
 * Creator: Kevin </br>
 * Date: 2016/8/20 12:24 </br>
 * Update: 2016/8/20 2016/8/20 </br>
 */
public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.onItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @InjectView(R.id.main_recycler)
    RecyclerView mIndexRecycler;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;

    private RecyclerViewAdapter mAdapter;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setUpAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setUpAdapter() {
        mDatas = new ArrayList<>();
        mDatas.add("仙女散花");
        mDatas.add("View事件分发");
        mDatas.add("Dialog测试");
        mDatas.add("蒙层");
        mDatas.add("心形view");
        mDatas.add("带有虚线和文字的view");
        mDatas.add("StepView");
        mAdapter = new RecyclerViewAdapter(this,mDatas);
        mIndexRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        mIndexRecycler.addItemDecoration(null);
        mIndexRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onClick(int position, String value) {
        Log.d(TAG, "onClick: "+value);
        switch (position){
            case 0:
                FlowerActivity.startFlower(MainActivity.this);
                break;
            case 1:
                EventDistributionActivity.startEventDistribution(MainActivity.this);
                break;
            case 2:
                DialogActivity.startDialog(MainActivity.this);
                break;
            case 3:
                MaskLayerDialogActivity.startMaskLayer(MainActivity.this);
                break;
            case 4:
                HeartViewActivity.startHeartView(MainActivity.this);
                break;
            case 5:
                DashLineActivity.startDashLine(MainActivity.this);
                break;
            case 6:
                StepViewActivity.startStepView(MainActivity.this);
                break;
        }
    }
}
