package com.ryctabo.retroscreen.model

class RetroScreen(private val x: UInt, private val y: UInt) {
    val figures = mutableListOf<Figure>()
    fun printScreen() {
        for (positionY in 0..<y.toInt()) {
            for (positionX in 0..<x.toInt()) {
                val symbol = figures.lastOrNull { fig ->
                    fig.positions.any { (x, y) -> x == positionX && y == positionY }
                }?.symbol

                print(symbol?.let { "$it " } ?: "_ ")
            }
            println()
        }
    }
}