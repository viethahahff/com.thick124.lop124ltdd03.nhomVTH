package com.example.myapplication2.buy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;

import java.util.List;

public class dgiaAdapter extends RecyclerView.Adapter<dgiaAdapter.ViewHolder> {
    private final List<dgia> reviewList;

    public dgiaAdapter(List<dgia> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dgia, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        dgia review = reviewList.get(position);
        holder.txtReviewerName.setText(review.getReviewerName());
        holder.ratingBar.setRating(review.getRating());
        holder.txtReviewContent.setText(review.getContent());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtReviewerName;
        RatingBar ratingBar;
        TextView txtReviewContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtReviewerName = itemView.findViewById(R.id.txtReviewerName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            txtReviewContent = itemView.findViewById(R.id.txtReviewContent);
        }
    }
}
