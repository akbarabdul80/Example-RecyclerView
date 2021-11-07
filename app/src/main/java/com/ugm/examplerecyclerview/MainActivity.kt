package com.ugm.examplerecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.oratakashi.viewbinding.core.binding.activity.viewBinding
import com.oratakashi.viewbinding.core.tools.onClick
import com.oratakashi.viewbinding.core.tools.toast
import com.ugm.examplerecyclerview.bottom.BottomMainFragment
import com.ugm.examplerecyclerview.data.DataMahasiswa
import com.ugm.examplerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BottomMainFragment.BottomMainInterface {

    private val adapter: MainAdapterV2 by lazy {
        MainAdapterV2 {
            toast("${it.nama} ${it.nim}")
        }
    }

    //    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }
//
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val rvData: RecyclerView = findViewById(R.id.rvData)
//
//        rvData.also {
//            it.adapter = adapter
//            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        }

        with(binding) {
            rvData.also {
                it.adapter = adapter
                it.layoutManager =
                    LinearLayoutManager(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL, false
                    )
            }

            btnAdd.onClick {
                BottomMainFragment().apply {
                    show(supportFragmentManager, "Bottom Add")
                }
            }
        }

        val dataMahasiswa = listOf(
            DataMahasiswa(
                "Budiman",
                "231321/SV/2312"
            ),
            DataMahasiswa(
                "Budisan",
                "231343/SV/2312"
            ),
            DataMahasiswa(
                "Budian",
                "231376/SV/2312"
            )
        )

        adapter.submitData(dataMahasiswa)

    }

    override fun onSubmit(data: DataMahasiswa) {
        adapter.submitItem(data)
        toast("Berhasil menambahkan data!")
    }
}