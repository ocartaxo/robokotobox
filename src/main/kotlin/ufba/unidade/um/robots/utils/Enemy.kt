package ufba.unidade.um.robots.utils

import java.awt.geom.Point2D
import kotlin.math.cos
import kotlin.math.sin

data class Enemy(
    val name: String,
    var pos: Point2D.Double,
    var bearing: Double,
    var bearingRadians: Double,
    val heading: Double,
    var headingRadians: Double,
    var velocity: Double,
    var distance: Double,
    var timeOfScan: Long,
    var energy: Double
) {
    fun guessX(atTime: Long, battleFieldWidth: Double, robotSize: Double): Double {
        val diff: Long = atTime - timeOfScan
        return (pos.x + sin(headingRadians) * velocity * diff).coerceAtMost(robotSize)
            .coerceAtLeast(robotSize)
    }

    fun guessY(atTime: Long, battleFieldHeight: Double, robotSize: Double): Double {
        val diff: Long = atTime - timeOfScan
        return (pos.y + cos(headingRadians) * velocity * diff).coerceAtMost(battleFieldHeight - robotSize)
            .coerceAtLeast(robotSize)
    }

}
