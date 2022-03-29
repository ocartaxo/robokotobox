package ufba.unidade.um.robots.holyfield

import robocode.AdvancedRobot
import robocode.ScannedRobotEvent
import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Point2D
import java.awt.geom.Rectangle2D
import kotlin.math.*

import ufba.unidade.um.robots.utils.*

class HolyfieldRobot : AdvancedRobot() {

    companion object {

        private const val HALF_ROBOT_SIZE: Double = 18.0


    }

    private var target: Enemy? = null

    override fun run() {
        setupRobot()
        do {
            radarConfig()
            if(hasTarget()){
                esbgacaTarget(target!!)
            }
        } while (true)
    }

    private fun esbgacaTarget(enemy: Enemy) {
        TODO("Not yet implemented")
    }

    private fun hasTarget() = target != null

    private fun onHit(){
        if(velocity == 0.0) {
            TODO("change direction of the robot")
        }
    }

    private fun radarConfig() {
        var radarOffset = 360.0


        radarOffset = radarHeadingRadians - absbearing(currentPosition(), target!!.pos)
        if (radarOffset < 0) radarOffset -= PI / 8 else radarOffset += PI / 8

        setTurnRadarLeftRadians(normaliseBearing(radarOffset))
    }

    private fun currentPosition() = Point2D.Double(x, y)

    override fun onScannedRobot(event: ScannedRobotEvent?) {
        TODO("Not yet implemented!")
    }

    private fun setupRobot() {
        setColors(Color.blue, Color.red.darker(), Color.white)

        isAdjustGunForRobotTurn = true
        isAdjustRadarForGunTurn = true

        isAdjustGunForRobotTurn = true
        isAdjustRadarForGunTurn = true

        setupInitPosition()


    }

    private fun setupInitPosition() {
        TODO("Not yet implemented")
    }

}