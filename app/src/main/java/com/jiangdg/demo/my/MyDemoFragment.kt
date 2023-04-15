package com.jiangdg.demo.my

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jiangdg.ausbc.MultiCameraClient
import com.jiangdg.ausbc.base.CameraFragment
import com.jiangdg.ausbc.callback.ICameraStateCallBack
import com.jiangdg.ausbc.widget.AspectRatioTextureView
import com.jiangdg.ausbc.widget.IAspectRatio
import com.jiangdg.demo.databinding.ActivityDemoBinding

class MyDemoFragment: CameraFragment() {
    private var activityDemoBinding: ActivityDemoBinding? = null

    override fun getRootView(inflater: LayoutInflater, container: ViewGroup?): View? {
        activityDemoBinding = ActivityDemoBinding.inflate(layoutInflater, container, false)
        return activityDemoBinding?.root
    }

    override fun getCameraView(): IAspectRatio {
        return AspectRatioTextureView(requireContext())
    }

    override fun getCameraViewContainer(): ViewGroup? {
        return activityDemoBinding?.cameraViewContainer
    }

    override fun onCameraState(self: MultiCameraClient.ICamera, code: ICameraStateCallBack.State, msg: String?) {
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