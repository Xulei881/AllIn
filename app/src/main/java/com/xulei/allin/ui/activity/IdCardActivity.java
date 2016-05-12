package com.xulei.allin.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xulei.allin.R;
import com.xulei.allin.model.IdCardModel;
import com.xulei.allin.presenter.IdCardPresenter;
import com.xulei.allin.view.IIdCardView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by xulei on 2016/5/12.
 * idCard查询
 */
public class IdCardActivity extends MVPBaseActivity<IIdCardView, IdCardPresenter>
        implements IIdCardView {

    @Bind(R.id.id_card_num_et)
    EditText idCardEt;

    @Bind(R.id.id_card_info_tv)
    TextView cardInfoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_card);
    }

    @OnClick(R.id.id_card_search_btn)
    void searchInfo() {
        String cardInfo = idCardEt.getText().toString();
        if (TextUtils.isEmpty(cardInfo)) {
            Toast.makeText(this, "输入正确的身份证号码", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.loadIdCardInfo(cardInfo);
    }

    @Override
    protected IdCardPresenter createPresenter() {
        return new IdCardPresenter();
    }


    @Override
    public void renderIdCardInfo(IdCardModel model) {
        IdCardModel.IdCard idCard = model.getResult();
        if (TextUtils.equals("200", model.getResultcode()))
            cardInfoTv.setText("地址:" + idCard.getArea()
                    + "出生年月:" + idCard.getBirthday()
                    + "性别:" + idCard.getSex());
        else
            cardInfoTv.setText(model.getReason());
    }
}
