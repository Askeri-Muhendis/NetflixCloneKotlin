package com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.ibrahimethemsen.netflixclonekotlin.R
import com.ibrahimethemsen.netflixclonekotlin.databinding.FragmentOnBoardingBinding
import com.ibrahimethemsen.netflixclonekotlin.presentation.model.ViewPagerModel
import com.ibrahimethemsen.netflixclonekotlin.utility.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {
    private val binding by viewBinding(FragmentOnBoardingBinding::bind)
    private var viewPagerAdapter : ViewPagerAdapter? = null
    private var viewPager : ViewPager2? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onBoardingMenu.setOnClickListener {
            println("Button")
            showMenu(it)
        }
        viewPager = binding.viewPager
        viewPagerAdapter = ViewPagerAdapter(this,viewPagerListProvider())
        viewPager?.let {
            it.adapter = viewPagerAdapter
            TabLayoutMediator(binding.onBoardingTabLayout,it){_,_ -> }.attach()
        }
    }

    private fun viewPagerListProvider() : MutableList<ViewPagerModel>{
        val viewPagerList = mutableListOf<ViewPagerModel>()
        viewPagerList.add(viewPagerItemProvider(
            backgroundVP = R.drawable.viewpager,
            titleVP = "Deneme1",
            subTitleVP = "deneme2"
        ))
        viewPagerList.add(viewPagerItemProvider(
            backgroundVP = R.drawable.viewpager_one,
            titleVP = "Deneme3",
            subTitleVP = "deneme4"
        ))
        viewPagerList.add(viewPagerItemProvider(
            backgroundVP = R.drawable.viewpager_two,
            titleVP = "Deneme5",
            subTitleVP = "deneme6"
        ))
        viewPagerList.add(viewPagerItemProvider(
            backgroundVP = R.drawable.viewpager_three,
            titleVP = "Deneme7",
            subTitleVP = "deneme8"
        ))
        return viewPagerList
    }

    private fun viewPagerItemProvider(
        @DrawableRes backgroundVP : Int,
        titleVP : String,
        subTitleVP : String
    ) : ViewPagerModel {
        return ViewPagerModel(
            viewPagerBackground = backgroundVP,
            viewPagerTitle = titleVP,
            viewPagerSubTitle = subTitleVP
        )
    }
    private fun showMenu(v: View) {
        PopupMenu(requireContext(), v).apply {
            // MainActivity implements OnMenuItemClickListener
            setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.onboardingHelp -> {
                        true
                    }
                    R.id.onboardingSss -> {
                        true
                    }
                    else -> false
                }
            }
            inflate(R.menu.onboarding_menu)
            show()
        }
    }
}