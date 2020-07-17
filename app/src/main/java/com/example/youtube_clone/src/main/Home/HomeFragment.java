package com.example.youtube_clone.src.main.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.youtube_clone.R;
import com.example.youtube_clone.src.main.ListViewAdapter;


public class HomeFragment extends ListFragment {

    ListViewAdapter adapter = new ListViewAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setListAdapter(adapter) ;
        adapter.addItem("Box") ;
        adapter.addItem("Box2") ;
        adapter.addItem("Box3") ;

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {  //Fragment를 다 그렸을 때 호출된다, ui 변경 작업 가능
        super.onResume();

    }
}