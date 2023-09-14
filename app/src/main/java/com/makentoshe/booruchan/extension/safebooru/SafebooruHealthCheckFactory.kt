package com.makentoshe.booruchan.extension.safebooru

import com.makentoshe.booruchan.extension.base.factory.HealthCheckFactory
import com.makentoshe.booruchan.extension.base.network.NetworkMethod
import com.makentoshe.booruchan.extension.base.network.NetworkRequest

class SafebooruHealthCheckFactory(
    private val host: String,
) : HealthCheckFactory() {
    override fun buildRequest(): NetworkRequest {
        return NetworkRequest(method = NetworkMethod.Head, url = host)
    }
}