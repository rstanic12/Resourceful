package com.github.rstanic12.resourceful

import android.app.Activity
import android.app.Dialog
import android.app.DialogFragment
import android.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlin.properties.ReadOnlyProperty

fun View.bindDimenPixelSize(id: Int): ReadOnlyProperty<View, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun Activity.bindDimenPixelSize(id: Int): ReadOnlyProperty<Activity, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun Dialog.bindDimenPixelSize(id: Int): ReadOnlyProperty<Dialog, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun DialogFragment.bindDimenPixelSize(id: Int): ReadOnlyProperty<DialogFragment, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun android.support.v4.app.DialogFragment.bindDimenPixelSize(id: Int): ReadOnlyProperty<android.support.v4.app.DialogFragment, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun Fragment.bindDimenPixelSize(id: Int): ReadOnlyProperty<Fragment, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun android.support.v4.app.Fragment.bindDimenPixelSize(id: Int): ReadOnlyProperty<android.support.v4.app.Fragment, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun RecyclerView.ViewHolder.bindDimenPixelSize(id: Int): ReadOnlyProperty<RecyclerView.ViewHolder, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun Resourceable.bindDimenPixelSize(id: Int): ReadOnlyProperty<Resourceable, Int> =
        requiredDimenPixelSize(id, dimenFinder)

private val View.dimenFinder: View.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val Activity.dimenFinder: Activity.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val Dialog.dimenFinder: Dialog.(Int) -> Int?
    get() = { context.resources.getDimensionPixelSize(it) }

private val DialogFragment.dimenFinder: DialogFragment.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val android.support.v4.app.DialogFragment.dimenFinder: android.support.v4.app.DialogFragment.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val Fragment.dimenFinder: Fragment.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val android.support.v4.app.Fragment.dimenFinder: android.support.v4.app.Fragment.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val RecyclerView.ViewHolder.dimenFinder: RecyclerView.ViewHolder.(Int) -> Int?
    get() = { itemView.context.resources.getDimensionPixelSize(it) }

private val Resourceable.dimenFinder: Resourceable.(Int) -> Int?
    get() = { getContext().resources.getDimensionPixelSize(it) }

private fun <T> requiredDimenPixelSize(id: Int, finder: T.(Int) -> Int?) =
        Lazy { t: T, _ -> t.finder(id) ?: resourceNotFound(id) }
