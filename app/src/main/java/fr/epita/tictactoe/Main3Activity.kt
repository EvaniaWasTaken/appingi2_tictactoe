package fr.epita.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.GsonBuilder
import fr.epita.tictactoe.R.id.list_score
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Main3Activity : AppCompatActivity() {
    var data = arrayListOf<Score>()

    var callback = object : Callback<List<Score>> {
        override fun onFailure(call: Call<List<Score>>?, t: Throwable?) {
            // Code here what happens if calling the WebService fails
            Log.d("TAG", "WebService call failed")
        }
        override fun onResponse(call: Call<List<Score>>?,
                                response: Response<List<Score>>?) {
            // Code here what happens when WebService responds
            if (response != null) {
                if (response.code() == 200) {
                    // We got our data !
                    var responseData = response.body()
                    if (responseData != null) {
                        data.addAll(responseData)
                        Log.d("TAG", "WebService success game list: " + data.size)
                        //list_score.adapter = ListAdapter(context!!, data)
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var baseURL = "http://www.onzeweb.net/api/"
        // Use GSON library to create our JSON parser
        var jsonConverter = GsonConverterFactory.create(GsonBuilder().create())
        // Create a Retrofit client object targeting the provided URL
        // and add a JSON converter (because we are expecting json responses)
        var retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(jsonConverter)
            .build()
        var service: WebServiceInterface = retrofit.create(WebServiceInterface::class.java)

        service.getGameList().enqueue(callback)
    }
}
