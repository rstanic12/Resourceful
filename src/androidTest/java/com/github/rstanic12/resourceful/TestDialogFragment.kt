package com.github.rstanic12.resourceful

import android.app.DialogFragment

class TestDialogFragment : DialogFragment() {
    val color: Int by bindColor(R.color.test_color)
    val dimen: Float by bindDimen(R.dimen.test_dimen)
    val dimenPx: Int by bindDimenPixelSize(R.dimen.test_dimen)
    val string: String by bindString(R.string.test_string)
}