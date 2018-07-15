package cubex.mahesh.googleplacestest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import cubex.mahesh.googleplacestest.beans.PlacesBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1.setOnClickListener({
            var r = Retrofit.Builder().
                    addConverterFactory(GsonConverterFactory.create()).
                    baseUrl("https://maps.googleapis.com/").
                    build()
         var api =    r.create(PlacesAPI::class.java)
        var call = api.getPlaces(sp1.selectedItem.toString())
        call.enqueue(object : Callback<PlacesBean> {
            override fun onResponse(call: Call<PlacesBean>?,
                                    response: Response<PlacesBean>?) {
                Toast.makeText(this@MainActivity,
                        "Success",Toast.LENGTH_LONG).show()
     var resp = response!!.body()
      var list =   resp!!.results
      var temp_list = mutableListOf<String>()
    for( place in list!!) {
        temp_list.add(place.name+"\n"+place.vicinity)
    }
                var adapter = ArrayAdapter<String>(this@MainActivity,
                        android.R.layout.simple_list_item_single_choice,temp_list)
                lview.adapter = adapter

            }
    override fun onFailure(call: Call<PlacesBean>?, t: Throwable?) {

        Toast.makeText(this@MainActivity,
                "Fail",Toast.LENGTH_LONG).show()
        Log.e("msg",t!!.message)
            }
        })
        })
    }
}
