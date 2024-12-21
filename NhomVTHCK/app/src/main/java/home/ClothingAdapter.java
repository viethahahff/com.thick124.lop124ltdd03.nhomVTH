package home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhomvthck.R;

import java.util.List;

public class ClothingAdapter extends RecyclerView.Adapter<ClothingAdapter.ClothingViewHolder> {

    private List<ClothingItem> clothingItems;

    public ClothingAdapter(List<ClothingItem> clothingItems) {
        this.clothingItems = clothingItems;
    }

    @NonNull
    @Override
    public ClothingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clothing, parent, false);
        return new ClothingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothingViewHolder holder, int position) {
        ClothingItem item = clothingItems.get(position);
        holder.tvClothingName.setText(item.getName());
        holder.tvClothingDescription.setText(item.getDescription());
        holder.tvClothingSize.setText("Size: " + item.getSize());
        holder.tvClothingPrice.setText("Giá: " + item.getPrice() + "đ");
        holder.imgClothing.setImageResource(item.getImageResourceId());

        // Xử lý sự kiện click vào item để chuyển sang ActivityBuy
//        holder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(v.getContext(), Buy.class);
//            intent.putExtra("PRODUCT_NAME", item.getName());
//            intent.putExtra("PRODUCT_PRICE", item.getPrice());
//            intent.putExtra("PRODUCT_IMAGE", item.getImageResourceId());
//            intent.putExtra("PRODUCT_DESCRIPTION", item.getDescription());
//            v.getContext().startActivity(intent);
//        });

        // Xử lý sự kiện click vào imgFavorite
        holder.imgFavorite.setOnClickListener(new View.OnClickListener() {
            boolean isFavorite = false;

            @Override
            public void onClick(View v) {
                isFavorite = !isFavorite;

                if (isFavorite) {
                    holder.imgFavorite.setImageResource(R.drawable.ic_like_filled);
                    Toast.makeText(v.getContext(), "Đã thêm vào mục yêu thích", Toast.LENGTH_SHORT).show();
                } else {
                    holder.imgFavorite.setImageResource(R.drawable.ic_like);
                    Toast.makeText(v.getContext(), "Đã bỏ yêu thích", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return clothingItems.size();
    }

    public static class ClothingViewHolder extends RecyclerView.ViewHolder {
        TextView tvClothingName, tvClothingDescription, tvClothingSize, tvClothingPrice;
        ImageView imgClothing, imgFavorite;

        public ClothingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClothingName = itemView.findViewById(R.id.tvClothingName);
            tvClothingDescription = itemView.findViewById(R.id.tvClothingDescription);
            tvClothingSize = itemView.findViewById(R.id.tvClothingSize);
            tvClothingPrice = itemView.findViewById(R.id.tvClothingPrice);
            imgClothing = itemView.findViewById(R.id.imgClothing);
            imgFavorite = itemView.findViewById(R.id.imgFavorite);
        }
    }
}
