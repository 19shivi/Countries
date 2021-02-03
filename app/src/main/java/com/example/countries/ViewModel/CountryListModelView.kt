package com.example.countries.ViewModel


import androidx.lifecycle.ViewModel
import retrofit2.Call
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.countries.Model.Country
import com.example.countries.Networks.ApiService
import com.example.countries.Networks.RetrofitInstance
import retrofit2.Callback
import retrofit2.Response

class CountryListModelView : ViewModel() {
      var mutableData: MutableLiveData<List<Country>> =MutableLiveData<List<Country>>()
    fun DataObserver():MutableLiveData<List<Country>>{
        return mutableData
    }
    fun getAllCountries()
    {
        val apiService: ApiService = RetrofitInstance.buildService(ApiService::class.java)
        val call:Call<List<Country>> =apiService.getAllCountry()
        call.enqueue(object: Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                mutableData.postValue(response.body())
                Log.v("api",response.body().toString())

            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
              mutableData.postValue(null)
                Log.v("error",t.toString())
            }

        })
    }

}
