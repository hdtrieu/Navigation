package com.hdtrieu.navigator.interfaces

import org.jetbrains.annotations.NotNull

/**
 * input params
 */
interface NavigateParams {
    @NotNull fun getLink(): String //must include
    fun getParams(): Map<String, Any>? //option
}