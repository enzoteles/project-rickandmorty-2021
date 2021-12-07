package com.example.project_rickandmorty_base.presentation.ui.components.topbar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.project_rickandmorty_base.R

sealed class MenuAction(@StringRes val label:Int, @DrawableRes val icon: Int){
    object Filter: MenuAction(R.string.icon_filter_unselected, R.drawable.ic_filter)
    object FilterSelected: MenuAction(R.string.icon_filter_selected, R.drawable.ic_filter_filled)
}
