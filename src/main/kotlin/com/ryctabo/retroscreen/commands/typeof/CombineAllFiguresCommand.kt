package com.ryctabo.retroscreen.commands.`typeof`

import com.ryctabo.retroscreen.commands.Command
import com.ryctabo.retroscreen.commands.CommandResult
import com.ryctabo.retroscreen.model.Figure
import com.ryctabo.retroscreen.model.RetroScreen

class CombineAllFiguresCommand : Command {
    override fun invoke(retroScreen: RetroScreen): CommandResult {
        if (retroScreen.figures.isEmpty()) {
            error("Figures on screen doesn't exists")
        }
        val symbol = retroScreen.figures.last().symbol
        val positions = retroScreen.figures.flatMap { it.positions }.toSet()
        retroScreen.figures.clear()
        retroScreen.figures.add(Figure(symbol, positions))
        return CommandResult.SUCCESS
    }
}