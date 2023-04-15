package com.jiangdg.demo.my

import com.jiangdg.ausbc.base.CameraActivity
import android.view.LayoutInflater
import android.view.View
import com.jiangdg.ausbc.widget.IAspectRatio
import com.jiangdg.ausbc.widget.AspectRatioTextureView
import android.view.ViewGroup
import com.jiangdg.ausbc.MultiCameraClient.ICamera
import com.jiangdg.ausbc.callback.ICameraStateCallBack
import com.jiangdg.demo.databinding.ActivityDemoBinding

class DemoActivity : CameraActivity() {
    private var activityDemoBinding: ActivityDemoBinding? = null

    override fun getRootView(layoutInflater: LayoutInflater): View? {
        activityDemoBinding = ActivityDemoBinding.inflate(layoutInflater, null, false)
        return activityDemoBinding?.root
    }

    override fun getCameraView(): IAspectRatio {
        return AspectRatioTextureView(this)
    }

    override fun getCameraViewContainer(): ViewGroup? {
        return activityDemoBinding?.cameraViewContainer
    }

    override fun onCameraState(self: ICamera, code: ICameraStateCallBack.State, msg: String?) {
        when (code) {
            ICameraStateCallBack.State.OPENED -> {
                activityDemoBinding?.uvcLogoIv?.visibility = View.GONE
            }
            ICameraStateCallBack.State.CLOSED -> {
                activityDemoBinding?.uvcLogoIv?.visibility = View.VISIBLE
            }
            ICameraStateCallBack.State.ERROR -> {
                activityDemoBinding?.uvcLogoIv?.visibility = View.VISIBLE
            }
        }
    }
}