package com.example.countries


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.Adapter.CountryListAdapter
import com.example.countries.Model.Country
import com.example.countries.ViewModel.CountryListModelView


class MainActivity : AppCompatActivity() {
    lateinit var adapter: CountryListAdapter
    lateinit var list:List<Country>
    lateinit   var viewModel: CountryListModelView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView =findViewById(R.id.recyclerview) as RecyclerView
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=linearLayoutManager
        adapter= CountryListAdapter(mutableListOf(),this)
        recyclerView.adapter=adapter

        viewModel= ViewModelProvider(this).get(CountryListModelView::class.java)
        viewModel.DataObserver().observe(this,object: Observer<List<Country>> {
            override fun onChanged(t: List<Country>?) {
                if(t!=null) {
                    list = t!!

                    adapter.setList(t)
                    Log.v("size", t.toString())
                }

            }

        } )
        viewModel.getAllCountries()
    }




}
