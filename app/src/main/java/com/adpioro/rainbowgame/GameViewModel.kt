package com.adpioro.rainbowgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    val red = Color("RED", 1.0, true)
    val orange = Color("ORANGE", 0.5)
    val yellow = Color("YELLOW", 0.25)
    val green = Color("GREEN", 0.1)
    val blue = Color("BLUE", 0.05)
    val violet = Color("VIOLET", 0.025)

    init {
        viewModelScope.launch {
            while (red.idle) {
                red.addIdle()
            }
        }
        viewModelScope.launch {
            while (orange.idle) {
                orange.addIdle()
            }
        }
        viewModelScope.launch {
            while (yellow.idle) {
                yellow.addIdle()
            }
        }
        viewModelScope.launch {
            while (green.idle) {
                green.addIdle()
            }
        }
        viewModelScope.launch {
            while (blue.idle) {
                blue.addIdle()
            }
        }
        viewModelScope.launch {
            while (violet.idle) {
                violet.addIdle()
            }
        }
    }
}