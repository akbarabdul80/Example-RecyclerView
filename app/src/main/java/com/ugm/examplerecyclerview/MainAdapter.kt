package com.ugm.examplerecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ugm.examplerecyclerview.data.DataMahasiswa

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.tvNama)
        val nim: TextView = itemView.findViewById(R.id.tvNim)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_mahasiswa, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataMahasiswa: DataMahasiswa = data[position]

        with(holder) {
            nama.text = dataMahasiswa.nama
            nim.text = dataMahasiswa.nim
        }
    }

    override fun getItemCount(): Int = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data: List<DataMahasiswa>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    private val data: MutableList<DataMahasiswa> = ArrayList()
}