@file:Suppress("unused")

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

fun View.bindDimen(id: Int): ReadOnlyProperty<View, Float> =
        requiredDimen(id, dimenFinder)

fun Activity.bindDimen(id: Int): ReadOnlyProperty<Activity, Float> =
        requiredDimen(id, dimenFinder)

fun Dialog.bindDimen(id: Int): ReadOnlyProperty<Dialog, Float> =
        requiredDimen(id, dimenFinder)

fun DialogFragment.bindDimen(id: Int): ReadOnlyProperty<DialogFragment, Float> =
        requiredDimen(id, dimenFinder)

fun SupportDialogFragment.bindDimen(id: Int): ReadOnlyProperty<SupportDialogFragment, Float> =
        requiredDimen(id, dimenFinder)

fun Fragment.bindDimen(id: Int): ReadOnlyProperty<Fragment, Float> =
        requiredDimen(id, dimenFinder)

fun SupportFragment.bindDimen(id: Int): ReadOnlyProperty<SupportFragment, Float> =
        requiredDimen(id, dimenFinder)

fun RecyclerView.ViewHolder.bindDimen(id: Int): ReadOnlyProperty<RecyclerView.ViewHolder, Float> =
        requiredDimen(id, dimenFinder)

fun Resourceable.bindDimen(id: Int): ReadOnlyProperty<Resourceable, Float> =
        requiredDimen(id, dimenFinder)

private val View.dimenFinder: View.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val Activity.dimenFinder: Activity.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val Dialog.dimenFinder: Dialog.(Int) -> Float?
    get() = { context.resources.getDimension(it) }

private val DialogFragment.dimenFinder: DialogFragment.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val SupportDialogFragment.dimenFinder: SupportDialogFragment.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val Fragment.dimenFinder: Fragment.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val SupportFragment.dimenFinder: SupportFragment.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val RecyclerView.ViewHolder.dimenFinder: RecyclerView.ViewHolder.(Int) -> Float?
    get() = { itemView.context.resources.getDimension(it) }

private val Resourceable.dimenFinder: Resourceable.(Int) -> Float?
    get() = { getContext().resources.getDimension(it) }

private fun <T> requiredDimen(id: Int, finder: T.(Int) -> Float?) =
        Lazy { t: T, _ -> t.finder(id) ?: resourceNotFound(id) }
