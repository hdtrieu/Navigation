package com.hdtrieu.navigator.interfaces

/**
 * Callback when processor accept process
 */
interface TkActionNavigateCallback {
    fun onCompleted(success: Boolean, bundle: Map<String, Any>?) //callback params if success
    fun onFailure(error: String)
}