package com.a.luxurycar.common.utils

import android.content.Context
import android.graphics.Typeface

/**
 * Created by Sandeep on 6/29/2017.
 */

object TypeFaceUtil {

    fun setDefaultFont(context: Context, staticTypefaceFieldName: String, fontAssetName: String) {
        val regular = Typeface.createFromAsset(context.assets, fontAssetName)
        replaceFont(staticTypefaceFieldName, regular)
    }

    internal fun replaceFont(staticTypefaceFieldName: String, newTypeface: Typeface) {
        try {
            val staticField = Typeface::class.java
                    .getDeclaredField(staticTypefaceFieldName)
            staticField.isAccessible = true
            staticField.set(null, newTypeface)
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

    }

}