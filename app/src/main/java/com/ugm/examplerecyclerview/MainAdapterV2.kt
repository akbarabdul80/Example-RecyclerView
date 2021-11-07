package com.ugm.examplerecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oratakashi.viewbinding.core.tools.onClick
import com.ugm.examplerecyclerview.data.DataMahasiswa
import com.ugm.examplerecyclerview.databinding.ListMahasiswaBinding

class MainAdapterV2(
    val onCLick: (DataMahasiswa) -> Unit
) : RecyclerView.Adapter<MainAdapterV2.ViewHolder>() {

    class ViewHolder(val binding: ListMahasiswaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListMahasiswaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataMahasiswa: DataMahasiswa = data[position]

        with(holder.binding) {
            tvNama.text = dataMahasiswa.nama
            tvNim.text = dataMahasiswa.nim
            root.onClick {
                onCLick.invoke(dataMahasiswa)
            }
        }
    }

    override fun getItemCount(): Int = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data: List<DataMahasiswa>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitItem(data: DataMahasiswa) {
        this.data.add(data)
        notifyDataSetChanged()
    }

    private val data: MutableList<DataMahasiswa> = ArrayList()
}