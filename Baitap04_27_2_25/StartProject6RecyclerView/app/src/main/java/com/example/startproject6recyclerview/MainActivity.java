package com.example.startproject6recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Khai báo
    SearchView mSvFindFood;
    RecyclerView mRcvFood;
    List<FoodModel> mListFood;
    FoodAdapter mFoodAdapter;
    int mCurrentPage=1;
    int mTotalPage=10;
    boolean mIsLoading=false;
    boolean mIsLastPage=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ
        mRcvFood = findViewById(R.id.recyclerViewFood);
        //tạo arrlist mowis
        mListFood = new ArrayList<>();
        //thêm dữ liệu thông qua getMock() từ FoodModel
        mListFood.addAll(FoodModel.getMock());

        //Tạo adapter
        mFoodAdapter = new FoodAdapter(mListFood,MainActivity.this);
        //tạo progress dữ liệu
        mFoodAdapter.addFooterLoading();

        mRcvFood.setHasFixedSize(true);
        mRcvFood.setAdapter(mFoodAdapter);

        //ánh xah
        mSvFindFood = findViewById(R.id.searchView1);
        mSvFindFood.clearFocus();
        //khi click vào items thì hiển thị dữ liệu: tên
        mFoodAdapter.bindOnItemFoodClickListener(new OnItemFoodClickListener() {
            @Override
            public void onclick(int position) {
                Toast.makeText(MainActivity.this,mListFood.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

        //Khi cuộn xuống hết thì nó sẽ nghe event cuộn, cuoonj hết thì sẽ load trang tiếp theo
        mRcvFood.addOnScrollListener(new PaginationScrollListener((LinearLayoutManager) mRcvFood.getLayoutManager()) {
            @Override
            public void loadMore() {

                mIsLoading=true;
                mCurrentPage+=1;
                loadNextPage();
            }

            @Override
            public boolean isLoading() {
                return mIsLoading;
            }

            @Override
            public boolean isLastPage() {
                return mIsLastPage;
            }
        });
        mSvFindFood.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return false;
            }
        });
    }

    private void loadNextPage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mFoodAdapter.removeFooterLoading();
                int position = mListFood.size()-1;
                List<FoodModel> foodModels = FoodModel.getMock();
                mListFood.addAll(FoodModel.getMock());
                mFoodAdapter.notifyItemRangeChanged(position,FoodModel.getMock().size());
                foodModels = null;
                mIsLoading=false;

                if(mCurrentPage<mTotalPage){
                    mFoodAdapter.addFooterLoading();
                }else {
                    mIsLoading=true;
                }

            }
        },1000);
    }

    //tìm kiếm
    private void filterListener(String text){
        List<FoodModel>list = new ArrayList<>();
        for (FoodModel foodModel:mListFood){
            if (foodModel.getName().toLowerCase().contains(text.toLowerCase())){
                list.add(foodModel);
            }
        }
        if(list.isEmpty()){
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }else {
            mFoodAdapter.setListenerList(list);
        }
    }


}