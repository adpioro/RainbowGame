package com.adpioro.rainbowgame

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val red = Color("RED", 1.0)
    val orange = Color("ORANGE", 0.5)
    val yellow = Color("YELLOW", 0.25)
    val green = Color("GREEN", 0.1)
    val blue = Color("BLUE", 0.05)
    val violet = Color("VIOLET", 0.025)
}