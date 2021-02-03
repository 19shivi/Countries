package com.example.countries.Adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader

import com.example.countries.Model.Country
import com.example.countries.R

class CountryListAdapter(private var CountryList: List<Country>, var context: Context): RecyclerView.Adapter<CountryListAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.country, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.v("position", position.toString())
           holder?.name.text=CountryList[position].name
        holder?.capital.text=CountryList[position].capital
        holder?.region.text=CountryList[position].region
        holder?.subregion.text=CountryList[position].subregion
        holder?.border.text="Borders : "+CountryList[position].borders.toString()
        holder?.languages.text="Languages : "+CountryList[position].languages.toString()
        holder?.population.text=CountryList[position].population.toString()
        SvgLoader.pluck()
            .with(context as Activity) // ur activity
            .load(CountryList[position].flag, holder.flag);

    }

    override fun getItemCount(): Int {

       return CountryList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.Name)
        val capital: TextView = itemView.findViewById(R.id.capital)
        val population: TextView = itemView.findViewById(R.id.population)
        val region: TextView = itemView.findViewById(R.id.region)
        val subregion: TextView = itemView.findViewById(R.id.subregion)
        val flag:ImageView=itemView.findViewById(R.id.image)
        val border: TextView = itemView.findViewById(R.id.border)
        val languages: TextView = itemView.findViewById(R.id.languages)

    }
    fun setList(l: List<Country>)
    {
        CountryList=l
        notifyDataSetChanged()
    }




}