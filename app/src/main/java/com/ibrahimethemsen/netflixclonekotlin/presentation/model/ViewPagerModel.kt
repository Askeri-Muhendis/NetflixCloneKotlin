package com.ibrahimethemsen.netflixclonekotlin.presentation.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class ViewPagerModel(
    @DrawableRes val viewPagerBackground: Int,
    val viewPagerTitle: String,
    val viewPagerSubTitle: String
) : Parcelable
