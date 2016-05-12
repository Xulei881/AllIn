package com.xulei.allin.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.xulei.allin.R;
import com.xulei.allin.model.MenuModel;
import com.xulei.allin.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnItemClick;

public class MainActivity extends BaseActivity {

    private final int typeIdCard = 101;
    private final int typeWeather = 102;
    private final int typePhone = 103;
    private final int typeLaugh = 104;

    @Bind(R.id.id_main_gv)
    GridView mainGv;

    private MainAdapter adapter;

    private List<MenuModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadList();
        adapter = new MainAdapter(this, list);
        mainGv.setAdapter(adapter);
    }

    private void loadList() {
        MenuModel model = new MenuModel(typeIdCard, R.drawable.ic_idcard, "身份证查询");
        list.add(model);
        model = new MenuModel(typeWeather, R.drawable.ic_weather, "天气预报查询");
        list.add(model);
        model = new MenuModel(typePhone, R.drawable.ic_phone, "手机归属地查询");
        list.add(model);
        model = new MenuModel(typeLaugh, R.drawable.ic_laugh, "笑话大全");
        list.add(model);
    }

    @OnItemClick(R.id.id_main_gv)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MenuModel model = adapter.getItem(position);
        Intent intent = new Intent();
        switch (model.getId()) {
            case typeIdCard:
                intent.setClass(this, IdCardActivity.class);
                break;
            case typeWeather:
                intent.setClass(this, LaughActivity.class);
                break;
            case typePhone:
                intent.setClass(this, LaughActivity.class);
                break;
            case typeLaugh:
                intent.setClass(this, LaughActivity.class);
                break;
            default:
                intent.setClass(this, ErrorActivity.class);
                break;
        }
        startActivity(intent);
    }

}