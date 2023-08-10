package com.ryctabo.retroscreen.model

typealias Position = Pair<Int, Int>

class Figure(
    val symbol: String,
    var positions: Set<Position>
)