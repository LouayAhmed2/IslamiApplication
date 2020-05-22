package com.route.islami.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManger {

    companion object {
        private var retrofit: Retrofit? = null
        private fun getInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl("http://mp3quran.net/api/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit;
        }
       fun getWebService(): WebServices? {
           return getInstance()?.create(WebServices::class.java)
       }
    }

}