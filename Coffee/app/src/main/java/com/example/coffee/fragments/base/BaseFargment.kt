package com.example.coffee.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding?> : Fragment() {
    var binding: B? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = getViewBinding(inflater, container)
        setUp()
        return binding!!.root
    }

    abstract fun getViewBinding(inflater: LayoutInflater?, container: ViewGroup?): B
    abstract fun setUp()
}