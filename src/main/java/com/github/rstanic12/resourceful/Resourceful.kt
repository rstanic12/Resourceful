@file:Suppress("UNCHECKED_CAST")

package com.github.rstanic12.resourceful

import android.content.res.Resources
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

internal fun resourceNotFound(id: Int): Nothing =
        throw Resources.NotFoundException("Resource with ID: $id not found.")

internal class Lazy<in T, out V>(private val initializer: (T, KProperty<*>) -> V) : ReadOnlyProperty<T, V> {
    private var value: Any? = null

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        if (value == null) {
            value = initializer(thisRef, property)
        }
        return value as V
    }
}
