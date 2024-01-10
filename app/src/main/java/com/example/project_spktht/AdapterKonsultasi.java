package com.example.project_spktht;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_spktht.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterKonsultasi extends RecyclerView.Adapter<AdapterKonsultasi.MyViewHolder> {
    private List<com.example.project_spktht.ModelKonsultasi> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_konsulke, tv_tanggal, tv_dokter, tv_klinik, tv_keluhan, tv_diagnosa;
        ImageView btn_hapus;
        CardView card_hasil;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_konsulke = itemView.findViewById(R.id.tv_konsulke);
            tv_tanggal = itemView.findViewById(R.id.tv_tanggal);
            tv_dokter = itemView.findViewById(R.id.tv_dokter);
            tv_klinik = itemView.findViewById(R.id.tv_klinik);
            tv_keluhan = itemView.findViewById(R.id.tv_keluhan);
            tv_diagnosa = itemView.findViewById(R.id.tv_diagnosa);
            btn_hapus = itemView.findViewById(R.id.btn_hapus);
            card_hasil =itemView.findViewById(R.id.card_hasil);

        }
    }

    public AdapterKonsultasi(List<com.example.project_spktht.ModelKonsultasi>mList, Activity activity) {
        this.mList = mList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_view_konsul, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final com.example.project_spktht.ModelKonsultasi data = mList.get(position);
        holder.tv_konsulke.setText("Konsultasi Ke- : "+ data.getKonsulke());
        holder.tv_tanggal.setText("Tanggal : "+ data.getTanggal());
        holder.tv_dokter.setText("Dokter : "+ data.getDokter());
        holder.tv_klinik.setText("Klinik/Rumah Sakit : "+ data.getKlinik());
        holder.tv_keluhan.setText("Keluhan : "+ data.getKeluhan());
        holder.tv_diagnosa.setText("Diagnosa : "+ data.getDiagnosa());
        holder.btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        database.child("Konsultasi").child(data.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(activity, "Data berhasil dihapus!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(activity, "Gagal menghapus data!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setMessage("Apakah yakin ingin menghapus data ini?");
                builder.show();
            }
        });

        holder.card_hasil.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FragmentManager manager = ((AppCompatActivity)activity).getSupportFragmentManager();
                DialogFormKonsultasi dialog = new DialogFormKonsultasi(
                        data.getKonsulke(),
                        data.getTanggal(),
                        data.getDokter(),
                        data.getKlinik(),
                        data.getKeluhan(),
                        data.getDiagnosa(),
                        data.getKey(),
                        "Ubah"
                );
                dialog.show(manager, "form");
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
