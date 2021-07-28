package ru.artkolest.spidertestproject.di.modules

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.artkolest.spidertestproject.data.NetworkRepository
import ru.artkolest.spidertestproject.data.api.NetworkApi
import ru.artkolest.spidertestproject.domain.NetworkDataSource

@Module
class NetworkModule {

    val gson = GsonBuilder().serializeNulls().create()

    private fun createRetrofitClient(baseUrl: String): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        return Retrofit.Builder()
            .client(okHttpBuilder.build())
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideProfileAPI(): NetworkApi {
        return createRetrofitClient("https://apidocs.imgur.com/?version=latest#c85c9dfc-7487-4de2-9ecd-66f727cf3139").create(NetworkApi::class.java)
    }

    @Provides
    fun provideProfileDataSource(api: NetworkApi): NetworkDataSource {
        return NetworkRepository(api)
    }
}