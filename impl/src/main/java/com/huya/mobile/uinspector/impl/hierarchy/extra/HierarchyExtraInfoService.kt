package com.huya.mobile.uinspector.impl.hierarchy.extra

import android.app.Activity
import android.text.SpannableStringBuilder
import android.view.View
import com.huya.mobile.uinspector.hierarchy.AndroidView
import com.huya.mobile.uinspector.hierarchy.Layer

/**
 * Java SPI: add custom extra info into [SpannableStringBuilder]
 *
 * @author YvesCheung
 * 2021/1/6
 */
interface HierarchyExtraInfoService {

    fun create(activity: Activity, targetView: View): Set<HierarchyExtraInfo>

    fun create(activity: Activity, targetLayer: Layer): Set<HierarchyExtraInfo> {
        if (targetLayer is AndroidView) {
            return create(activity, targetLayer.view)
        }
        return emptySet()
    }
}