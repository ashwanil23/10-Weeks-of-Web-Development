package com.kingkong.a10weeksofwebdev.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class _10WeeksOfWebDev(
    @StringRes val weekRes: Int,
    @StringRes val titleRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int
)
