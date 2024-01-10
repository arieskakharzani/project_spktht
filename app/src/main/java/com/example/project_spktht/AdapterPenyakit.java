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

public class AdapterPenyakit extends RecyclerView.Adapter<AdapterPenyakit.MyViewHolder> {
    private List<com.example.project_spktht.ModelPenyakit> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_penyakit, tv_tanggal_terjangkit, tv_gangguanTelinga, tv_gangguanHidung, tv_gangguanTenggorokan, tv_obat;
        ImageView btn_hapus;
        CardView card_hasil_penyakit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_penyakit = itemView.findViewById(R.id.tv_penyakit);
            tv_tanggal_terjangkit = itemView.findViewById(R.id.tv_tanggal_terjangkit);
            tv_gangguanTelinga = itemView.findViewById(R.id.tv_gangguan_telinga);
            tv_gangguanHidung = itemView.findViewById(R.id.tv_gangguan_hidung);
            tv_gangguanTenggorokan = itemView.findViewById(R.id.tv_gangguan_tenggorokan);
            tv_obat= itemView.findViewById(R.id.tv_obat);
            btn_hapus = itemView.findViewById(R.id.btn_hapus);
            card_hasil_penyakit =itemView.findViewById(R.id.card_hasil_penyakit);

        }
    }

    public AdapterPenyakit(List<com.example.project_spktht.ModelPenyakit>mList, Activity activity) {
        this.mList = mList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_view_penyakit, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final com.example.project_spktht.ModelPenyakit data = mList.get(position);
        holder.tv_penyakit.setText("Nama Penyakit : "+ data.getPenyakit());
        holder.tv_tanggal_terjangkit.setText("Tanggal Terjangkit : "+ data.getTanggalTerjangkit());
        holder.tv_gangguanTelinga.setText("Gangguan Telinga : "+ data.getGangguanTelinga());
        holder.tv_gangguanHidung.setText("Gangguan Hidung : "+ data.getGangguanHidung());
        holder.tv_gangguanTenggorokan.setText("Gangguan Tenggorokan : "+ data.getGangguanTenggorokan());
        holder.tv_obat.setText("Obat-obatan : "+ data.getObat());
        holder.btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        database.child("Penyakit").child(data.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
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

        holder.card_hasil_penyakit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FragmentManager manager = ((AppCompatActivity)activity).getSupportFragmentManager();
                DialogFormPenyakit dialog = new DialogFormPenyakit(
                        data.getPenyakit(),
                        data.getTanggalTerjangkit(),
                        data.getGangguanTelinga(),
                        data.getGangguanHidung(),
                        data.getGangguanTenggorokan(),
                        data.getObat(),
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
