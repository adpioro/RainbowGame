package com.adpioro.rainbowgame

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.adpioro.rainbowgame.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

const val CLICKS_TO_UNLOCK_IDLE = 25.0
const val POINTS_TO_UNLOCK_NEXT = 50.0
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = GameViewModel()
        binding.gameViewModel = viewModel

        // red is a start color, so it's getting idle on start

        // points observers: launch coroutine with first idle worker, than activate next color
        // red
        binding.redButton.setOnClickListener {
            viewModel.red.addManually()
        }
        val redPointObserver = Observer<Double> {
            binding.redPoints.text = viewModel.red.toString()
            if (it == CLICKS_TO_UNLOCK_IDLE) {
                viewModel.red.idle.value = true
                viewModel.viewModelScope.launch {
                    while (true) {
                        viewModel.red.addIdle()
                    }
                }
            }
            if (!binding.orangePoints.isVisible && it > POINTS_TO_UNLOCK_NEXT) {
                binding.orangePoints.isVisible = true
                binding.orangeButton.isVisible = true
                binding.orangeButton.isEnabled = true
                binding.orangeIdle.isVisible = true
                Toast.makeText(this, "New color available", Toast.LENGTH_LONG)
                    .show()
            }
        }
        viewModel.red.points.observe(this, redPointObserver)

        // orange
        binding.orangeButton.isEnabled = viewModel.orange.idle.value!!
        binding.orangeButton.setOnClickListener {
            viewModel.orange.addManually()
        }
        val orangePointObserver = Observer<Double> {
            binding.orangePoints.text = viewModel.orange.toString()
            if (it == CLICKS_TO_UNLOCK_IDLE) {
                viewModel.orange.idle.value = true
                viewModel.viewModelScope.launch {
                    while (true) {
                        viewModel.orange.addIdle()
                    }
                }
            }
            if (!binding.yellowPoints.isVisible && it > POINTS_TO_UNLOCK_NEXT / viewModel.yellow.modifier) {
                binding.yellowPoints.isVisible = true
                binding.yellowButton.isVisible = true
                binding.yellowButton.isEnabled = true
                binding.yellowIdle.isVisible = true
                Toast.makeText(this, "New color available", Toast.LENGTH_LONG)
                    .show()
            }
        }
        viewModel.orange.points.observe(this, orangePointObserver)

        // yellow
        binding.yellowButton.isEnabled = viewModel.yellow.idle.value!!
        binding.yellowButton.setOnClickListener {
            viewModel.yellow.addManually()
        }
        val yellowPointObserver = Observer<Double> {
            binding.yellowPoints.text = viewModel.yellow.toString()
            if (it == CLICKS_TO_UNLOCK_IDLE) {
                viewModel.yellow.idle.value = true
                viewModel.viewModelScope.launch {
                    while (true) {
                        viewModel.yellow.addIdle()
                    }
                }
            }
            if (!binding.greenPoints.isVisible && it > POINTS_TO_UNLOCK_NEXT / viewModel.green.modifier) {
                binding.greenPoints.isVisible = true
                binding.greenButton.isVisible = true
                binding.greenButton.isEnabled = true
                binding.greenIdle.isVisible = true
                Toast.makeText(this, "New color available", Toast.LENGTH_LONG)
                    .show()
            }
        }
        viewModel.yellow.points.observe(this, yellowPointObserver)

        // green
        binding.greenButton.isEnabled = viewModel.green.idle.value!!
        binding.greenButton.setOnClickListener {
            viewModel.green.addManually()
        }
        val greenPointObserver = Observer<Double> {
            binding.greenPoints.text = viewModel.green.toString()
            if (it == CLICKS_TO_UNLOCK_IDLE) {
                viewModel.green.idle.value = true
                viewModel.viewModelScope.launch {
                    while (true) {
                        viewModel.green.addIdle()
                    }
                }
            }
            if (!binding.bluePoints.isVisible && it > POINTS_TO_UNLOCK_NEXT / viewModel.blue.modifier) {
                binding.bluePoints.isVisible = true
                binding.blueButton.isVisible = true
                binding.blueButton.isEnabled = true
                binding.blueIdle.isVisible = true
                Toast.makeText(this, "New color available", Toast.LENGTH_LONG)
                    .show()
            }
        }
        viewModel.green.points.observe(this, greenPointObserver)

        // blue
        binding.blueButton.isEnabled = viewModel.blue.idle.value!!
        binding.blueButton.setOnClickListener {
            viewModel.blue.addManually()
        }
        val bluePointObserver = Observer<Double> {
            binding.bluePoints.text = viewModel.blue.toString()
            if (it == CLICKS_TO_UNLOCK_IDLE) {
                viewModel.blue.idle.value = true
                viewModel.viewModelScope.launch {
                    while (true) {
                        viewModel.blue.addIdle()
                    }
                }
            }
            if (!binding.violetPoints.isVisible && it > POINTS_TO_UNLOCK_NEXT / viewModel.violet.modifier) {
                binding.violetPoints.isVisible = true
                binding.violetButton.isVisible = true
                binding.violetButton.isEnabled = true
                binding.violetIdle.isVisible = true
                Toast.makeText(this, "New color available", Toast.LENGTH_LONG)
                    .show()
            }
        }
        viewModel.blue.points.observe(this, bluePointObserver)

        // violet
        binding.violetButton.isEnabled = viewModel.violet.idle.value!!
        binding.violetButton.setOnClickListener {
            viewModel.violet.addManually()
        }
        val violetPointObserver = Observer<Double> {
            binding.violetPoints.text = viewModel.violet.toString()
            if (it == CLICKS_TO_UNLOCK_IDLE) {
                viewModel.violet.idle.value = true
                viewModel.viewModelScope.launch {
                    while (true) {
                        viewModel.violet.addIdle()
                    }
                }
                Toast.makeText(this, "Rainbow is unstoppable!", Toast.LENGTH_LONG)
                    .show()
            }
        }
        viewModel.violet.points.observe(this, violetPointObserver)

        // idle handling
        // red
        val redIdlerObserver = Observer<Int> {
            binding.redIdle.text =
                String.format(getString(R.string.idle), viewModel.red.idler.value)
        }
        viewModel.red.idler.observe(this, redIdlerObserver)

        // orange
        val orangeIdleObserver = Observer<Int> {
            binding.orangeIdle.text =
                String.format(getString(R.string.idle), viewModel.orange.idler.value)
        }
        viewModel.orange.idler.observe(this, orangeIdleObserver)

        // yellow
        val yellowIdleObserver = Observer<Int> {
            binding.yellowIdle.text =
                String.format(getString(R.string.idle), viewModel.yellow.idler.value)
        }
        viewModel.yellow.idler.observe(this, yellowIdleObserver)

        // green
        val greenIdleObserver = Observer<Int> {
            binding.greenIdle.text =
                String.format(getString(R.string.idle), viewModel.green.idler.value)
        }
        viewModel.green.idler.observe(this, greenIdleObserver)

        // blue
        val blueIdleObserver = Observer<Int> {
            binding.blueIdle.text =
                String.format(getString(R.string.idle), viewModel.blue.idler.value)
        }
        viewModel.blue.idler.observe(this, blueIdleObserver)

        // violet
        val violetIdleObserver = Observer<Int> {
            binding.violetIdle.text =
                String.format(getString(R.string.idle), viewModel.violet.idler.value)
        }
        viewModel.violet.idler.observe(this, violetIdleObserver)
    }
}