package com.fanhl.hellohilt

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MailViewModel @Inject constructor() : ViewModel() {
    private lateinit var _hi: String
    val hi: String
        get() {
            if (!::_hi.isInitialized) {
                _hi = "Hi ${System.currentTimeMillis()}"
            }
            return _hi
        }
}