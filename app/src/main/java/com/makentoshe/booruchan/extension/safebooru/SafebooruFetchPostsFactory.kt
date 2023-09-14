package com.makentoshe.booruchan.extension.safebooru

import com.makentoshe.booruchan.extension.base.entity.NetworkPost
import com.makentoshe.booruchan.extension.base.factory.FetchPostsFactory
import com.makentoshe.booruchan.extension.base.network.NetworkMethod
import com.makentoshe.booruchan.extension.base.network.NetworkRequest
import com.makentoshe.booruchan.extension.base.parser.FetchPostsParser
import com.makentoshe.booruchan.extension.safebooru.entity.NetworkSafebooruPosts
import kotlinx.serialization.json.Json

class SafebooruFetchPostsFactory(
    private val host: String,
    fetchPostsParser: FetchPostsParser,
) : FetchPostsFactory(fetchPostsParser) {
    override fun buildRequest(request: FetchPostsRequest): NetworkRequest {
        return NetworkRequest(
            method = NetworkMethod.Get,
            url = host,
            parameters = mapOf(
                "page" to "dapi",
                "s" to "post",
                "q" to "index",
                "json" to "1", // force responding with json instead of xml

                "limit" to request.count.toString(),
                "pid" to request.page.toString(),
                "tags" to request.tags,
            )
        )
    }
}

class SafebooruFetchPostsParser : FetchPostsParser {
    override fun parse(string: String): List<NetworkPost> {
        return Json.decodeFromString<NetworkSafebooruPosts>(string)
    }
}
