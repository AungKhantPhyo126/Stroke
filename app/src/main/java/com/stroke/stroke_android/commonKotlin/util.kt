package com.stroke.stroke_android.commonKotlin

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okhttp3.ResponseBody
import org.json.JSONObject
import java.util.ArrayList

fun getErrorMessageFromHashMap(errorMessage:Map<String,List<String>>):String{
    val list: List<Map.Entry<String, Any>> =
        ArrayList<Map.Entry<String, Any>>(errorMessage.entries)
    val (key, value) = list[0]
    return value.toString()
}

inline fun ResponseBody.parseError(): Map<String,List<String>>?{
    val moshi = Moshi.Builder().build()
    val type = Types.newParameterizedType(Map::class.java, String::class.java, List::class.javaObjectType)
    val adapter = moshi.adapter<Map<String, List<String>>>(type)
    var jsonObject = JSONObject(this.string())

    try {
        return adapter.fromJson(jsonObject.getJSONObject("response").getJSONObject("message").toString())
    }catch (e: JsonDataException) {
        e.printStackTrace()
    }
    return null
}