package com.numeroeins.uniflea.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.numeroeins.uniflea.Product;
import com.numeroeins.uniflea.R;
import com.numeroeins.uniflea.adapter.ProductListAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {


    @BindView(R.id.recycleviewForProductList)
    RecyclerView recycleviewForProductList;
    @BindView(R.id.recycleviewForServiceList)
    RecyclerView recycleviewForServiceList;
    @BindView(R.id.moreProdcuts)TextView moreProdcuts;
    @BindView(R.id.moreServices)TextView moreServices;

    ArrayList<Product> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        showProductList();

    }


    private void showProductList() {

        createDummyData();
        ProductListAdapter productListAdapter=new ProductListAdapter(this,this.list);
        ProductListAdapter serviceListAdapter=new ProductListAdapter(this,this.list);
        recycleviewForProductList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recycleviewForProductList.setAdapter(productListAdapter);

        recycleviewForServiceList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recycleviewForServiceList.setAdapter(serviceListAdapter);

    }

    private void createDummyData() {
        this.list.add(new Product(R.drawable.image1,"Product 1","100","Pune",false));
        this.list.add(new Product(R.drawable.image2,"Product 2","200","Pune",true));
        this.list.add(new Product(R.drawable.img3,"Product 3","300","Pune",false));
        this.list.add(new Product(R.drawable.img4,"Product 4","400","Pune",false));
        this.list.add(new Product(R.drawable.img5,"Product 5","500","Pune",false));
        this.list.add(new Product(R.drawable.img6,"Product 6","600","Pune",false));
        this.list.add(new Product(R.drawable.img7,"Product 7","700","Pune",false));
        this.list.add(new Product(R.drawable.noimage,"Product 8","800","Pune",false));

    }
}
