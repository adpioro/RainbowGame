package com.adpioro.rainbowgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.adpioro.rainbowgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = GameViewModel()
        binding.gameViewModel = viewModel

        // red color handling
        binding.redButton.setOnClickListener {
            viewModel.red.addManually()
        }
        val redPointObserver = Observer<Double> {
            binding.redPoints.text = viewModel.red.toString()
        }
        viewModel.red.points.observe(this, redPointObserver)
        val redIdlerObserver = Observer<Int> {
            binding.redIdle.text =
                String.format(getString(R.string.idle), viewModel.red.idler.value)
        }
        viewModel.red.idler.observe(this, redIdlerObserver)

        // orange color handling
        binding.orangeButton.isEnabled = viewModel.orange.idle
        binding.orangeButton.setOnClickListener {
            viewModel.orange.addManually()
        }
        val orangePointObserver = Observer<Double> {
            binding.orangePoints.text = viewModel.orange.toString()
        }
        viewModel.orange.points.observe(this, orangePointObserver)
        val orangeIdleObserver = Observer<Int> {
            binding.orangeIdle.text =
                String.format(getString(R.string.idle), viewModel.orange.idler.value)
        }
        viewModel.orange.idler.observe(this, orangeIdleObserver)

        // yellow color handling
        binding.yellowButton.isEnabled = viewModel.yellow.idle
        binding.yellowButton.setOnClickListener {
            viewModel.yellow.addManually()
        }
        val yellowPointObserver = Observer<Double> {
            binding.yellowPoints.text = viewModel.yellow.toString()
        }
        viewModel.yellow.points.observe(this, yellowPointObserver)
        val yellowIdleObserver = Observer<Int> {
            binding.yellowIdle.text =
                String.format(getString(R.string.idle), viewModel.yellow.idler.value)
        }
        viewModel.yellow.idler.observe(this, yellowIdleObserver)

        // green color handling
        binding.greenButton.isEnabled = viewModel.green.idle
        binding.greenButton.setOnClickListener {
            viewModel.green.addManually()
        }
        val greenPointObserver = Observer<Double> {
            binding.greenPoints.text = viewModel.green.toString()
        }
        viewModel.green.points.observe(this, greenPointObserver)
        val greenIdleObserver = Observer<Int> {
            binding.greenIdle.text =
                String.format(getString(R.string.idle), viewModel.green.idler.value)
        }
        viewModel.green.idler.observe(this, greenIdleObserver)

        // blue color handling
        binding.blueButton.isEnabled = viewModel.blue.idle
        binding.blueButton.setOnClickListener {
            viewModel.blue.addManually()
        }
        val bluePointObserver = Observer<Double> {
            binding.bluePoints.text = viewModel.blue.toString()
        }
        viewModel.blue.points.observe(this, bluePointObserver)
        val blueIdleObserver = Observer<Int> {
            binding.blueIdle.text =
                String.format(getString(R.string.idle), viewModel.blue.idler.value)
        }
        viewModel.blue.idler.observe(this, blueIdleObserver)

        // violet color handling
        binding.violetButton.isEnabled = viewModel.violet.idle
        binding.violetButton.setOnClickListener {
            viewModel.violet.addManually()
        }
        val violetPointObserver = Observer<Double> {
            binding.violetPoints.text = viewModel.violet.toString()
        }
        viewModel.violet.points.observe(this, violetPointObserver)
        val violetIdleObserver = Observer<Int> {
            binding.violetIdle.text =
                String.format(getString(R.string.idle), viewModel.violet.idler.value)
        }
        viewModel.violet.idler.observe(this, violetIdleObserver)
    }
}