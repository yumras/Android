package com.example.smart_16.project11_2_file_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final static int LINE=1, CIRCLE=2, RECT=3, PATH=4; // 도형을 상수로 지정
    static int curShape=LINE; // 선택한 도형
    static int curColor=Color.MAGENTA;
    static int curWidth=15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }

    // 메뉴 만들기


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"선");
        menu.add(0,2,0,"원");
        menu.add(0,3,0,"사각형");
        menu.add(0,9,0,"경로");
        SubMenu sMenu = menu.addSubMenu("색상 변경");
        sMenu.add(0,4,0,"빨강");
        sMenu.add(0,5,0,"초록");
        sMenu.add(0,6,0,"파랑");
        SubMenu sMenu1 = menu.addSubMenu("선 굵기 변경");
        sMenu1.add(0,7,0,"5");
        sMenu1.add(0,8,0,"10");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1: curShape=LINE; // 선
                return true;
            case 2: curShape=CIRCLE; // 원
                return true;
            case 3: curShape=RECT; // 사각형
                return true;
            case 4: curColor = Color.RED; // 빨강
                return true;
            case 5: curColor = Color.GREEN; // 초록
                return true;
            case 6: curColor = Color.BLUE; // 파랑
                return true;
            case 7: curWidth = 5;
                return true;
            case 8: curWidth = 10;
                return true;
            case 9: curShape=PATH;
                return true;
        }
        return super.onOptionsItemSelected(item);
        // 혹은 return false;
    }

    // 커스텀 뷰 생성 --> 캔버스 공간 만들기
    private static class MyGraphicView extends View{

        // 전역 변수
        int startX = -1, startY = -1, stopX = -1, stopY = -1;

        public MyGraphicView(Context context) {
            super(context);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startX = (int)event.getX(); // x좌표
                    startY = (int)event.getY(); // y좌표 --> 시작 지점
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int)event.getX(); // x좌표
                    stopY = (int)event.getY(); // y좌표 --> 끝나는 지점
                    this.invalidate(); // 움직임 취소 --> 좌표 체크 기능 취소
                    break;
            }
            return true;
        }

        // onDraw() 메서드
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(curWidth);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(curColor);

            switch (curShape){
                case LINE:
                    canvas.drawLine(startX,startY,stopX,stopY,paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX-startX,2)
                        +Math.pow(stopY-startY,2));
                    canvas.drawCircle(startX,startY,radius,paint);
                    break;
                case RECT:
                    canvas.drawRect(startX,startY,stopX,stopY,paint);
                    break;
                    // new RecF : --> 모서리가 둥근 사각형
                    // canvas.drawRoundRect()
                case PATH :
                    Path path1 = new Path();
                    path1.moveTo(startX,startY); // 시작지점
                    path1.lineTo(startX+100,startY); // 끝지점
                    path1.lineTo(startX+100,startY-100);
                    path1.lineTo(startX+200,startY-100);
                    path1.lineTo(startX+200,startY);
                    path1.lineTo(startX+300,startY);
                    path1.lineTo(startX+300,startY+100);
                    path1.lineTo(startX,startY+100);
                    path1.lineTo(startX,startY);
                    canvas.drawPath(path1, paint);

            }
        }





    }




}
