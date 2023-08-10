package com.ryctabo.retroscreen

import com.ryctabo.retroscreen.commands.CommandFactory
import com.ryctabo.retroscreen.commands.CommandResult
import com.ryctabo.retroscreen.commands.CommandString
import com.ryctabo.retroscreen.model.RetroScreen

fun main(args: Array<String>) {
    require(args.size == 2) {
        "Must provide two parameters to run retroscreen program"
    }

    require(args.all { Regex("[0-9]+").matches(it) }) {
        "Provide a valid parameters"
    }

    val retroScreen = RetroScreen(args[0].toUInt(), args[1].toUInt())

    do {
        retroScreen.printScreen()
        val result = runCatching {
            CommandFactory.create(
                CommandString(readln())
            )(retroScreen)
        }.onFailure { ex ->
            println("ERROR: ${ex.message}")
        }.getOrThrow()
    } while (result != CommandResult.EXIT)
}
