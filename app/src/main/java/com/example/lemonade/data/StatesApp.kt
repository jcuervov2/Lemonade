package com.example.lemonade.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.lemonade.R

enum class States {
    LEMON_TREE,
    LEMON_SQUEEZE,
    LEMON_DRINK,
    LEMON_RESTART
}

data class StatesApp (
    val state: States,
    @StringRes val idString: Int,
    @DrawableRes val idDrawable: Int,
    @StringRes val idContentDescription: Int,

)

val statesLemonade = listOf(
    StatesApp(
        States.LEMON_TREE,
        R.string.lemon_select,
        R.drawable.lemon_tree,
        R.string.lemon_tree_content_description
    ),
    StatesApp(
        States.LEMON_SQUEEZE,
        R.string.lemon_squeeze,
        R.drawable.lemon_squeeze,
        R.string.lemon_content_description
    ),
    StatesApp(
        States.LEMON_DRINK,
        R.string.lemon_drink,
        R.drawable.lemon_drink,
        R.string.lemonade_content_description
    ),
    StatesApp(
        States.LEMON_RESTART,
        R.string.lemon_empty_glass,
        R.drawable.lemon_restart,
        R.string.empty_glass_content_description
    )
)