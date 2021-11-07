package com.ugm.examplerecyclerview

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oratakashi.viewbinding.core.binding.recyclerview.ViewHolder
import com.oratakashi.viewbinding.core.binding.recyclerview.viewBinding
import com.ugm.examplerecyclerview.data.DataMahasiswa
import com.ugm.examplerecyclerview.databinding.ListMahasiswaBinding

class MainAdapterV3 : RecyclerView.Adapter<ViewHolder<ListMahasiswaBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder<ListMahasiswaBinding> = viewBinding(parent)

    override fun onBindViewHolder(holder: ViewHolder<ListMahasiswaBinding>, position: Int) {
        val dataMahasiswa: DataMahasiswa = data[position]
        with(holder.binding) {
            tvNama.text = dataMahasiswa.nama
            tvNim.text = dataMahasiswa.nim
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