package com.example.smart_16.project8_2_listview_4.Adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smart_16.project8_2_listview_4.ListVO.ListVO;
import com.example.smart_16.project8_2_listview_4.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter{
    // 동적 배열
    private ArrayList<ListVO> listVO = new ArrayList<>() ;
    // 생성자
    public ListAdapter(){

    }

    public ListAdapter(ArrayList<ListVO> listVO) {
        this.listVO = listVO;
    }

    // 추가 메서드 ==> 데이터값 넣어주기
    public void addVO(Drawable icon, String title, String desc) {
        ListVO item = new ListVO();
        item.setImg(icon);
        item.setTitle(title);
        item.setContext(desc);
        listVO.add(item);
    }
    @Override
    public int getCount() { // 데이터 전체 개수
        return listVO.size(); // size() : 배열의 총 개수
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public Object getItem(int position) { // 위치에 해당하는 데이터 값 리턴
        return listVO.get(position); // get(위치)
    }

    @Override
    public long getItemId(int position) { // 위치에 해당하는 데이터 식별자
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // position = ListView의 위치 / 첫번째면 position = 0
        final int pos = position; // 위치 체크할 변수
        final Context context = parent.getContext();

        // 1> convertView 가 있는지 없는지 체크 /  null 이면 새로 뷰를 만듦
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_listview, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.img);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView Content = (TextView) convertView.findViewById(R.id.context);

        // 2> 위치에 해당하는 뷰 보여주기
        ListVO listViewitem = listVO.get(position);
        // 아이템 내 각 위젯에 데이터 반영
        image.setImageDrawable(listViewitem.getImg());
        title.setText(listViewitem.getTitle());
        Content.setText(listViewitem.getContext());

        // 3< 보여지는 뷰 값의 기능 부여
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, (pos + 1)+ "번째 항목입니다.", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }


}
