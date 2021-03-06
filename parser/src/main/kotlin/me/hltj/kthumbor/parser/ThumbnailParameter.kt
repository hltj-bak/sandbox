package me.hltj.kthumbor.parser

import me.hltj.kthumbor.share.ThumbnailParameter

/**
 * parse a string ([this]) into [ThumbnailParameter] or `null` if failed
 */
internal fun String.toThumbnailParameter(): ThumbnailParameter? {
    val groups = paramRegex.matchEntire(this)?.groups ?: return null

    val width = groups["width"]?.value?.toIntOrNull() ?: 0
    val height = groups["height"]?.value?.toIntOrNull() ?: 0
    val enlargeable = groups["enlargeable"]?.value == "e"

    return if (width == 0 && height == 0) null else ThumbnailParameter(width, height, enlargeable)
}

private val paramRegex = Regex(
    """(?<width>[1-9][0-9]*)?(?:x(?<height>[1-9][0-9]*))?(?<enlargeable>e)?"""
)
