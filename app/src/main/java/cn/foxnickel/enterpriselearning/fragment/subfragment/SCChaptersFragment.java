package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.SCChapterAdapter;
import cn.foxnickel.enterpriselearning.bean.Chapter;
import cn.foxnickel.enterpriselearning.bean.Course;

/**
 * Created by Night on 2017/7/8.
 * Desc:Specific course chapter Fragment
 */
public class SCChaptersFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private Course mCourse;
    private ArrayList<Chapter> mList;
    public SCChaptersFragment() {
    }

    public static SCChaptersFragment newInstance() {
        return new SCChaptersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_my_exam, container, false);
        initView();
        return mRootView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_my_exam);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mList = new ArrayList<>();
        mCourse = getArguments().getParcelable("course");

        SCChapterAdapter scChapterAdapter = new SCChapterAdapter(getContext(), mCourse.getChapters());
        mRecyclerView.setAdapter(scChapterAdapter);
    }
}
