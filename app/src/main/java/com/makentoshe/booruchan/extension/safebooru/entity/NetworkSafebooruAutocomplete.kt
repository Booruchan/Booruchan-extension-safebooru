package com.makentoshe.booruchan.extension.safebooru.entity

import com.makentoshe.booruchan.extension.base.entity.NetworkAutocomplete
import kotlinx.serialization.Serializable

typealias NetworkSafebooruAutocompletes = ArrayList<NetworkSafebooruAutocomplete>

// {"label":"hat (674552)","value":"hat"}
@Serializable
data class NetworkSafebooruAutocomplete(
    val label: String,
    override val value: String,
): NetworkAutocomplete {

    override val title: String
        get() = label.split(" ")[0]

    override val count: Int
        get() = label.split(" ")[1].run { substring(1, lastIndex) }.toInt()
}
