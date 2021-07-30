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
import ru.artkolest.spidertestproject.util.BASE_URL

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
        return createRetrofitClient(BASE_URL).create(NetworkApi::class.java)
    }

    @Provides
    fun provideProfileDataSource(api: NetworkApi): NetworkDataSource {
        return NetworkRepository(api)
    }
}