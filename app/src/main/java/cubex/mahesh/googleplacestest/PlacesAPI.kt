package cubex.mahesh.googleplacestest

import cubex.mahesh.googleplacestest.beans.PlacesBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesAPI {
    @GET("maps/api/place/nearbysearch/json?location=17.4376097,78.4491694&radius=500&key=AIzaSyCEhUs1eh84cVifTJv8IzUG5X1Roxr5HFU")
    fun  getPlaces(@Query("type") type:String):Call<PlacesBean>
}