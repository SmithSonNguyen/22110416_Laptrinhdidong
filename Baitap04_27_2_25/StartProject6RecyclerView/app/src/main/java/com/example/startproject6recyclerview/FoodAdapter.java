package com.example.startproject6recyclerview;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FoodModel> listFoods;
    private Context context;
    private OnItemFoodClickListener onItemFoodClickListener;

    private int LOADING_TYPE=1;
    private int ITEM_TYPE=0;
    private boolean isLoading=false;


    public FoodAdapter(List<FoodModel> listFoods, Context context) {
        this.listFoods = listFoods;
        this.context = context;
    }

    public void setListenerList(List<FoodModel> list) {
        this.listFoods = list;
        notifyDataSetChanged();
    }

    //tạo viewHolder dựa vào ITEM_TYPE, item_loading
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = null;
        if(viewType == ITEM_TYPE){
            view = layoutInflater.inflate(R.layout.item_food,parent,false);
            return new FoodViewHolder(view);

        }else {
            view = layoutInflater.inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    //gán dữ liệu vào ViewHolder nếu là Item_Type
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        /*holder.bind(listFoods.get(position));*/
        if(holder.getItemViewType()==ITEM_TYPE){
            ((FoodViewHolder)holder).bind(listFoods.get(position));
        }
    }

    //Trả về số lượng item trong dsach
    @Override
    public int getItemCount() {
        if (listFoods==null || listFoods.size()== 0){
            return 0;
        }
        return listFoods.size();
    }

    //xacs định loại item
    @Override
    public int getItemViewType(int position) {
        if(position == listFoods.size()-1 && isLoading){
            return LOADING_TYPE;
        }
        return ITEM_TYPE;
    }

    //Khởi tạo view và gán các sự kiện click
    class FoodViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tvName, tvAddress, tvBusinessType, tvOpenTime, tvDistance, tvRate;

        private List<FoodModel> listFoods;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageViewFood);
            tvName = itemView.findViewById(R.id.textViewName);
            tvAddress = itemView.findViewById(R.id.textViewAddress);
            tvBusinessType = itemView.findViewById(R.id.textViewCategory);
            tvOpenTime = itemView.findViewById(R.id.textViewOpenTime);
            tvDistance = itemView.findViewById(R.id.textViewDistance);
            tvRate = itemView.findViewById(R.id.textViewRating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context, listFoods.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    if(onItemFoodClickListener != null){
                        onItemFoodClickListener.onclick(getAdapterPosition());
                    }
                }
            });

            
        }

        public void bind(FoodModel foodModel) {
            img.setImageResource(foodModel.getImg());
            tvName.setText(foodModel.getName());
            tvAddress.setText(foodModel.getAddress());
            tvBusinessType.setText(foodModel.getBusinessType().toString());
            tvOpenTime.setText(foodModel.getOpenTime());
            tvDistance.setText(foodModel.getDistance()+"km");
            tvRate.setText(foodModel.getRating()+"");

        }
    }

    class LoadingViewHolder extends RecyclerView.ViewHolder{
        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
    public  void bindOnItemFoodClickListener(OnItemFoodClickListener onItemFoodClickListener){
        this.onItemFoodClickListener=onItemFoodClickListener;
    }
    public void addFooterLoading(){
        isLoading=true;listFoods.add(null);
    }
    public void removeFooterLoading(){
        isLoading=false;
        int position= listFoods.size()-1;
        listFoods.remove(position);
        notifyItemRemoved(position);
    }

}
