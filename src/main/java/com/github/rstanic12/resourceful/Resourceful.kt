@file:Suppress("UNCHECKED_CAST")

package com.github.rstanic12.resourceful

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import android.support.v4.app.DialogFragment as SupportDialogFragment
import android.support.v4.app.Fragment as SupportFragment

internal fun resourceNotFound(id: Int): Nothing =
        throw IllegalStateException("Resource with ID: $id not found.")

internal class Lazy<in T, out V>(private val initializer: (T, KProperty<*>) -> V) : ReadOnlyProperty<T, V> {
    private object EMPTY

    private var value: Any? = EMPTY

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        if (value == EMPTY) {
            value = initializer(thisRef, property)
        }
        return value as V
    }
}
