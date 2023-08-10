package com.ryctabo.retroscreen.commands.`typeof`

import com.ryctabo.retroscreen.commands.Command
import com.ryctabo.retroscreen.commands.CommandResult
import com.ryctabo.retroscreen.model.RetroScreen

class DeleteFigureCommand(
    private val symbol: String
) : Command {
    override fun invoke(retroScreen: RetroScreen): CommandResult {
        retroScreen.figures.removeIf { fig -> fig.symbol == symbol }
        return CommandResult.SUCCESS
    }
}