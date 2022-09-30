package com.example.retrofitmvvm.data

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Auth", "12358")
            .addHeader("Token", "Mpkafa5568")
            .build()

        return chain.proceed(request)
    }
}