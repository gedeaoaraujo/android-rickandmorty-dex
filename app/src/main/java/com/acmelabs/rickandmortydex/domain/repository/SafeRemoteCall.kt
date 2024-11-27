package com.acmelabs.rickandmortydex.domain.repository

import kotlinx.coroutines.ensureActive
import retrofit2.Response
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.nio.channels.UnresolvedAddressException
import kotlin.coroutines.coroutineContext

data class Return<T>(
    val body: T? = null,
    val code: Int
)

suspend fun <O>safeCall(remoteCall: suspend () -> Response<O>): Return<O> {
    val result = try {
        val result = remoteCall()
        Return(result.body(), result.code())
    } catch (e: SocketTimeoutException) {
        Return(code = HttpURLConnection.HTTP_CLIENT_TIMEOUT)
    } catch (e: UnresolvedAddressException) {
        Return(code = HttpURLConnection.HTTP_NOT_FOUND)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        Return(code = HttpURLConnection.HTTP_BAD_REQUEST)
    }
    return Return(result.body, result.code)
}

fun <T> wrapHttpStatus(body: T?, code: Int): Status<T> {
    return when (code) {
        in 200..299 -> Status.Ok(body)
        in 300..399 -> Status.Redirect()
        in 400..499 -> Status.ClientError()
        in 500..599 -> Status.ServerError()
        else -> Status.Unknown()
    }
}