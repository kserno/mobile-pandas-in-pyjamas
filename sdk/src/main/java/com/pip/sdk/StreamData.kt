package com.pip.sdk

import com.pip.sdk.analyzers.StreamAnalyzer

/**
 *  Created by filipsollar on 29.4.18
 */
data class StreamData(
        var frequency: Long = 0L,
        var pathToFile: String? = null,
        var streamId: String? = null,
        var isRunning: Boolean = false,
        var analyzers: MutableList<StreamAnalyzer<*>> = ArrayList()
)