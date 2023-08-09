package com.ryctabo.retroscreen

fun main(args: Array<String>) {
    require(args.size == 2) {
        "Must provide two parameters to run retroscreen program"
    }

    require(args.all { Regex("[0-9]+").matches(it) }) {
        "Provide a valid parameters"
    }

    val retroScreen = RetroScreen(args[0].toUInt(), args[1].toUInt())

    do {
        retroScreen.printScreen()
        val command = readln()
        CommandManager.execute(command, retroScreen)
    } while (command != "exit")
}

class RetroScreen(private val x: UInt, private val y: UInt) {
    val figures = mutableListOf<Figure>()
    fun printScreen() {
        for (positionY in 0..<y.toInt()) {
            for (positionX in 0..<x.toInt()) {
                val symbol = figures.lastOrNull { fig ->
                    fig.any { (x, y, _) -> x == positionX && y == positionY }
                }?.first()?.third

                print(symbol?.let { "$it " } ?: "_ ")
            }
            println()
        }
    }
}

typealias Figure = MutableList<Triple<Int, Int, String>>

object CommandManager {
    fun execute(command: String, retroScreen: RetroScreen) {
        when (extractCommand(command)) {
            "new" -> {
                val args = extractArguments(command)
                val symbol = args[1]
                val x = args[2].toInt()
                val y = args[3].toInt()
                val width = args[4].toInt()
                val height = args[5].toInt()

                NewFigureUseCase(symbol, x, y, width, height)
            }

            "delete" -> {
                println("Executing command delete")
            }

            "move" -> {
                println("Executing command move")
            }

            "combine" -> {
                println("Executing command combine")
            }

            "delete_rect" -> {
                println("Executing command delete_rect")
            }
        }
    }

}

private fun extractCommand(command: String) = command.split(" ")[0]

private fun extractArguments(command: String) = command.split(" ")