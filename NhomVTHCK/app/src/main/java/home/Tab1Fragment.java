package home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhomvthck.R;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends Fragment {

    private RecyclerView recyclerView;
    private ClothingAdapter adapter;
    private List<ClothingItem> clothingItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        // Khởi tạo RecyclerView
        recyclerView = view.findViewById(R.id.rcv_tab1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        clothingItems = new ArrayList<>();
        clothingItems.add(new ClothingItem("Áo len sọc nam nữ siêu hot", "Màu xám-trắng", 299000, R.drawable.aolennam, "Size M-XL"));
        clothingItems.add(new ClothingItem("Áo len sọc nam nữ", "Màu đen-trắng", 399000, R.drawable.aolennam, "Size S-XL"));
        clothingItems.add(new ClothingItem("Quần jean nam siêu hot", "Màu xám", 250000, R.drawable.aolennam, "Size L-XL"));
        clothingItems.add(new ClothingItem("Quần suông nam siêu hot", "Màu trắng", 250000, R.drawable.aolennam, "Size L-XL"));
        clothingItems.add(new ClothingItem("Áo SuPNow nữ ", "Màu trắng", 150000, R.drawable.aolennam, "Size M"));
        clothingItems.add(new ClothingItem("Áo Dạ nữ ", "Màu trắng-xám", 250000, R.drawable.aolennam, "Size L-M"));
        clothingItems.add(new ClothingItem("Áo giấy nữ", "Màu xám", 250000, R.drawable.aolennam, "Size M"));
        clothingItems.add(new ClothingItem("Áo len nữ ", "Màu đen-xanh", 350000, R.drawable.aolennam, "Size L-M"));
        clothingItems.add(new ClothingItem("Combo len", "Màu trắng đen", 350000, R.drawable.aolennam, "3-4 tuổi "));
        clothingItems.add(new ClothingItem("Combo áo dạ-váy", "Màu trắng hồng", 399000, R.drawable.aolennam, "3-4 tuổi "));
        clothingItems.add(new ClothingItem("Váy thỏ dễ thương", "Màu trắng đỏ", 399000, R.drawable.aolennam, "3-4 tuổi "));
        clothingItems.add(new ClothingItem("Áo phao cho bé trai", "Màu trắng xám", 399000, R.drawable.aolennam, "3-4 tuổi "));

        adapter = new ClothingAdapter(clothingItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
