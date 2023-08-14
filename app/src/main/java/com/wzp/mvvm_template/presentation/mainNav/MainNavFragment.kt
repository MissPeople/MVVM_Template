package com.wzp.mvvm_template.presentation.mainNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.wzp.mvvm_template.R
import com.wzp.mvvm_template.databinding.FragmentMainNavBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainNavFragment : Fragment() {
    private lateinit var binding : FragmentMainNavBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainNavBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (childFragmentManager.findFragmentById(R.id.content_container) as NavHostFragment).apply {
            binding.bottomNav.setupWithNavController(this.navController)
        }
    }
}