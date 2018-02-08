package com.github.rstanic12.resourceful

import android.app.Activity
import android.app.Dialog
import android.app.DialogFragment
import android.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlin.properties.ReadOnlyProperty

fun View.bindDimen(id: Int): ReadOnlyProperty<View, Float> =
        requiredDimen(id, dimenFinder)

fun Activity.bindDimen(id: Int): ReadOnlyProperty<Activity, Float> =
        requiredDimen(id, dimenFinder)

fun Dialog.bindDimen(id: Int): ReadOnlyProperty<Dialog, Float> =
        requiredDimen(id, dimenFinder)

fun DialogFragment.bindDimen(id: Int): ReadOnlyProperty<DialogFragment, Float> =
        requiredDimen(id, dimenFinder)

fun android.support.v4.app.DialogFragment.bindDimen(id: Int): ReadOnlyProperty<android.support.v4.app.DialogFragment, Float> =
        requiredDimen(id, dimenFinder)

fun Fragment.bindDimen(id: Int): ReadOnlyProperty<Fragment, Float> =
        requiredDimen(id, dimenFinder)

fun android.support.v4.app.Fragment.bindDimen(id: Int): ReadOnlyProperty<android.support.v4.app.Fragment, Float> =
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

private val android.support.v4.app.DialogFragment.dimenFinder: android.support.v4.app.DialogFragment.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val Fragment.dimenFinder: Fragment.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val android.support.v4.app.Fragment.dimenFinder: android.support.v4.app.Fragment.(Int) -> Float?
    get() = { resources.getDimension(it) }

private val RecyclerView.ViewHolder.dimenFinder: RecyclerView.ViewHolder.(Int) -> Float?
    get() = { itemView.context.resources.getDimension(it) }

private val Resourceable.dimenFinder: Resourceable.(Int) -> Float?
    get() = { getContext().resources.getDimension(it) }

private fun <T> requiredDimen(id: Int, finder: T.(Int) -> Float?) =
        Lazy { t: T, _ -> t.finder(id) ?: resourceNotFound(id) }
