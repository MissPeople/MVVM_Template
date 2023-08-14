package com.wzp.mvvm_template.presentation.mainNav.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.wzp.mvvm_template.databinding.FragmentMineBinding
import com.wzp.mvvm_template.util.dialog.PrivacyDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MineFragment : Fragment() {
    private lateinit var binding : FragmentMineBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMineBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMine.setOnClickListener {
            PrivacyDialog(requireContext(), object : PrivacyDialog.BottomListen {
                override fun click(mode: Int) {
                    Toast.makeText(requireContext(), mode.toString(), Toast.LENGTH_SHORT).show()
                }
            }).show()
        }
    }
}