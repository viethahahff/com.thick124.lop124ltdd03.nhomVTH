package com.example.myapplication2.buy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.ArrayList;
import java.util.List;

public class Buy extends AppCompatActivity {

    private TextView txtProductName, txtProductPrice, txtProductDescription;
    private ImageView imgProduct;
    private RecyclerView rvReviews;
    private dgiaAdapter reviewAdapter;
    private List<dgia> reviewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        txtProductName = findViewById(R.id.txtProductName);
        txtProductPrice = findViewById(R.id.txtDiscountPrice);
        txtProductDescription = findViewById(R.id.txtProductDescription);
        imgProduct = findViewById(R.id.imgProduct);
        rvReviews = findViewById(R.id.recyclerReviews);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String productName = intent.getStringExtra("PRODUCT_NAME");
        int productPrice = intent.getIntExtra("PRODUCT_PRICE", 0);
        int productImageResId = intent.getIntExtra("PRODUCT_IMAGE", 0);
        String productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION");

        // Cập nhật UI
        txtProductName.setText(productName);
        txtProductPrice.setText(String.valueOf(productPrice)); // Chỉ hiển thị số
        txtProductDescription.setText(productDescription);
        imgProduct.setImageResource(productImageResId);

        // Khởi tạo danh sách đánh giá
        reviewList = new ArrayList<>();
        reviewList.add(new dgia("Nguyễn Văn A", 4.5f, "Sản phẩm rất tốt!"));
        reviewList.add(new dgia("Trần Thị B", 5.0f, "Mình rất hài lòng với sản phẩm này!"));
        reviewList.add(new dgia("Lê Văn C", 4.0f, "Chất lượng ổn, giao hàng nhanh chóng."));
        reviewList.add(new dgia("Phạm Minh D", 4.8f, "Sản phẩm đẹp và chất lượng."));
        reviewList.add(new dgia("Nguyễn Thị E", 4.2f, "Tôi sẽ mua lại lần sau."));
        reviewList.add(new dgia("Trần Văn F", 3.5f, "Sản phẩm bình thường, không có gì đặc biệt."));

        // Khởi tạo Adapter cho RecyclerView
        reviewAdapter = new dgiaAdapter(reviewList);
        rvReviews.setLayoutManager(new LinearLayoutManager(this));
        rvReviews.setAdapter(reviewAdapter);

        // Tạo Bundle dùng chung
        Bundle sharedBundle = new Bundle();
        sharedBundle.putInt("PRODUCT_IMAGE", productImageResId);
        sharedBundle.putInt("PRODUCT_PRICE", productPrice);
        sharedBundle.putString("PRODUCT_NAME", productName);

        // Set sự kiện cho btnOrderNow
        Button btnOrderNow = findViewById(R.id.btnOrderNow);
        btnOrderNow.setOnClickListener(v -> {
            MuaNgay bottomSheet = new MuaNgay();
            bottomSheet.setArguments(sharedBundle);
            bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
        });

        // Set sự kiện cho imgCart
        ImageButton imgCart = findViewById(R.id.imgCart);
        imgCart.setOnClickListener(v -> {
            themgiohang cartBottomSheet = new themgiohang();
            cartBottomSheet.setArguments(sharedBundle);
            cartBottomSheet.show(getSupportFragmentManager(), cartBottomSheet.getTag());
        });
    }
}
