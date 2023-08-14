package com.wzp.mvvm_template.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.wzp.mvvm_template.presentation.app.App
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PublicViewModel @Inject constructor() : ViewModel()