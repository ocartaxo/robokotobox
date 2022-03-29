package ufba.unidade.um.robots.utils



import java.io.BufferedWriter
import java.io.FileWriter
import java.util.Scanner

object BattleFileHandler {

    private const val DELIMTER = "="
    private var scanner: Scanner? = null
    private const val FILE_PATH = "./setup/battle/testBattle.battle"
    
    init {
        scanner = Scanner(FILE_PATH)
        scanner?.useDelimiter(DELIMTER)
    }

    fun read(pattern: String): String? {
        return scanner?.findInLine(pattern)
    }

    fun update(vararg newValues: String){

        val fileValues = newValues.map { v -> read(v) }.filterNotNull()
        val writer: BufferedWriter = BufferedWriter(FileWriter(FILE_PATH))

        if (fileValues.isEmpty()) {
            newValues.forEach {
                TODO("write values in file")
            }
        } else {
            newValues.forEach {
                TODO("update values")
            }

        }


    }

}