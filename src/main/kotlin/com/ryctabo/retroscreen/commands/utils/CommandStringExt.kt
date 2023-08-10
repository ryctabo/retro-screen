package com.ryctabo.retroscreen.commands.utils

fun extractCommand(command: String) = command.split(" ")[0]

fun extractArguments(command: String) = command.split(" ")