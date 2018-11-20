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

fun View.bindString(id: Int): ReadOnlyProperty<View, String> =
        requiredString(id, stringFinder)

fun Activity.bindString(id: Int): ReadOnlyProperty<Activity, String> =
        requiredString(id, stringFinder)

fun Dialog.bindString(id: Int): ReadOnlyProperty<Dialog, String> =
        requiredString(id, stringFinder)

fun DialogFragment.bindString(id: Int): ReadOnlyProperty<DialogFragment, String> =
        requiredString(id, stringFinder)

fun SupportDialogFragment.bindString(id: Int): ReadOnlyProperty<SupportDialogFragment, String> =
        requiredString(id, stringFinder)

fun Fragment.bindString(id: Int): ReadOnlyProperty<Fragment, String> =
        requiredString(id, stringFinder)

fun SupportFragment.bindString(id: Int): ReadOnlyProperty<SupportFragment, String> =
        requiredString(id, stringFinder)

fun RecyclerView.ViewHolder.bindString(id: Int): ReadOnlyProperty<RecyclerView.ViewHolder, String> =
        requiredString(id, stringFinder)

fun Resourceable.bindString(id: Int): ReadOnlyProperty<Resourceable, String> =
        requiredString(id, stringFinder)

private val View.stringFinder: View.(Int) -> String?
    get() = { context.getString(it) }

private val Activity.stringFinder: Activity.(Int) -> String?
    get() = { getString(it) }

private val Dialog.stringFinder: Dialog.(Int) -> String?
    get() = { context.getString(it) }

private val DialogFragment.stringFinder: DialogFragment.(Int) -> String?
    get() = { getString(it) }

private val SupportDialogFragment.stringFinder: SupportDialogFragment.(Int) -> String?
    get() = { getString(it) }

private val Fragment.stringFinder: Fragment.(Int) -> String?
    get() = { getString(it) }

private val SupportFragment.stringFinder: SupportFragment.(Int) -> String?
    get() = { getString(it) }

private val RecyclerView.ViewHolder.stringFinder: RecyclerView.ViewHolder.(Int) -> String?
    get() = { itemView.context.getString(it) }

private val Resourceable.stringFinder: Resourceable.(Int) -> String?
    get() = { getContext().getString(it) }

private fun <T> requiredString(id: Int, finder: T.(Int) -> String?) =
        Lazy { t: T, _ -> t.finder(id) ?: resourceNotFound(id) }
