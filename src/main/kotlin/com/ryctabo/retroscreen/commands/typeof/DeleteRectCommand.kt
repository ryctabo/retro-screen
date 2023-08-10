package com.ryctabo.retroscreen.commands.`typeof`

import com.ryctabo.retroscreen.commands.Command
import com.ryctabo.retroscreen.commands.CommandResult
import com.ryctabo.retroscreen.model.RetroScreen

class DeleteRectCommand(
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int
) : Command {
    override fun invoke(retroScreen: RetroScreen): CommandResult {
        retroScreen.figures.forEach { fig ->
            val newPositions = fig.positions.filter { (pX, pY) ->
                !(x <= pX && pX < (x + width) && y <= pY && pY < (y + height))
            }
            fig.positions = newPositions.toSet()
        }
        return CommandResult.SUCCESS
    }
}