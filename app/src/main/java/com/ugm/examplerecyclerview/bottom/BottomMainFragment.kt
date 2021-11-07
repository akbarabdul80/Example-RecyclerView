package com.ugm.examplerecyclerview.bottom

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.oratakashi.viewbinding.core.binding.bottomsheet.viewBinding
import com.oratakashi.viewbinding.core.tools.onClick
import com.ugm.examplerecyclerview.data.DataMahasiswa
import com.ugm.examplerecyclerview.databinding.FragmentBottomMainBinding

class BottomMainFragment : BottomSheetDialogFragment() {

    private val binding: FragmentBottomMainBinding by viewBinding()
    private var parent: BottomMainInterface? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnSimpan.setOnClickListener {

            }

            btnSimpan.onClick {
                when {
                    etNama.text.toString().isEmpty() -> {
                        etNama.error = "Silahkan isi Nama!"
                    }

                    etNim.text.toString().isEmpty() -> {
                        etNim.error = "Silahkan isi Nama!"
                    }

                    else -> {
                        parent!!.onSubmit(
                            DataMahasiswa(
                                etNama.text.toString(),
                                etNim.text.toString()
                            )
                        )

                        dismiss()
                    }
                }
            }
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parent = context as BottomMainInterface
    }

    interface BottomMainInterface {
        fun onSubmit(data: DataMahasiswa)
    }


}