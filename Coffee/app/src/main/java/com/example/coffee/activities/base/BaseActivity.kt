package com.example.coffee.activities.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<B: ViewBinding>(
    val bindingFactory: (LayoutInflater) -> B
): AppCompatActivity() {
    private var _binding: B? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun setUp()

    fun makeToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}