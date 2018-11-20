@file:Suppress("unused")

package com.github.rstanic12.resourceful

import android.app.Activity
import android.app.Dialog
import android.app.DialogFragment
import android.app.Fragment
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.ReadOnlyProperty
import androidx.fragment.app.DialogFragment as SupportDialogFragment
import androidx.fragment.app.Fragment as SupportFragment

fun View.bindColor(id: Int): ReadOnlyProperty<View, Int> =
        requiredColor(id, colorFinder)

fun Activity.bindColor(id: Int): ReadOnlyProperty<Activity, Int> =
        requiredColor(id, colorFinder)

fun Dialog.bindColor(id: Int): ReadOnlyProperty<Dialog, Int> =
        requiredColor(id, colorFinder)

fun DialogFragment.bindColor(id: Int): ReadOnlyProperty<DialogFragment, Int> =
        requiredColor(id, colorFinder)

fun SupportDialogFragment.bindColor(id: Int): ReadOnlyProperty<SupportDialogFragment, Int> =
        requiredColor(id, colorFinder)

fun Fragment.bindColor(id: Int): ReadOnlyProperty<Fragment, Int> =
        requiredColor(id, colorFinder)

fun SupportFragment.bindColor(id: Int): ReadOnlyProperty<SupportFragment, Int> =
        requiredColor(id, colorFinder)

fun RecyclerView.ViewHolder.bindColor(id: Int): ReadOnlyProperty<RecyclerView.ViewHolder, Int> =
        requiredColor(id, colorFinder)

fun Resourceable.bindColor(id: Int): ReadOnlyProperty<Resourceable, Int> =
        requiredColor(id, colorFinder)

private val View.colorFinder: View.(Int) -> Int?
    get() = { ContextCompat.getColor(context, it) }

private val Activity.colorFinder: Activity.(Int) -> Int?
    get() = { ContextCompat.getColor(this, it) }

private val Dialog.colorFinder: Dialog.(Int) -> Int?
    get() = { ContextCompat.getColor(context, it) }

private val DialogFragment.colorFinder: DialogFragment.(Int) -> Int?
    get() = { ContextCompat.getColor(activity, it) }

private val SupportDialogFragment.colorFinder: SupportDialogFragment.(Int) -> Int?
    get() = { ContextCompat.getColor(activity?.applicationContext!!, it) }

private val Fragment.colorFinder: Fragment.(Int) -> Int?
    get() = { ContextCompat.getColor(activity, it) }

private val SupportFragment.colorFinder: SupportFragment.(Int) -> Int?
    get() = { ContextCompat.getColor(activity?.applicationContext!!, it) }

private val RecyclerView.ViewHolder.colorFinder: RecyclerView.ViewHolder.(Int) -> Int?
    get() = { ContextCompat.getColor(itemView.context, it) }

private val Resourceable.colorFinder: Resourceable.(Int) -> Int?
    get() = { ContextCompat.getColor(getContext(), it) }

private fun <T> requiredColor(id: Int, finder: T.(Int) -> Int?) =
        Lazy { t: T, _ -> t.finder(id) ?: resourceNotFound(id) }
