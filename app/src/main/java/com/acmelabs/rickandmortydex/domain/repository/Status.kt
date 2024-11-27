package com.acmelabs.rickandmortydex.domain.repository

open class Status<T>(val body: T? = null) {
    class Ok<T>(res: T?) : Status<T>(res)
    class Redirect<T> : Status<T>()
    class ServerError<T> : Status<T>()
    class ClientError<T> : Status<T>()
    class Unknown<T> : Status<T>()
}