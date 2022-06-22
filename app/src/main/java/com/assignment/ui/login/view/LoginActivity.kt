package com.assignment.ui.login.view

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.assignment.R
import com.assignment.databinding.ActivityLoginBinding
import com.assignment.ui.home.HomeActivity
import com.assignment.ui.login.viewmodel.LoginViewModel
import com.assignment.ui.signup.SignupActivity
import com.assignment.utils.NavUtil
import com.solooke.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private var viewModel: LoginViewModel? = null

    override fun layoutRes(): Int {
        return R.layout.activity_login
    }

    var isPswdVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding!!.vm = viewModel
        binding!!.lifecycleOwner = this


       viewModel!!.isCredsGiven.observe(this,{

           if(it!!){
               NavUtil.ForActivity.navTo(this@LoginActivity, HomeActivity::class.java, false, null)

           }else{
               Toast.makeText(this,"Please enter credentials!",Toast.LENGTH_SHORT).show()
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

                           NavUtil.ForActivity.navTo(this@LoginActivity, SignupActivity::class.java, false, null)

        }

      /*  binding!!.btSignin.setOnClickListener {

            if(!viewModel!!.password.value.equals("") && !viewModel!!.email.value.equals("")){
                //               NavUtil.ForActivity.navTo(this@LoginActivity, HomeActivity::class.java, true, null)

            }else{
                Toast.makeText(this,"Please enter credentials!",Toast.LENGTH_SHORT).show()

            }
        }*/
    }

    override fun onResume() {
        super.onResume()
//        viewModel!!.isCredsGiven.value = false
    }




}