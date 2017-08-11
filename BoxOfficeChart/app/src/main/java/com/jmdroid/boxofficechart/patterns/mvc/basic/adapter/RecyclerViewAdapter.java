package com.jmdroid.boxofficechart.patterns.mvc.basic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jmdroid.boxofficechart.R;
import com.jmdroid.boxofficechart.dto.data.BoxOffice;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<BoxOffice> boxOfficeList = new ArrayList<>();

    public RecyclerViewAdapter(Context context, List<BoxOffice> boxOfficeList) {
        this.context = context;
        this.boxOfficeList = boxOfficeList;
    }

    // item 추가 메소드
    public void addItems(List<BoxOffice> items) {
        if (null != items) {
            this.boxOfficeList.addAll(items);
        }
    }

    @Override
    public int getItemCount() {
        return boxOfficeList.size();
    }

    // 레이아웃을 만들어서 Holer에 저장
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = null;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_boxoffice, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.tv_mvc_rank.setText(boxOfficeList.get(position).getRank());
        viewHolder.tv_mvc_movienm.setText(boxOfficeList.get(position).getMovieNm());
        viewHolder.tv_mvc_opendt.setText("개봉일 : " + boxOfficeList.get(position).getOpenDt());
        viewHolder.tv_mvc_audicnt.setText("당일 관객수 : " + boxOfficeList.get(position).getAudiCnt() + "명");
        viewHolder.tv_mvc_audiacc.setText("누적 관객수 : " + boxOfficeList.get(position).getAudiAcc() + "명");
        viewHolder.btn_detail_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, boxOfficeList.get(position).getRank() + " 클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 뷰 재활용을 위한 viewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_mvc_rank;
        TextView tv_mvc_movienm;
        TextView tv_mvc_opendt;
        TextView tv_mvc_audicnt;
        TextView tv_mvc_audiacc;
        Button btn_detail_web;

        // 뷰로부터 컴포넌트를 획득
        public ViewHolder(View itemView) {
            super(itemView);
            tv_mvc_rank = (TextView) itemView.findViewById(R.id.tv_mvc_rank);
            tv_mvc_movienm = (TextView) itemView.findViewById(R.id.tv_mvc_movienm);
            tv_mvc_opendt = (TextView) itemView.findViewById(R.id.tv_mvc_opendt);
            tv_mvc_audicnt = (TextView) itemView.findViewById(R.id.tv_mvc_audicnt);
            tv_mvc_audiacc = (TextView) itemView.findViewById(R.id.tv_mvc_audiacc);
            btn_detail_web = (Button) itemView.findViewById(R.id.btn_detail_web);
        }
    }
}
