package com.github.rstanic12.resourceful

import android.app.Dialog
import android.content.Context

class TestDialog(context: Context) : Dialog(context) {
    val color: Int by bindColor(R.color.test_color)
    val dimen: Float by bindDimen(R.dimen.test_dimen)
    val dimenPx: Int by bindDimenPixelSize(R.dimen.test_dimen)
    val string: String by bindString(R.string.test_string)
}