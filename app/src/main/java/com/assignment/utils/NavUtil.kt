package com.assignment.utils

import android.widget.TextView
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.widget.TimePicker
import android.app.Activity
import android.content.Intent
import android.app.ActivityOptions
import android.app.TaskStackBuilder
import android.content.Context
import android.os.Bundle
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.content.SharedPreferences
import android.text.TextUtils
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

object NavUtil {
    fun getIntent(context: Context?, c: Class<out Activity?>?): Intent {
        return Intent(context, c)
    }

    object ForActivity {
        fun navTo(activity: Activity, c: Class<out Activity?>,
                  activityOptions: ActivityOptions?,
                  options: Bundle?,
                  requestCode: Int?,
                  noHistory: Boolean) {
            var activityOptions = activityOptions
            val intent = getIntent(activity, c)
            if (noHistory) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            if (options != null) intent.putExtras(options)
            if (activityOptions == null) activityOptions = ActivityOptions.makeCustomAnimation(activity, android.R.anim.fade_in,
                    android.R.anim.fade_out)
            if (requestCode != null) activity.startActivityForResult(intent, requestCode, activityOptions!!.toBundle()) else activity.startActivity(intent, activityOptions!!.toBundle())
        }

        fun navTo(activity: Activity, c: Class<out Activity?>, noHistory: Boolean, options: Bundle?) {
            navTo(activity, c, null, options, null, noHistory)
        }

        fun navToWithTaskStack(activity: Activity, c: Class<out Activity?>, options: Bundle?, stack: Class<out Activity?>) {
            val taskStackBuilder = TaskStackBuilder.create(activity)
            taskStackBuilder.addParentStack(stack)
            taskStackBuilder.addNextIntent(Intent(activity, stack))
            val intent = Intent(activity, c)
            if (options != null) intent.putExtras(options)
            taskStackBuilder.addNextIntent(intent)
            val activityOptions = ActivityOptions.makeCustomAnimation(activity, android.R.anim.fade_in,
                    android.R.anim.fade_out)
            activity.startActivities(taskStackBuilder.intents, activityOptions.toBundle())
        }

        fun navToForResult(activity: Activity, c: Class<out Activity?>, requestCode: Int, options: Bundle?) {
            navTo(activity, c, null, options, requestCode, false)
        }

        fun navToWithOptions(activity: Activity, c: Class<out Activity?>, activityOptions: ActivityOptions, options: Bundle?) {
            navTo(activity, c, activityOptions, options, null, false)
        }
    }

    object ForFragment {
        fun navTo(fragment: Fragment, c: Class<out Activity?>,
                  activityOptions: ActivityOptions?,
                  options: Bundle?,
                  requestCode: Int?,
                  noHistory: Boolean) {
            var activityOptions = activityOptions
            val intent = getIntent(fragment.context, c)
            if (noHistory) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            if (options != null) intent.putExtras(options)
            if (activityOptions == null) activityOptions = ActivityOptions.makeCustomAnimation(fragment.activity, android.R.anim.fade_in,
                    android.R.anim.fade_out)
            if (requestCode != null) fragment.startActivityForResult(intent, requestCode, activityOptions!!.toBundle()) else fragment.startActivity(intent, activityOptions!!.toBundle())
        }

        fun navTo(fragment: Fragment, c: Class<out Activity?>, noHistory: Boolean, options: Bundle?) {
            navTo(fragment, c, null, options, null, noHistory)
        }

        fun navToWithTaskStack(fragment: Fragment, c: Class<out Activity?>, options: Bundle?, vararg stack: Class<out Activity?>) {
            if (stack.size == 0) return
            val taskStackBuilder = TaskStackBuilder.create(fragment.requireContext())
            taskStackBuilder.addParentStack(stack[0])
            for (task in stack) taskStackBuilder.addNextIntent(Intent(fragment.context, task))
            val intent = Intent(fragment.context, c)
            if (options != null) intent.putExtras(options)
            taskStackBuilder.addNextIntent(intent)
            val activityOptions = ActivityOptions.makeCustomAnimation(fragment.activity, android.R.anim.fade_in,
                    android.R.anim.fade_out)
            fragment.requireActivity().startActivities(taskStackBuilder.intents, activityOptions.toBundle())
        }

        fun navToForResult(fragment: Fragment, c: Class<out Activity?>, requestCode: Int, options: Bundle?) {
            navTo(fragment, c, null, options, requestCode, false)
        }

        fun navToWithOptions(fragment: Fragment, c: Class<out Activity?>, activityOptions: ActivityOptions, options: Bundle?) {
            navTo(fragment, c, activityOptions, options, null, false)
        }
    }
}