package com.stroke.stroke_android.commonKotlin

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageWithGlideWithUri(uri: Uri?){
    uri?.let {
        Glide.with(this).load(it).circleCrop().into(this)
    }
}