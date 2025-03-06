package com.example.startproject6recyclerview;

import java.util.Arrays;
import java.util.List;

public class FoodModel {
    private String name;
    private String address;
    private BusinessType businessType;
    private String openTime;
    private float distance;
    private float rating;
    private int img;

    public FoodModel() {
    }

    public FoodModel(String name, String address, BusinessType businessType, String openTime, float distance, float rating, int img) {
        this.name = name;
        this.address = address;
        this.businessType = businessType;
        this.openTime = openTime;
        this.distance = distance;
        this.rating = rating;
        this.img = img;
    }

    //hardcode dữ liệu
    public static List<FoodModel> getMock() {
        return Arrays.asList(
                new FoodModel("Rau Má Bà Già - Đường 3 Tháng 2","692 Đường 3 Tháng 2, P. 14, Quận 10, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 1.5f, 4.7f, R.drawable.rau_ma ),
                new FoodModel("The Coffee Bean & Tea Leaf - Nguyễn Huệ","101 Nguyễn Huệ, P. Bến Nghé, Quận 1, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 2.2f, 4.5f, R.drawable.coffee_bean ),
                new FoodModel("Cơm Tấm Sài Gòn 24H - Nơ Trang Long","265/30 Nơ Trang Long, P.11, Bình Thạnh, TP. HCM", BusinessType.RESTAURANT, "Cả Ngày", 2.5f, 4.8f, R.drawable.com_tam_sg ),
                new FoodModel("Đậu Hủ Cá Viên HongKong - 港式鱼丸豆腐","28 Phan Phú Tiên, P. 10,  Quận 5, TP. HCM", BusinessType.RESTAURANT, "Chiều, Tối", 1.2f, 4.3f, R.drawable.dau_hu_ca_vien ),
                new FoodModel("Breakfast Shop - Phan Phú Tiên","28 Phan Phú Tiên, P. 10,  Quận 5, TP. HCM", BusinessType.ONLINE_SHOP, "Sáng, Chiều", 1.0f, 3.4f, R.drawable.breakfast_shop ),
                new FoodModel("Chè Út Lyly - Nguyễn Trọng Tuyển","384 Nguyễn Trọng Tuyển, P. 2,  Quận Tân Bình, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 3.2f, 4.4f, R.drawable.che_lyly ),
                new FoodModel("The Xi Cafe - Mangonada - 14E Đặng Văn Ngữ","14E Đặng Văn Ngữ, P. 10,  Quận Phú Nhuận, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 1.5f, 4.7f, R.drawable.the_xi ),
                new FoodModel("The Pizza Company - Vạn Hạnh Mall","Tầng 6,  Tầng 6 - 06 Vạn Hạnh Mall, 11 Sư Vạn Hạnh, P. 12,  Quận 10, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 2.5f, 3.7f, R.drawable.pizza_mall ),
                new FoodModel("Cơm Gà Quay Zeus","281/49/2 Lê Văn Sỹ, P. 1,  Quận Tân Bình, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 1.3f, 4.2f, R.drawable.com_ga ),
                new FoodModel("港式甜品店 - Trôi Nước HongKong","28 Phan Phú Tiên, P. 10,  Quận 5, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 1.5f, 3.7f, R.drawable.troi_nuoc ),
                new FoodModel("Kaya Toast Nướng - Cá Viên Singapore","28 Phan Phú Tiên, P. 10,  Quận 5, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 1.5f, 4.7f, R.drawable.ca_vien ),
                new FoodModel("KAI Coffee - Hồng Bàng","134 - 136 Hồng Bàng, P. 12,  Quận 5, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 1.5f, 4.7f, R.drawable.kai_coffee ),
                new FoodModel("Bánh Xèo Bà Hai - Nguyễn Trọng Tuyển","49 Nguyễn Trọng Tuyển, P. 15,  Quận Phú Nhuận, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 1.5f, 42f, R.drawable.banh_xeo ),
                new FoodModel("Ganesh - Ẩm Thực Ấn Độ - Đường Số 6","54 Đường Số 6, Hưng Phước 3, P. Tân Phong,  Quận 7, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 4.3f, 3.8f, R.drawable.ge_nesh ),
                new FoodModel("Trà Sữa Xiên Que Hot & Cold - Trần Não","13B Trần Não, P. Bình An,  Tp. Thủ Đức, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 4.3f, 3.8f, R.drawable.tra_sua_cold ),
                new FoodModel("Kem Bơ Nàng Zoe - Trường Sa","92A Trường Sa, P. 17,  Quận Bình Thạnh, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 4.3f, 3.8f, R.drawable.kem_bo ),
                new FoodModel("Gà Rán KFC - Lâm Văn Bền","168 Lâm Văn Bền, P. Tân Quy,  Quận 7, TP. HCM", BusinessType.ONLINE_SHOP, "Cả Ngày", 4.3f, 3.8f, R.drawable.ga_ran )

        );
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "FoodModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", businessType=" + businessType +
                ", distance=" + distance +
                ", rating=" + rating +
                ", img=" + img +
                '}';
    }
}
