package com.ryctabo.retroscreen.commands

import com.ryctabo.retroscreen.commands.utils.extractArguments
import com.ryctabo.retroscreen.commands.utils.extractCommand

class CommandString(value: String) {
    val execution: String = extractCommand(value)

    val args: List<String> = extractArguments(value)
        .let { it.subList(1, it.size) }
        .filter { it.isNotBlank() && it.isNotEmpty() }

    override fun toString(): String {
        return args.joinToString(separator = " ", prefix = "$execution ")
    }
}