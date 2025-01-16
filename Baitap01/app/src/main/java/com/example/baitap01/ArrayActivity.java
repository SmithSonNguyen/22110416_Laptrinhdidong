package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ArrayActivity extends AppCompatActivity {


    TextInputEditText mTxtInput1;
    TextInputEditText mTxtInput4;
    TextView mTvResult;
    Button bt;
    Button bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_array_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mTxtInput1 = findViewById(R.id.textInputEdit1);
        mTvResult = findViewById(R.id.textViewResult);
        bt = findViewById(R.id.buttonResult);
        bt4 = findViewById(R.id.button4);
        mTxtInput4 = findViewById(R.id.texted4);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = mTxtInput1.getText().toString().trim();

                // Kiểm tra nếu input trống
                if (inputText.isEmpty()) {
                    Toast.makeText(ArrayActivity.this, "Nhập số phần tử của mảng", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Chuyển đổi input thành số nguyên
                    int arraySize = Integer.parseInt(inputText);

                    if (arraySize <= 0) {
                        Toast.makeText(ArrayActivity.this, "Số phần tử phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    ArrayList<Integer> numbers = new ArrayList<>();

                    // Tạo ngẫu nhiên các số cho mảng (trong khoảng 1 - 100)
                    for (int i = 0; i < arraySize; i++) {
                        numbers.add((int) (Math.random() * 100 + 1));
                    }

                    ArrayList<Integer> perfectSquares = new ArrayList<>();
                    for (int number : numbers) {
                        if (ktSoChinhPhuong(number)) {
                            perfectSquares.add(number);
                        }
                    }

                    mTvResult.setText("Mảng là : " + numbers.toString() +
                            "\nSố chính phương: " + perfectSquares.toString());


                    if (perfectSquares.isEmpty()) {
                        Toast.makeText(ArrayActivity.this, "Không có số chính phương trong mảng!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ArrayActivity.this, "Số chính phương: " + perfectSquares.toString(), Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException e) {

                    Toast.makeText(ArrayActivity.this, "Vui lòng nhập một số nguyên hợp lệ!", Toast.LENGTH_SHORT).show();
                }



            }


        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4
                String inputText4 = mTxtInput4.getText().toString().trim();
                if (inputText4.isEmpty()) {
                    Toast.makeText(ArrayActivity.this, "Nhập số phần tử của mảng", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Chuyển đổi input thành số nguyên
                    int arraySize = Integer.parseInt(inputText4);

                    // Kiểm tra giá trị hợp lệ
                    if (arraySize <= 0) {
                        Toast.makeText(ArrayActivity.this, "Số phần tử phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Tạo mảng với kích thước vừa nhập
                    ArrayList<Integer> numbers = new ArrayList<>();

                    // Tạo ngẫu nhiên các số cho mảng (trong khoảng 1 - 100)
                    for (int i = 0; i < arraySize; i++) {
                        numbers.add((int) (Math.random() * 100 + 1));
                    }
                    ArrayList<Integer> listSNT = new ArrayList<>();
                    for (int n : numbers) {
                        if (checkSNT(n)) {
                            listSNT.add(n);
                        }
                    }
                    inSoNgTo(numbers);
                } catch (NumberFormatException e) {
                    // Xử lý nếu input không phải số
                    Toast.makeText(ArrayActivity.this, "Vui lòng nhập một số nguyên hợp lệ!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private boolean ktSoChinhPhuong(int number) {
        if (number < 0) {
            return false; // Số âm không thể là số chính phương
        }
        int sqrt = (int) Math.sqrt(number); // Tính căn bậc hai của số
        return sqrt * sqrt == number; // Kiểm tra nếu bình phương của sqrt bằng number
    }

    private boolean checkSNT(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Hàm in các số nguyên tố
    private void inSoNgTo(ArrayList<Integer> numbers) {
        Log.d("Array", "Mảng random: " + numbers.toString());

        // Duyệt mảng và kiểm tra số nguyên tố
        ArrayList<Integer> listSNT = new ArrayList<>();
        for (int number : numbers) {
            if (checkSNT(number)) {
                listSNT.add(number);
            }
        }
        Log.d("So ng to trong mang", "So ng to: " + listSNT.toString());
    }
}
