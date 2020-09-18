package com.nugrahaa.mahasiswaapparimvp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nugrahaa.mahasiswaapparimvp.model.Mahasiswa
import com.nugrahaa.mahasiswaapparimvp.R
import com.nugrahaa.mahasiswaapparimvp.ui.InputActivity
import kotlinx.android.synthetic.main.list_item.view.*

class ListMahasiswaAdapter(private val listMahasiswa: ArrayList<Mahasiswa>, private val itemClick: OnClickListener): RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.tv_nama
        val tvNoHp: TextView = itemView.tv_hp
        val tvAlamat: TextView = itemView.tv_alamat
        val btnDelete: ImageView = itemView.btn_delete
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

        val mContext = holder.itemView.context
        holder.itemView.setOnClickListener {
            val mIntent = Intent(mContext, InputActivity::class.java)
            mIntent.putExtra("DATA", mahasiswa)
            mContext.startActivity(mIntent)
        }

        holder.btnDelete.setOnClickListener {
            itemClick.deleteMahasiswa(mahasiswa)
        }

    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }

    interface OnClickListener {
        fun deleteMahasiswa(item: Mahasiswa?)
    }
}