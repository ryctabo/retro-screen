package com.ryctabo.retroscreen

class NewFigureUseCase(
    private val symbol: String,
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int
) : UseCase {

    override operator fun invoke(retroScreen: RetroScreen) {
        val figure: Figure = mutableListOf()
        for (positionX in x..<x + width) {
            for (positionY in y..<y + height) {
                figure.add(Triple(positionX, positionY, symbol))
            }
        }
        retroScreen.figures.add(figure)
    }
}