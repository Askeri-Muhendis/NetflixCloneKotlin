package com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ibrahimethemsen.netflixclonekotlin.R
import com.ibrahimethemsen.netflixclonekotlin.databinding.FragmentBottomSheetSssBinding
import com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding.adapter.BottomSheetRvAdapter
import com.ibrahimethemsen.netflixclonekotlin.utility.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetSssFragment : BottomSheetDialogFragment(R.layout.fragment_bottom_sheet_sss) {
    private val binding by viewBinding(FragmentBottomSheetSssBinding::bind)
    private lateinit var rvAdapter: BottomSheetRvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = mutableListOf<String>()
        list.add("Deneme")
        list.add("Deneme2")
        list.add("Deneme3")
        list.add("Deneme4")

        rvAdapter = BottomSheetRvAdapter(list)
        binding.bottomSheetRecyclerView.adapter = rvAdapter
    }

}