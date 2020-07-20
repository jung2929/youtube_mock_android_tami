package com.example.youtube_clone.src.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtube_clone.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static RecyclerView horizontalList;
    private ArrayList<ListViewItem> mData = null ;
    private ArrayList<ListViewItem> mHorizontalData = null ;
    private static Context mContext;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView tvTitle,channelName,uploadDate,viewCount;
        ImageView thumbNail,profileImage;

        ViewHolder1(View v) {
            super(v) ;
            // 뷰 객체에 대한 참조. (hold strong reference)
            tvTitle = v.findViewById(R.id.tv_listviewitem_title);
            channelName = v.findViewById(R.id.tv_listviewitem_channelName);
            uploadDate = v.findViewById(R.id.tv_listviewitem_uploadDate);
            viewCount = v.findViewById(R.id.tv_listviewitem_viewCount);
            thumbNail = v.findViewById(R.id.iv_listviewitem_video);
            profileImage = v.findViewById(R.id.iv_listviewitem_profile);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView channelName,uploadDate,content,thumbUpCount,commentCount;
        ImageView image,profileImage;

        ViewHolder2(View v) {
            super(v) ;
            // 뷰 객체에 대한 참조. (hold strong reference)
            channelName = v.findViewById(R.id.tv_listviewitem2_channelName);
            uploadDate = v.findViewById(R.id.tv_listviewitem2_uploadDate);
            commentCount = v.findViewById(R.id.tv_listviewitem2_commentNum);
            thumbUpCount = v.findViewById(R.id.tv_listviewitem2_thumbUpNum);
            content = v.findViewById(R.id.tv_listviewitem2_content);
            image = v.findViewById(R.id.iv_listviewitem2_photo);
            profileImage = v.findViewById(R.id.iv_listviewitem2_profile);
        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {

        private HorizontalRecyclerViewAdapter horizontalAdapter;

        ViewHolder3(View v) {
            super(v) ;
            Context context = itemView.getContext();
            horizontalList = itemView.findViewById(R.id.horizontal_list);
            horizontalList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            horizontalAdapter = new HorizontalRecyclerViewAdapter(mHorizontalData);
            horizontalList.setAdapter(horizontalAdapter);
        }
    }

    // 생성자
    public RecyclerViewAdapter(ArrayList<ListViewItem> list, ArrayList<ListViewItem> horizontalList) {
        mData = list ;
        mHorizontalData = horizontalList;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        mContext = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        if(viewType == 0){
            View view = inflater.inflate(R.layout.recycler_view_item1, parent, false) ;
            RecyclerViewAdapter.ViewHolder1 vh = new RecyclerViewAdapter.ViewHolder1(view) ;

            return vh ;

        }else if(viewType == 1){
            View view = inflater.inflate(R.layout.recycler_view_item2, parent, false) ;
            RecyclerViewAdapter.ViewHolder2 vh = new RecyclerViewAdapter.ViewHolder2(view) ;

            return vh ;

        }else if(viewType == 3){
            View view = inflater.inflate(R.layout.recycler_view_item3, parent, false) ;
            RecyclerViewAdapter.ViewHolder3 vh = new RecyclerViewAdapter.ViewHolder3(view) ;

            return vh ;
        }


        return null;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder1) {
            ListViewItem item = mData.get(position);
            ((ViewHolder1) holder).tvTitle.setText(item.getTitle());
            ((ViewHolder1) holder).channelName.setText(item.getChannelName());
            ((ViewHolder1) holder).uploadDate.setText(item.getUploadDate());
            ((ViewHolder1) holder).viewCount.setText(item.getUploadDate());

            Picasso.with(mContext)
                    .load(item.getThumUrl())
                    .into( ((ViewHolder1) holder).thumbNail);

            Picasso.with(mContext)
                    .load(item.getProfileImage())
                    .into( ((ViewHolder1) holder).profileImage);

        }else if (holder instanceof ViewHolder2){
            ListViewItem item = mData.get(position);
            ((ViewHolder2) holder).channelName.setText(item.getChannelName());
            ((ViewHolder2) holder).uploadDate.setText(item.getUploadDate());
            ((ViewHolder2) holder).commentCount.setText(item.getCommentCount()+"");
            ((ViewHolder2) holder).content.setText(item.getContentText());
            ((ViewHolder2) holder).thumbUpCount.setText(item.getCommentCount()+"");


            Picasso.with(mContext)
                    .load(item.getProfileImage())
                    .into( ((ViewHolder2) holder).profileImage);
            if(item.getImage().equals(" ")){
                ((ViewHolder2) holder).image.setVisibility(View.GONE);
            }else{
                ((ViewHolder2) holder).image.setVisibility(View.VISIBLE);
                Picasso.with(mContext)
                        .load(item.getImage())
                        .into( ((ViewHolder2) holder).image);
            }



        }else if(holder instanceof ViewHolder3){
            ((ViewHolder3) holder).horizontalAdapter.setRowIndex(position);
        }
    }


    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    //item 뷰 타입 리턴.
    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType();
    }

}