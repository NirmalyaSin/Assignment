package com.assignment.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assignment.R
import com.assignment.databinding.ActivityHomeBinding
import com.solooke.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun layoutRes(): Int {
        return R.layout.activity_home
    }
}