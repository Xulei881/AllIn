package com.xulei.allin.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.xulei.allin.R;
import com.xulei.allin.model.MenuModel;
import com.xulei.allin.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends BaseActivity {

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
        MenuModel model = new MenuModel(R.drawable.ic_idcard, "身份证查询");
        list.add(model);
        model = new MenuModel(R.drawable.ic_weather, "天气预报查询");
        list.add(model);
        model = new MenuModel(R.drawable.ic_phone, "手机归属地查询");
        list.add(model);
        model = new MenuModel(R.drawable.ic_idcard, "笑话大全");
        list.add(model);
    }

    @OnItemClick(R.id.id_main_gv)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, LaughActivity.class);
        startActivity(intent);
    }


}
