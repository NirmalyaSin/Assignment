package com.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.assignment.databinding.ActivitySplashBinding
import com.assignment.ui.login.view.LoginActivity
import com.assignment.utils.Constants
import com.assignment.utils.NavUtil
import com.assignment.utils.SharedPrefUtils
import com.google.android.material.snackbar.Snackbar
import com.solooke.base.BaseActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun layoutRes(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            NavUtil.ForActivity.navTo(this@SplashActivity, LoginActivity::class.java, true, null)

          /*  if (SharedPrefUtils.getBooleanData(this@SplashActivity, Constants.USER_LOGGED_IN)) {
                Log.e(
                    "TAG",
                    "onCreate:Constants.USER_LOGGED_IN " + SharedPrefUtils.getBooleanData(
                        this@SplashActivity,
                        Constants.USER_LOGGED_IN
                    )
                )
                NavUtil.ForActivity.navTo(this@SplashActivity, HomeActivity::class.java, true, null)

            } else {
                Log.e(
                    "TAG",
                    "onCreate:Constants.USER_LOGGED_IN " + SharedPrefUtils.getBooleanData(
                        this@SplashActivity,
                        Constants.USER_LOGGED_IN
                    )
                )
                NavUtil.ForActivity.navTo(
                    this@SplashActivity,
                    WelcomeActivity::class.java,
                    true,
                    null
                )

            }*/
        }, 3000)

    }
  /*  fun showMessage(msg: String?) {
        val snackbar = Snackbar.make(binding!!.root, msg!!, Snackbar.LENGTH_LONG)
        snackbar.show()
    }*/

}