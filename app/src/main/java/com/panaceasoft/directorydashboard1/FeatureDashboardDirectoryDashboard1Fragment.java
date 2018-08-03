package com.panaceasoft.directorydashboard1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Panacea-Soft on 3/8/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
public class FeatureDashboardDirectoryDashboard1Fragment extends Fragment {


    // data
    List<DirectoryCategory> directoryCategoryList;
    FeatureDashboardDirectoryDashboard1Adapter itemAdapter;

    // RecyclerView
    RecyclerView itemsRecyclerView;

    ImageView cityImageView;
    ImageView gradientImageView;

    int noOfColumn = 3;

    public FeatureDashboardDirectoryDashboard1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.feature_dashboard_directory_dashboard_1_fragment, container, false);

        initData();

        initUI(view);

        initDataBindings();

        initActions();

        return view;
    }

    private void initData() {

        directoryCategoryList = CategoryRepository.getCategoryList();

    }

    private void initUI(View view) {

        // get item list featuredAdapter
        itemAdapter = new FeatureDashboardDirectoryDashboard1Adapter(directoryCategoryList);

        if (getActivity() != null) {

            // get Item recycler view
            itemsRecyclerView = view.findViewById(R.id.recyclerView);
            RecyclerView.LayoutManager mLayoutManagerForItems = new GridLayoutManager(getActivity().getApplicationContext(), noOfColumn);

            itemsRecyclerView.setLayoutManager(mLayoutManagerForItems);
            itemsRecyclerView.setItemAnimator(new DefaultItemAnimator());
            itemsRecyclerView.setNestedScrollingEnabled(false);
        }

        cityImageView = view.findViewById(R.id.cityImageView);
        gradientImageView = view.findViewById(R.id.gradientImageView);
    }

    private void initDataBindings() {
        // bind items
        itemsRecyclerView.setAdapter(itemAdapter);

        int id = R.drawable.sg_clarke_quay;
        Utils.setImageToImageView(getContext(), cityImageView, id);

        int gradientImg = R.drawable.black_alpha_70;
        Utils.setImageToImageView(getContext(), gradientImageView, gradientImg);
    }

    private void initActions() {

        itemAdapter.setOnItemClickListener((view, obj, position) -> Toast.makeText(getContext(), "Clicked: " + obj.name, Toast.LENGTH_SHORT).show());

    }

    @Override
    public void onResume() {
        super.onResume();

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null) {
            if (appCompatActivity.getSupportActionBar() != null) {
                appCompatActivity.getSupportActionBar().hide();
            }
        }
    }

}

