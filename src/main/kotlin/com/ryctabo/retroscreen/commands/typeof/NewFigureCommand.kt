package com.ryctabo.retroscreen.commands.`typeof`

import com.ryctabo.retroscreen.commands.Command
import com.ryctabo.retroscreen.commands.CommandResult
import com.ryctabo.retroscreen.model.Figure
import com.ryctabo.retroscreen.model.Position
import com.ryctabo.retroscreen.model.RetroScreen

class NewFigureCommand(
    private val symbol: String,
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int
) : Command {

    override operator fun invoke(retroScreen: RetroScreen): CommandResult {
        require(retroScreen.figures.none { it.symbol == symbol }) {
            "Right now exists a figure with that symbol"
        }

        val positions: MutableSet<Position> = mutableSetOf()

        for (positionX in x..<x + width) {
            for (positionY in y..<y + height) {
                positions.add(positionX to positionY)
            }
        }

        retroScreen.figures.add(Figure(symbol, positions))

        return CommandResult.SUCCESS
    }
}