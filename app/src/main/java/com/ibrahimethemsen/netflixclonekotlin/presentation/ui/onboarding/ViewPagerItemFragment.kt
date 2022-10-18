package com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding


import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ibrahimethemsen.netflixclonekotlin.R
import com.ibrahimethemsen.netflixclonekotlin.databinding.FragmentViewPagerItemBinding
import com.ibrahimethemsen.netflixclonekotlin.presentation.model.ViewPagerModel
import com.ibrahimethemsen.netflixclonekotlin.utility.Constants.ONBOARDING_VIEWPAGER
import com.ibrahimethemsen.netflixclonekotlin.utility.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ViewPagerItemFragment : Fragment(R.layout.fragment_view_pager_item) {

    private val binding by viewBinding(FragmentViewPagerItemBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.apply {
            val viewPagerModel : ViewPagerModel? = if (Build.VERSION.SDK_INT >= 33){
                getParcelable(ONBOARDING_VIEWPAGER,ViewPagerModel::class.java)
            }else{
                getParcelable(ONBOARDING_VIEWPAGER)
            }
            viewPagerModel?.let {
                binding.viewPagerItemBackground.setImageResource(it.viewPagerBackground)
                binding.viewPagerItemTitle.text = it.viewPagerTitle
                binding.viewPagerItemSubTitle.text = it.viewPagerSubTitle
            }
        }

    }
}