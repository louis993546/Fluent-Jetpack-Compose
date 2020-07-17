package io.github.louistsaitszho.fluent.design_language

import androidx.ui.core.Modifier
import androidx.ui.core.zIndex

fun Modifier.elevate(distance: Distance): Modifier = this.zIndex(distance.elevation.toFloat())

enum class Distance(val elevation: Int) {
    z01(1),
    z02(2),
    z03(3),
    z04(4),
    z06(6),
    z08(8),
    z12(12),
    z16(16),
    z24(24)
}