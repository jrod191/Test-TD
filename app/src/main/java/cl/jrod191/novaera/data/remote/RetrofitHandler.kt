package cl.jrod191.novaera.data.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHandler {

    fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }
    fun getTelefonoApi(): TelefonosApi {
        return getRetrofit().create(TelefonosApi::class.java)
    }
}
