package com.nugrahaa.mahasiswaapparimvp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nugrahaa.mahasiswa_app_ari.model.Mahasiswa
import com.nugrahaa.mahasiswaapparimvp.R
import kotlinx.android.synthetic.main.list_item.view.*

class ListMahasiswaAdapter(private val listMahasiswa: ArrayList<Mahasiswa>): RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.tv_nama
        val tvNoHp: TextView = itemView.tv_hp
        val tvAlamat: TextView = itemView.tv_alamat
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListMahasiswaAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListMahasiswaAdapter.ListViewHolder, position: Int) {
        val mahasiswa = listMahasiswa[position]

        holder.tvName.text = mahasiswa.mahasiswaNama
        holder.tvNoHp.text = mahasiswa.mahasiswaNohp
        holder.tvAlamat.text = mahasiswa.mahasiswaAlamat
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }
}