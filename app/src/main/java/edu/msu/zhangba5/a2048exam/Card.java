package edu.msu.zhangba5.a2048exam;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Card extends FrameLayout {
    private int Num = 0;

    public Card(@NonNull Context context) {
        super(context);

        Label = new TextView(getContext());
        Label.setTextSize(32);
        LayoutParams lp = new LayoutParams(-1,-1);
        addView(Label,lp);


        setNum(0);
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;

        Label.setText(num+"");
    }

    private TextView Label;

    public boolean equal(Card card){
        return getNum() == card.getNum();
    }
}
