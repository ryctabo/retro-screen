package com.ryctabo.retroscreen.commands.`typeof`

import com.ryctabo.retroscreen.commands.Command
import com.ryctabo.retroscreen.commands.CommandResult
import com.ryctabo.retroscreen.model.RetroScreen

class MoveFigureCommand(
    private val symbol: String,
    private val offsetX: Int,
    private val offsetY: Int
) : Command {
    override fun invoke(retroScreen: RetroScreen): CommandResult {
        val figure = retroScreen.figures.find { it.symbol == symbol } ?: throw IllegalArgumentException(
            "Figure with symbol $symbol was not found"
        )

        val newPositions = figure.positions.map { (x, y) ->
            x + offsetX to y + offsetY
        }

        figure.positions = newPositions.toSet()

        return CommandResult.SUCCESS
    }
}