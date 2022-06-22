package com.solooke.base

import android.app.Dialog
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<V : ViewDataBinding?> : AppCompatActivity() {
    @JvmField
    protected var binding: V? = null
    private var mLoadingDialog: Dialog? = null
    @LayoutRes
    protected abstract fun layoutRes(): Int
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Constants.publicContext = this
        binding = DataBindingUtil.setContentView(this, layoutRes())
//        mLoadingDialog = LoadingDialog(this)
    }

    fun showLoading() {
        if (mLoadingDialog != null) {
            if (!mLoadingDialog!!.isShowing) {
                mLoadingDialog!!.show()
            }
        }
    }

    fun hideLoading() {
        if (mLoadingDialog != null) {
            if (mLoadingDialog!!.isShowing) {
                mLoadingDialog!!.cancel()
            }
        }
    }
}