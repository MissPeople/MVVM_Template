package com.wzp.mvvm_template.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import com.wzp.mvvm_template.R

class PrivacyDialog(context:Context,bottomListen: BottomListen) : Dialog(context) {
    interface BottomListen{
        fun click(mode:Int)
    }

    init {
        setContentView(R.layout.dialog_privacy)
        window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        window?.setGravity(Gravity.CENTER)
        window?.setBackgroundDrawableResource(R.drawable.around_a)
        val allowBtn=findViewById<TextView>(R.id.allow)
        val refuseBtn=findViewById<TextView>(R.id.refuse)
        allowBtn.setOnClickListener {
            bottomListen.click(1)
            dismiss()
        }
        refuseBtn.setOnClickListener {
            bottomListen.click(0)
        }
    }

}