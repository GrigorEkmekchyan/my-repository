package com.example.merchantx.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merchantx.R;
import com.example.merchantx.retrofit.response.get_paid_response.GetTransactionsResponse;

import java.util.List;

public class PaidTransactionsAdapter extends RecyclerView.Adapter<PaidTransactionsAdapter.HistoryViewHolder> {
    private List<GetTransactionsResponse> getTransactionsResponse;
    private OnMyItemClickListener onMyItemClickListener;
    public PaidTransactionsAdapter(List<GetTransactionsResponse> getTransactionsResponse) {
        this.getTransactionsResponse = getTransactionsResponse;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paid_history_item, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
       holder.tvDate.setText(getTransactionsResponse.get(position).getTransactionDate());
       holder.tvMoney.setText(String.valueOf(getTransactionsResponse.get(position).getAmount()));

    }

    @Override
    public int getItemCount() {
        return getTransactionsResponse.size();
    }

    public void setOnMyItemClickListener(OnMyItemClickListener onMyItemClickListener) {
        this.onMyItemClickListener = onMyItemClickListener;
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMoney;
        private TextView tvDate;
        private ImageView ivIcon;

        public HistoryViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvDate = itemView.findViewById(R.id.tv_show_date);
            tvMoney = itemView.findViewById(R.id.tv_show_money);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onMyItemClickListener.onItemClicked(getLayoutPosition());
                }
            });
        }
    }

    public interface OnMyItemClickListener {
        void onItemClicked(int position);
    }
}
