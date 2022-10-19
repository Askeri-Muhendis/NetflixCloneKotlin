package com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ibrahimethemsen.netflixclonekotlin.presentation.model.ViewPagerModel
import com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding.ViewPagerItemFragment
import com.ibrahimethemsen.netflixclonekotlin.utility.Constants.ONBOARDING_VIEWPAGER

class ViewPagerAdapter(
    fragment: Fragment,
    private val list: MutableList<ViewPagerModel>
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {
        val fragment = ViewPagerItemFragment()
        fragment.arguments = Bundle().apply {
            val viewPagerItem = ViewPagerModel(
                viewPagerBackground = list[position].viewPagerBackground,
                viewPagerTitle = list[position].viewPagerTitle,
                viewPagerSubTitle = list[position].viewPagerSubTitle
            )
            putParcelable(ONBOARDING_VIEWPAGER,viewPagerItem)
        }
        return fragment
    }

}