package com.makentoshe.booruchan.extension.safebooru

import com.makentoshe.booruchan.extension.base.Source
import com.makentoshe.booruchan.extension.base.entity.NetworkPost
import com.makentoshe.booruchan.extension.base.factory.AutocompleteSearchFactory
import com.makentoshe.booruchan.extension.base.factory.FetchPostsFactory
import com.makentoshe.booruchan.extension.base.factory.HealthCheckFactory
import com.makentoshe.booruchan.extension.base.parser.FetchPostsParser
import com.makentoshe.booruchan.extension.safebooru.entity.NetworkSafebooruPosts
import kotlinx.serialization.json.Json

class SafebooruSource : Source {

    override val id: String
        get() = "safebooru"

    override val host: String
        get() = "https://safebooru.org"

    override val title: String
        get() = "Safebooru"

    override val healthCheckFactory: HealthCheckFactory
        get() = SafebooruHealthCheckFactory(
            host = host,
        )

    override val fetchPostsFactory: FetchPostsFactory
        get() = SafebooruFetchPostsFactory(
            host = host,
            fetchPostsParser = SafebooruFetchPostsParser(),
        )

    override val autocompleteSearchFactory: AutocompleteSearchFactory
        get() = SafebooruAutocompleteSearchFactory(
            host = host,
            autocompleteSearchParser = SafebooruAutocompleteSearchParser(),
        )

}
