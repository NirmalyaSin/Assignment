package com.assignment.ui.signup

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.assignment.R
import com.assignment.databinding.ActivityLoginBinding
import com.assignment.databinding.ActivitySignupBinding
import com.assignment.ui.home.HomeActivity
import com.assignment.ui.login.view.LoginActivity
import com.assignment.ui.login.viewmodel.LoginViewModel
import com.assignment.ui.signup.viewmodel.SignupViewModel
import com.assignment.utils.NavUtil
import com.solooke.base.BaseActivity

class SignupActivity : BaseActivity<ActivitySignupBinding>(){

    private var viewModel: SignupViewModel? = null

    var isPswdVisible = false

    override fun layoutRes(): Int {
        return R.layout.activity_signup
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SignupViewModel::class.java]
        binding!!.vm = viewModel
        binding!!.lifecycleOwner = this
        viewModel!!.isCredsGiven.observe(this,{

            if(it!!){
               NavUtil.ForActivity.navTo(this@SignupActivity, HomeActivity::class.java, false, null)

            }else{
                Toast.makeText(this,"Please enter credentials!", Toast.LENGTH_SHORT).show()
            }
        })

        binding!!.passwordEye.setOnClickListener {

            if(isPswdVisible){
                binding!!.edtPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                isPswdVisible = false
                binding!!.passwordEye.setImageResource(R.drawable.eye)
                Log.e("TAG", "onCreate: password vidiblr false " )
            } else {
                binding!!.edtPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                isPswdVisible = true
                Log.e("TAG", "onCreate: password vidiblr true " )
                /*    cross*/
                binding!!.passwordEye.setImageResource(R.drawable.eyeclose)
            }
            binding!!.edtPassword.setSelection(binding!!.edtPassword.length())
        }

        binding!!.llSignUp.setOnClickListener {

            NavUtil.ForActivity.navTo(this@SignupActivity, LoginActivity::class.java, false, null)

        }

    }
}