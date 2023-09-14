package com.makentoshe.booruchan.extension.safebooru

import com.makentoshe.booruchan.extension.base.entity.NetworkAutocomplete
import com.makentoshe.booruchan.extension.base.factory.AutocompleteSearchFactory
import com.makentoshe.booruchan.extension.base.network.NetworkMethod
import com.makentoshe.booruchan.extension.base.network.NetworkRequest
import com.makentoshe.booruchan.extension.base.parser.AutocompleteSearchParser
import com.makentoshe.booruchan.extension.safebooru.entity.NetworkSafebooruAutocompletes
import kotlinx.serialization.json.Json

class SafebooruAutocompleteSearchFactory(
    private val host: String,
    autocompleteSearchParser: AutocompleteSearchParser,
) : AutocompleteSearchFactory(autocompleteSearchParser) {
    override fun buildRequest(request: AutocompleteSearchRequest): NetworkRequest {
        return NetworkRequest(
            method = NetworkMethod.Get,
            url = host.plus("/autocomplete.php"),
            parameters = mapOf(
                "q" to request.autocomplete,
            )
        )
    }
}

class SafebooruAutocompleteSearchParser : AutocompleteSearchParser {
    override fun parse(string: String): List<NetworkAutocomplete> {
        return Json.decodeFromString<NetworkSafebooruAutocompletes>(string)
    }
}
