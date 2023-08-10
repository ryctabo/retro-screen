package com.ryctabo.retroscreen.commands

import com.ryctabo.retroscreen.model.RetroScreen

fun interface Command {
    operator fun invoke(retroScreen: RetroScreen): CommandResult
}