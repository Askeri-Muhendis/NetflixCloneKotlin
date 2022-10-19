package com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.ibrahimethemsen.netflixclonekotlin.R
import com.ibrahimethemsen.netflixclonekotlin.databinding.FragmentOnBoardingBinding
import com.ibrahimethemsen.netflixclonekotlin.presentation.model.ViewPagerModel
import com.ibrahimethemsen.netflixclonekotlin.presentation.ui.onboarding.adapter.ViewPagerAdapter
import com.ibrahimethemsen.netflixclonekotlin.utility.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {
    private val binding by viewBinding(FragmentOnBoardingBinding::bind)
    private var viewPagerAdapter: ViewPagerAdapter? = null
    private var viewPager: ViewPager2? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onBoardingMenu.setOnClickListener {
            println("Button")
            showMenu(it)
        }
        viewPager = binding.viewPager
        viewPagerAdapter = ViewPagerAdapter(this, viewPagerListProvider())
        viewPager?.let {
            it.adapter = viewPagerAdapter
            TabLayoutMediator(binding.onBoardingTabLayout, it) { _, _ -> }.attach()
        }
        binding.onBoardingPrivacyBtn.setOnClickListener {
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("https://github.com/Askeri-Muhendis/NetflixCloneKotlin")
            startActivity(url)
        }


    }

    private fun viewPagerListProvider(): MutableList<ViewPagerModel> {
        val viewPagerList = mutableListOf<ViewPagerModel>()
        viewPagerList.add(
            viewPagerItemProvider(
                backgroundVP = R.drawable.viewpager,
                titleVP = getString(R.string.viewpager_title_txt),
                subTitleVP = getString(R.string.viewpager_subtitle_txt)
            )
        )
        viewPagerList.add(
            viewPagerItemProvider(
                backgroundVP = R.drawable.viewpager_one,
                titleVP = getString(R.string.viewpager_title_one_txt),
                subTitleVP = getString(R.string.viewpager_subtitle_one_txt)
            )
        )
        viewPagerList.add(
            viewPagerItemProvider(
                backgroundVP = R.drawable.viewpager_two,
                titleVP = getString(R.string.viewpager_title_two_txt),
                subTitleVP = getString(R.string.viewpager_subtitle_two_txt)
            )
        )
        viewPagerList.add(
            viewPagerItemProvider(
                backgroundVP = R.drawable.viewpager_three,
                titleVP = getString(R.string.viewpager_title_three_txt),
                subTitleVP = getString(R.string.viewpager_subtitle_three_txt)
            )
        )
        return viewPagerList
    }

    private fun viewPagerItemProvider(
        @DrawableRes backgroundVP: Int,
        titleVP: String,
        subTitleVP: String
    ): ViewPagerModel {
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
                when (it.itemId) {
                    R.id.onboardingHelp -> {
                        true
                    }
                    R.id.onboardingSss -> {
                        val action = OnBoardingFragmentDirections.actionOnBoardingFragmentToBottomSheetSssFragment()
                        requireView().findNavController().navigate(action)
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