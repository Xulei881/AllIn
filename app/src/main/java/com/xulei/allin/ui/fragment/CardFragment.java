package com.xulei.allin.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xulei.allin.R;
import com.xulei.allin.model.LaughModel;
import com.xulei.allin.utils.SystemUtils;
import com.xulei.allin.widget.cardview.CardDataItem;
import com.xulei.allin.widget.cardview.CardSlidePanel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 卡片Fragment
 *
 * @author xmuSistone
 */
@SuppressLint({"HandlerLeak", "NewApi", "InflateParams"})
public class CardFragment extends Fragment {

    private CardSlidePanel.CardSwitchListener cardSwitchListener;

    private List<CardDataItem> dataList = new ArrayList<>();

    private List<LaughModel.LaughResult.LaughData> laughDataList;


    public static CardFragment newInstance(List<LaughModel.LaughResult.LaughData> laughdataList) {
        CardFragment fragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("laughDataList", (Serializable) laughdataList);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_layout, null);
        laughDataList = (List<LaughModel.LaughResult.LaughData>) getArguments().get("laughDataList");
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        final CardSlidePanel slidePanel = (CardSlidePanel) rootView
                .findViewById(R.id.image_slide_panel);
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
            }

            @Override
            public void onCardVanish(int index, int type) {
                if (index == laughDataList.size()) {
                    ButterKnife.findById(slidePanel,
                            R.id.id_card_next_btn).setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "最后一条", Toast.LENGTH_SHORT).show();
                } else {
                    ButterKnife.findById(slidePanel,
                            R.id.id_card_next_btn).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onItemClick(View cardView, int index) {
                Toast.makeText(getActivity(), "onItemClick()", Toast.LENGTH_SHORT).show();
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);

        prepareDataList();
        slidePanel.fillData(dataList);
    }

    private void prepareDataList() {
        int num = laughDataList.size();
        for (int i = 0; i < num; i++) {
            CardDataItem dataItem = new CardDataItem();
            dataItem.content = laughDataList.get(i).getContent();
            dataList.add(dataItem);
        }
    }

}
