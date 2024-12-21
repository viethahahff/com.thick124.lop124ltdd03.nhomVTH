package com.example.myapplication2.buy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication2.R;
import com.example.myapplication2.danhgia.payment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MuaNgay extends BottomSheetDialogFragment {

    private int quantity = 1; // Biến để lưu số lượng sản phẩm
    private int productPrice; // Giá gốc của sản phẩm
    private TextView quantityText; // TextView hiển thị số lượng
    private TextView productNameText; // TextView hiển thị tên sản phẩm
    private Button selectedSizeButton = null; // Nút kích thước đã chọn
    private Button selectedColorButton = null; // Nút màu sắc đã chọn
    private static final int DEFAULT_COLOR = 0xFFE0E0E0; // Màu nền mặc định
    private static final int SELECTED_COLOR = 0xFF00A8FF; // Màu nền khi được chọn

    // Các biến để hiển thị thông tin sản phẩm
    private ImageView productImageView;
    private TextView productPriceText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mua_ngay, container, false);

        // Khởi tạo các thành phần UI
        quantityText = view.findViewById(R.id.quantity_text);
        productNameText = view.findViewById(R.id.product_name); // Thêm TextView cho tên sản phẩm
        productImageView = view.findViewById(R.id.product_image);
        productPriceText = view.findViewById(R.id.product_price);

        // Lấy thông tin từ Bundle
        Bundle args = getArguments();
        if (args != null) {
            int productImageResId = args.getInt("PRODUCT_IMAGE");
            productPrice = args.getInt("PRODUCT_PRICE"); // Lưu giá gốc của sản phẩm
            String productName = args.getString("PRODUCT_NAME"); // Lấy tên sản phẩm

            // Cập nhật giao diện
            productNameText.setText(productName); // Hiển thị tên sản phẩm
            productImageView.setImageResource(productImageResId);
            productPriceText.setText("Giá: " + productPrice + "đ");
        }

        // Các xử lý khác
        Button sizeMButton = view.findViewById(R.id.size_m);
        Button sizeLButton = view.findViewById(R.id.size_l);
        Button sizeXButton = view.findViewById(R.id.size_xl);
        Button colorGrayButton = view.findViewById(R.id.color_gray);
        Button colorWhiteButton = view.findViewById(R.id.color_white);
        Button quantityMinusButton = view.findViewById(R.id.quantity_minus);
        Button quantityPlusButton = view.findViewById(R.id.quantity_plus);
        ImageView closeButton = view.findViewById(R.id.close);
        Button buyNowButton = view.findViewById(R.id.buy_now);

        closeButton.setOnClickListener(v -> dismiss());
        setDefaultButtonColors(sizeMButton, sizeLButton, sizeXButton, colorGrayButton, colorWhiteButton);

        // Xử lý các nút chọn kích thước, màu sắc, và số lượng
        sizeMButton.setOnClickListener(v -> toggleSizeButton(sizeMButton));
        sizeLButton.setOnClickListener(v -> toggleSizeButton(sizeLButton));
        sizeXButton.setOnClickListener(v -> toggleSizeButton(sizeXButton));
        colorGrayButton.setOnClickListener(v -> toggleColorButton(colorGrayButton));
        colorWhiteButton.setOnClickListener(v -> toggleColorButton(colorWhiteButton));

        quantityMinusButton.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                updateQuantityText();
            }
        });

        quantityPlusButton.setOnClickListener(v -> {
            quantity++;
            updateQuantityText();
        });

        buyNowButton.setOnClickListener(v -> {
            if (selectedSizeButton == null) {
                Toast.makeText(getContext(), "Vui lòng chọn kích thước sản phẩm!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedColorButton == null) {
                Toast.makeText(getContext(), "Vui lòng chọn màu sắc sản phẩm!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (quantity < 1) {
                Toast.makeText(getContext(), "Vui lòng chọn số lượng sản phẩm!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tạo Bundle để truyền dữ liệu
            Bundle bundle = new Bundle();
            bundle.putString("PRODUCT_NAME", productNameText.getText().toString());
            bundle.putInt("PRODUCT_PRICE", productPrice);
            bundle.putInt("QUANTITY", quantity);
            bundle.putString("SELECTED_SIZE", selectedSizeButton.getText().toString());
            bundle.putString("SELECTED_COLOR", selectedColorButton.getText().toString()); // Thêm màu sắc

            // Tạo Intent và truyền Bundle vào
            Intent intent = new Intent(getActivity(), payment.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });



        return view;
    }

    // Phương thức để cập nhật thông tin sản phẩm
    public void updateProductInfo(int productImageResId, int productPrice) {
        productImageView.setImageResource(productImageResId);
        this.productPrice = productPrice; // Cập nhật giá gốc của sản phẩm
        productPriceText.setText("Giá: " + productPrice + "đ");
    }

    // Thiết lập màu nền mặc định cho các nút
    private void setDefaultButtonColors(Button... buttons) {
        for (Button button : buttons) {
            button.setBackgroundColor(DEFAULT_COLOR);
        }
    }

    // Phương thức thay đổi màu nền của nút kích thước
    private void toggleSizeButton(Button button) {
        if (selectedSizeButton == button) {
            button.setBackgroundColor(DEFAULT_COLOR);
            selectedSizeButton = null;
        } else {
            if (selectedSizeButton != null) {
                selectedSizeButton.setBackgroundColor(DEFAULT_COLOR);
            }
            button.setBackgroundColor(SELECTED_COLOR);
            selectedSizeButton = button;
        }
    }

    // Phương thức thay đổi màu nền của nút màu sắc
    private void toggleColorButton(Button button) {
        if (selectedColorButton == button) {
            button.setBackgroundColor(DEFAULT_COLOR);
            selectedColorButton = null;
        } else {
            if (selectedColorButton != null) {
                selectedColorButton.setBackgroundColor(DEFAULT_COLOR);
            }
            button.setBackgroundColor(SELECTED_COLOR);
            selectedColorButton = button;
        }
    }

    // Phương thức cập nhật số lượng hiển thị và giá sản phẩm
    private void updateQuantityText() {
        quantityText.setText(String.valueOf(quantity));
        int totalPrice = productPrice * quantity; // Tính tổng giá dựa trên số lượng
        productPriceText.setText("Giá: " + totalPrice + "đ");
    }
}
