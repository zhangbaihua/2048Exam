package edu.msu.zhangba5.a2048exam;


import android.content.Context;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

public class GameView extends GridLayout {


    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initGameView();
    }
    public GameView(Context context) {
        super(context);
        initGameView();
    }


    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGameView();
    }

    private void initGameView(){
        setColumnCount(4);
        setOnTouchListener(new View.OnTouchListener(){
            private float startX,startY,offsetX,offsetY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        offsetX = event.getX() - startX;
                        offsetY = event.getY() - startY;
                        if(Math.abs(offsetX) > Math.abs(offsetY)){
                            if(offsetX < -5){
                                swipeLeft();
                            }
                            else if(offsetX > 5){
                                swipeRight();
                            }
                        }
                        else{
                            if(offsetY < -5){
                                swipeUp();
                            }
                            else if(offsetY > 5){
                                swipeDown();
                            }
                        }
                        break;
                }
                return true;
            }
        });

    }

    private void swipeLeft(){

    }
    private void swipeRight(){

    }
    private void swipeUp(){

    }
    private void swipeDown(){

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int cardWidth = (Math.min(w,h) - 10)/4;

        addCard(cardWidth,cardWidth);


    }

    private void addCard(int cardWidth, int cardHeight){
        Card card;
        for(int y = 0; y < 4;y++){
            for(int n = 0; n < 4;n++){
                card = new Card(getContext());
                card.setNum(2);
                addView(card,cardWidth,cardHeight);
            }
        }
    }
}
