package com.example.project_spktht;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDaftarPenyakit extends RecyclerView.Adapter<AdapterDaftarPenyakit.DaftarPenyakitVH> {

    private static final String TAG = "DaftarPenyakitAdapter";
    List<ModelDaftarPenyakit> daftarPenyakitList;

    public AdapterDaftarPenyakit(List<ModelDaftarPenyakit> daftarPenyakitList) {
        this.daftarPenyakitList = daftarPenyakitList;
    }

    @NonNull
    @Override
    public DaftarPenyakitVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_view_daftar_penyakit, parent, false);
        return new DaftarPenyakitVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarPenyakitVH holder, int position) {
        ModelDaftarPenyakit daftarPenyakit = daftarPenyakitList.get(position);
        holder.titleTextView.setText(daftarPenyakit.getTitle());
        holder.penjelasanTextView.setText(daftarPenyakit.getPenjelasan());

        boolean isExpanded = daftarPenyakit.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return daftarPenyakitList.size();
    }

    class DaftarPenyakitVH extends RecyclerView.ViewHolder {

        private static final String TAG = "DaftarPenyakitVH";

        ConstraintLayout expandableLayout;
        TextView titleTextView, penjelasanTextView;

        public DaftarPenyakitVH(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            penjelasanTextView = itemView.findViewById(R.id.penjelasanTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ModelDaftarPenyakit daftarPenyakit = daftarPenyakitList.get(getAdapterPosition());
                    daftarPenyakit.setExpanded(!daftarPenyakit.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
