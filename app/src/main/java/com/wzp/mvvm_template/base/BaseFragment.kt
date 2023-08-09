package com.wzp.mvvm_template.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.wzp.mvvm_template.viewmodel.PublicViewModel

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    private val viewModelClass: Class<VM>? = null,
    private val usePublicViewModel: Boolean = false
) : Fragment() {
    private lateinit var _binding: VB
    protected val binding get() = _binding

    private val _viewModel by lazy {
        val viewModelProvider = ViewModelProvider(owner = this)
        viewModelClass?.let {
            viewModelProvider[it]
        }
    }
    protected val viewModel get() = _viewModel

    private val _publicViewModel: PublicViewModel? by lazy {
        if (usePublicViewModel) {
            ViewModelProvider(requireActivity())[PublicViewModel::class.java]
        } else {
            null
        }
    }
    protected val publicViewModel get() = _publicViewModel

    private var _bundle = Bundle()
    protected val bundle get() = _bundle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        _bundle = arguments ?: Bundle()
        fragmentInit()
        return _binding.root
    }

    abstract fun fragmentInit()

}