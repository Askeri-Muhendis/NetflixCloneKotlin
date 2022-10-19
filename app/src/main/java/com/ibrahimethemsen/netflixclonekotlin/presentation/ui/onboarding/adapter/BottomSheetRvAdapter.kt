package com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimethemsen.netflixclonekotlin.databinding.BottomSheetRecyclerviewItemBinding

class BottomSheetRvAdapter(
    var list : List<String>
) : RecyclerView.Adapter<BottomSheetRvAdapter.BottomSheetViewHolder>() {

    class BottomSheetViewHolder(val binding : BottomSheetRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        val binding = BottomSheetRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BottomSheetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.bottomRecyclerTv.text = this
            }
        }
    }

    override fun getItemCount(): Int = list.size
}