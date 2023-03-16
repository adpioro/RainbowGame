package com.adpioro.rainbowgame

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class Color(private val name: String, val modifier: Double) {
    val points: MutableLiveData<Double> = MutableLiveData<Double>(0.0)
    private var clicks = 0
    var idle: MutableLiveData<Boolean> = MutableLiveData(false)
    var idler: MutableLiveData<Int> = MutableLiveData<Int>(0)

    override fun toString(): String {
        return "$name points: ${points.value!!.toInt()}"
    }

    fun addManually() {
        points.value = points.value!!.plus(1)
        clicks++
        idler.postValue(clicks / 25)
    }

    suspend fun addIdle() {
        delay(1000 / (idler.value!!.toLong() + 1))
        points.value = points.value!!.plus(modifier * idler.value!!)
    }
}