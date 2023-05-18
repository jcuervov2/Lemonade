package com.example.lemonade.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.lemonade.data.States

class StateLemonade(
    val state: States,
    @StringRes val idString: Int,
    @DrawableRes val idDrawable: Int,
    @StringRes val idContentDescription: Int,
    )