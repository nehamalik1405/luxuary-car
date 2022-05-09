package com.a.luxurycar.code_files.ui.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.a.luxurycar.R
import com.a.luxurycar.code_files.ui.home.adapter.StorageAdapter
import com.a.luxurycar.code_files.ui.home.model.ImageModel
import com.a.luxurycar.code_files.ui.home.model.StorageModel
import com.a.luxurycar.common.utils.OnItemClickListener
import com.a.luxurycar.common.utils.addOnItemClickListener
import com.a.luxurycar.databinding.FragmentStorageBinding
import java.util.ArrayList


class StorageFragment : Fragment() {

    lateinit var list: ArrayList<StorageModel>
    var _binding: FragmentStorageBinding? = null
    val binding get() = _binding!!;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStorageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEnuireList()
        setRecyclerViewAdapter()

    }

    private fun addEnuireList() {
        list = arrayListOf()
        list.add(StorageModel(R.mipmap.ic_engine,getString(R.string.str_engine_starts)))
        list.add(StorageModel(R.mipmap.ic_anti_flat,getString(R.string.str_anti_flat_spot_management)))
        list.add(StorageModel(R.mipmap.ic_insurance,getString(R.string.str_insurance)))
        list.add(StorageModel(R.mipmap.ic_battery,getString(R.string.str_battery_trickle_vharging)))
        list.add(StorageModel(R.mipmap.ic_sanitization,getString(R.string.str_interior_preparation_and_sanitization)))
        list.add(StorageModel(R.mipmap.ic_tire_rotation,getString(R.string.str_tire_rotation_and_checks)))
    }

    private fun setRecyclerViewAdapter() {
        val storageAdapter = StorageAdapter(list)

        binding.recyclerViewForEnquireList.adapter = storageAdapter
        binding.recyclerViewForEnquireList.setLayoutManager(GridLayoutManager(requireContext(), 2))
        binding.recyclerViewForEnquireList.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
              Toast.makeText(requireContext(),position.toString(),Toast.LENGTH_LONG).show()
            }
        })

    }

}