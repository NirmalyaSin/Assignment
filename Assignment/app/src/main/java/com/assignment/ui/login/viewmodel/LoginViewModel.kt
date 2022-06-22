package com.assignment.ui.login.viewmodel

import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var isCredsGiven = MutableLiveData<Boolean?>()
    var allOk = MutableLiveData<Boolean?>()


    fun login(v: View, e1: EditText, e2: EditText) {
        e1.clearFocus()
        e2.clearFocus()

       isAllOk()


    }

    fun isAllOk() {

        if (!email.value.equals("") && !password.value.equals("")) {
            allOk.setValue(true)
            isCredsGiven.value = true
        } else {
            allOk.setValue(false)
            isCredsGiven.value = false
        }
    }

}