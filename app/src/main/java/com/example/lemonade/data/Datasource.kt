package com.example.lemonade.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.lemonade.R
import com.example.lemonade.model.StateLemonade

enum class States {
    LEMON_TREE,
    LEMON_SQUEEZE,
    LEMON_DRINK,
    LEMON_RESTART
}

val statesLemonade = listOf(
    StateLemonade(
        States.LEMON_TREE,
        R.string.lemon_select,
        R.drawable.lemon_tree,
        R.string.lemon_tree_content_description
    ),
    StateLemonade(
        States.LEMON_SQUEEZE,
        R.string.lemon_squeeze,
        R.drawable.lemon_squeeze,
        R.string.lemon_content_description
    ),
    StateLemonade(
        States.LEMON_DRINK,
        R.string.lemon_drink,
        R.drawable.lemon_drink,
        R.string.lemonade_content_description
    ),
    StateLemonade(
        States.LEMON_RESTART,
        R.string.lemon_empty_glass,
        R.drawable.lemon_restart,
        R.string.empty_glass_content_description
    )
)