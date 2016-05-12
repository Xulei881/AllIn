package com.xulei.allin.ui.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.xulei.allin.R;
import com.xulei.allin.model.LaughModel;
import com.xulei.allin.presenter.LaughPresenter;
import com.xulei.allin.ui.fragment.CardFragment;
import com.xulei.allin.view.ILaughView;

import butterknife.Bind;

/**
 * Created by xulei on 2016/5/12.
 * 最新笑话
 */
public class LaughActivity extends MVPBaseActivity<ILaughView, LaughPresenter>
        implements ILaughView {

    @Override
    protected LaughPresenter createPresenter() {
        return new LaughPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laugh);
        mPresenter.loadNewLaugh();
    }

    @Override
    public void renderLaugh(LaughModel resp) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, CardFragment.newInstance(resp.getResult().getData()))
                .commitAllowingStateLoss();
    }
}
