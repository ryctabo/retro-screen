package com.ryctabo.retroscreen.commands.`typeof`

import com.ryctabo.retroscreen.model.RetroScreen
import com.ryctabo.retroscreen.commands.Command
import com.ryctabo.retroscreen.commands.CommandResult

class ExitCommand : Command {
    override fun invoke(retroScreen: RetroScreen): CommandResult {
        return CommandResult.EXIT
    }
}