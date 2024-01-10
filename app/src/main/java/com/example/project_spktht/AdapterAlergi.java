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

public class AdapterAlergi extends RecyclerView.Adapter<AdapterAlergi.MyViewHolder> {
    private List<com.example.project_spktht.ModelAlergi> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_alergi, tv_tanggal_terjangkit, tv_bahan_alergen, tv_jenis_alergi, tv_gejala_alergi, tv_reaksi_alergi;
        ImageView btn_hapus;
        CardView card_hasil_alergi;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_alergi = itemView.findViewById(R.id.tv_alergi);
            tv_tanggal_terjangkit = itemView.findViewById(R.id.tv_tanggal_terjangkit);
            tv_bahan_alergen = itemView.findViewById(R.id.tv_bahan_alergen);
            tv_jenis_alergi = itemView.findViewById(R.id.tv_jenis_alergi);
            tv_gejala_alergi = itemView.findViewById(R.id.tv_gejala_alergi);
            tv_reaksi_alergi= itemView.findViewById(R.id.tv_reaksi_alergi);
            btn_hapus = itemView.findViewById(R.id.btn_hapus);
            card_hasil_alergi =itemView.findViewById(R.id.card_hasil_alergi);

        }
    }

    public AdapterAlergi(List<com.example.project_spktht.ModelAlergi>mList, Activity activity) {
        this.mList = mList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_view_alergi, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final com.example.project_spktht.ModelAlergi data = mList.get(position);
        holder.tv_alergi.setText("Nama Alergi : "+ data.getAlergi());
        holder.tv_tanggal_terjangkit.setText("Tanggal Terjangkit : "+ data.getTanggalTerjangkit());
        holder.tv_bahan_alergen.setText("Bahan Alergen : "+ data.getBahanAlergen());
        holder.tv_jenis_alergi.setText("Jenis Alergi : "+ data.getJenisAlergi());
        holder.tv_gejala_alergi.setText("Gejala Alergi : "+ data.getGejalaAlergi());
        holder.tv_reaksi_alergi.setText("Reaksi : "+ data.getReaksiAlergi());
        holder.btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        database.child("Alergi").child(data.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
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

        holder.card_hasil_alergi.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FragmentManager manager = ((AppCompatActivity)activity).getSupportFragmentManager();
                DialogFormAlergi dialog = new DialogFormAlergi(
                        data.getAlergi(),
                        data.getTanggalTerjangkit(),
                        data.getBahanAlergen(),
                        data.getJenisAlergi(),
                        data.getGejalaAlergi(),
                        data.getReaksiAlergi(),
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
