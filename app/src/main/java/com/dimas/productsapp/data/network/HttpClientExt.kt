package com.dimas.productsapp.data.network

import com.dimas.productsapp.domain.Result
import com.dimas.productsapp.domain.error.DataError
import kotlinx.coroutines.ensureActive
import retrofit2.Response
import java.net.SocketTimeoutException
import java.nio.channels.UnresolvedAddressException
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(
    execute: () -> Response<T>
): Result<T, DataError.Remote> {
    val response = try {
        execute()
    } catch (_: SocketTimeoutException) {
        return Result.Failure(DataError.Remote.REQUEST_TIMEOUT)
    } catch (_: UnresolvedAddressException) {
        return Result.Failure(DataError.Remote.NO_INTERNET)
    } catch (_: Exception) {
        coroutineContext.ensureActive()
        return Result.Failure(DataError.Remote.UNKNOWN)
    }

    return responseToResult(response)
}

inline fun <reified T> responseToResult(
    response: Response<T>
): Result<T, DataError.Remote> {
    return if (response.isSuccessful) {
        Result.Success(response.body()!!)
    } else when (response.raw().code) {
        408 -> Result.Failure(DataError.Remote.REQUEST_TIMEOUT)

        429 -> Result.Failure(DataError.Remote.TOO_MANY_REQUESTS)

        in 500..599 -> Result.Failure(DataError.Remote.SERVER)

        else -> Result.Failure(DataError.Remote.UNKNOWN)
    }
}