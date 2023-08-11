package com.wzp.mvvm_template.presentation.mainNav.mine

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.wzp.mvvm_template.presentation.base.BaseFragment
import com.wzp.mvvm_template.databinding.FragmentMineBinding
import com.wzp.mvvm_template.util.dialog.PrivacyDialog

class MineFragment : BaseFragment<FragmentMineBinding, ViewModel>(
    FragmentMineBinding::inflate
) {
    override fun fragmentInit() {
        binding.tvMine.setOnClickListener {
            PrivacyDialog(requireContext(), object : PrivacyDialog.BottomListen {
                override fun click(mode: Int) {
                    Toast.makeText(requireContext(), mode.toString(), Toast.LENGTH_SHORT).show()
                }
            }).show()
        }
    }
}