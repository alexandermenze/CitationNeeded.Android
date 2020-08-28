package de.alexandermenze.citationneeded.extensions

import android.view.MenuItem
import androidx.annotation.MenuRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import de.alexandermenze.citationneeded.R

fun Fragment.navigateUp(): Boolean {
    return findNavController().navigateUp()
}

fun Fragment.createToolbar(
    toolbar: Toolbar,
    @MenuRes layoutId: Int,
    title: String,
    clickListener: (MenuItem) -> Boolean
) {
    toolbar.inflateMenu(layoutId)
    toolbar.title = title
    toolbar.setOnMenuItemClickListener(clickListener)
    NavigationUI.setupWithNavController(toolbar, findNavController())
}

fun Fragment.createToolbar(
    toolbar: Toolbar,
    title: String,
    clickListener: ((MenuItem) -> Boolean)? = null
) {
    toolbar.inflateMenu(R.menu.empty)
    toolbar.title = title
    clickListener?.let { toolbar.setOnMenuItemClickListener(it) }
    NavigationUI.setupWithNavController(toolbar, findNavController())
}