package xyz.teamgravity.predictivebackgesture

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import xyz.teamgravity.predictivebackgesture.databinding.ActivityMainBinding

class Main : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button()
        updateUI()
    }

    private fun button() {
        onBack()
    }

    private fun updateUI() {
        updateCount()
    }

    private fun updateCount() {
        binding.countT.text = getString(R.string.your_press_count, count.toString())
    }

    private fun onBack() {
        onBackPressedDispatcher.addCallback(onBack)
        binding.backB.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private val onBack = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (count > 0) {
                count--
                updateCount()
            } else {
                isEnabled = false
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}