package ufba.unidade.um.robots.utils

import java.awt.geom.Point2D
import kotlin.math.PI
import kotlin.math.asin

fun normaliseBearing(ang: Double): Double {
    var normAng = ang
    if (normAng > PI) normAng -= 2 * PI
    if (normAng < -PI) normAng += 2 * PI
    return normAng
}

fun absbearing(p1: Point2D.Double, p2: Point2D.Double): Double {
    val xo = p2.x - p1.x
    val yo = p2.y - p1.y
    val h: Double = p2.distance(p1)
    if (xo > 0 && yo > 0) {
        return asin(xo / h)
    }
    if (xo > 0 && yo < 0) {
        return Math.PI - asin(xo / h)
    }
    if (xo < 0 && yo < 0) {
        return Math.PI + asin(-xo / h)
    }
    return if (xo < 0 && yo > 0) {
        2.0 * Math.PI - asin(-xo / h)
    } else 0.0
}