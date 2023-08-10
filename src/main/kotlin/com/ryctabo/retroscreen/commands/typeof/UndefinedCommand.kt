package com.ryctabo.retroscreen.commands.`typeof`

import com.ryctabo.retroscreen.model.RetroScreen
import com.ryctabo.retroscreen.commands.Command
import com.ryctabo.retroscreen.commands.CommandResult

class UndefinedCommand() : Command {
    override fun invoke(retroScreen: RetroScreen): CommandResult {
        return CommandResult.UNDEFINED
    }
}