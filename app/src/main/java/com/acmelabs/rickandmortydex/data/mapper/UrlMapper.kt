package com.acmelabs.rickandmortydex.data.mapper

import android.net.Uri

fun urlToId(url: String?): Int? {
    return if (url.isNullOrBlank()) null else
        Uri.parse(url).lastPathSegment?.toInt()
            ?: throw Throwable("Url inválida")
}

fun urlsToId(urls: List<String>?): String {
    return urls
        ?.mapNotNull { Uri.parse(it).lastPathSegment }
        ?.toString() ?: throw Throwable("Url inválida")
}