package com.github.rstanic12.resourceful

import android.app.Activity
import android.app.Dialog
import android.app.DialogFragment
import android.app.Fragment
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.ReadOnlyProperty
import androidx.fragment.app.DialogFragment as SupportDialogFragment
import androidx.fragment.app.Fragment as SupportFragment

fun View.bindDimenPixelSize(id: Int): ReadOnlyProperty<View, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun Activity.bindDimenPixelSize(id: Int): ReadOnlyProperty<Activity, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun Dialog.bindDimenPixelSize(id: Int): ReadOnlyProperty<Dialog, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun DialogFragment.bindDimenPixelSize(id: Int): ReadOnlyProperty<DialogFragment, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun SupportDialogFragment.bindDimenPixelSize(id: Int): ReadOnlyProperty<SupportDialogFragment, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun Fragment.bindDimenPixelSize(id: Int): ReadOnlyProperty<Fragment, Int> =
        requiredDimenPixelSize(id, dimenFinder)

fun SupportFragment.bindDimenPixelSize(id: Int): ReadOnlyProperty<SupportFragment, Int> =
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

private val SupportDialogFragment.dimenFinder: SupportDialogFragment.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val Fragment.dimenFinder: Fragment.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val SupportFragment.dimenFinder: SupportFragment.(Int) -> Int?
    get() = { resources.getDimensionPixelSize(it) }

private val RecyclerView.ViewHolder.dimenFinder: RecyclerView.ViewHolder.(Int) -> Int?
    get() = { itemView.context.resources.getDimensionPixelSize(it) }

private val Resourceable.dimenFinder: Resourceable.(Int) -> Int?
    get() = { getContext().resources.getDimensionPixelSize(it) }

private fun <T> requiredDimenPixelSize(id: Int, finder: T.(Int) -> Int?) =
        Lazy { t: T, _ -> t.finder(id) ?: resourceNotFound(id) }
