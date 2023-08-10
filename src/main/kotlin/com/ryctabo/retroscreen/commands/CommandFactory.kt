package com.ryctabo.retroscreen.commands

import com.ryctabo.retroscreen.commands.`typeof`.*

object CommandFactory {
    fun create(command: CommandString): Command {
        return when (command.execution) {
            "exit" -> ExitCommand()
            "new" -> NewFigureCommand(
                symbol = command.args[0],
                x = command.args[1].toInt(),
                y = command.args[2].toInt(),
                width = command.args[3].toInt(),
                height = command.args[4].toInt()
            )

            "delete" -> DeleteFigureCommand(command.args[0])
            "move" -> MoveFigureCommand(
                symbol = command.args[0],
                offsetX = command.args[1].toInt(),
                offsetY = command.args[2].toInt()
            )

            "combine" -> CombineAllFiguresCommand()
            "delete_rect" -> DeleteRectCommand(
                x = command.args[0].toInt(),
                y = command.args[1].toInt(),
                width = command.args[2].toInt(),
                height = command.args[3].toInt()
            )

            else -> UndefinedCommand()
        }
    }
}