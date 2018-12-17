package fr.epita.tictactoe

import retrofit2.http.GET
import retrofit2.Call

interface WebServiceInterface {
    @GET("/scores.json")
    fun getGameList(): Call<List<Score>>
}