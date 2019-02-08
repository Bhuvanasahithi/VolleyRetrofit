package com.example.sahithi.objectparsing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofits : AppCompatActivity() {
   lateinit var recyclerview:RecyclerView
   lateinit var layoutManager: RecyclerView.LayoutManager
    var retrofitadapter:RetrofitAdapter?=null
    var url="http://www.mocky.io/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofits)
        recyclerview=findViewById(R.id.recyclerview)
        layoutManager=LinearLayoutManager(this)
        //creating the retrofit instance
        var retrofit=Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        //creating the object for the interface getdataservice
        var service=retrofit.create(GetDataService::class.java)
        var call=service.allPhotosList
        call.enqueue(object:Callback<List<ImageModel>>
        {
            override fun onFailure(call: Call<List<ImageModel>>, t: Throwable) {
                Toast.makeText(this@Retrofits,"error occoured",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<ImageModel>>, response: Response<List<ImageModel>>) {
                var list=response.body()
                var list1=ArrayList<ImageModel>()
                if(list!=null)
                {
                    for(i in 0..list.size-1)
                    {
                        var imagemodel=list.get(i)
                        list1.add(imagemodel)
                    }
                    retrofitadapter=RetrofitAdapter(this@Retrofits,list1)
                    recyclerview.adapter=retrofitadapter
                    recyclerview.layoutManager=layoutManager
                }

            }

        })


    }
}
