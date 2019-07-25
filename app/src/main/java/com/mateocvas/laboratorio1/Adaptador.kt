package com.mateocvas.laboratorio1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adaptador(datos:ArrayList<Item>,context: Context):BaseAdapter(){
    var datos: ArrayList<Item>
    private val inflater: LayoutInflater
    init {
        this.datos=datos
        this.inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val row:View
        val holder:viewholder
        if(convertView==null){
            holder= viewholder()
            row=inflater.inflate(R.layout.item, null, true)
            holder.color=row.findViewById(R.id.color)
            row.setTag(holder)


        }
        else{
            holder = convertView.tag as viewholder
            row=convertView
        }
        holder.color.setBackgroundColor(Color.parseColor(datos[position].color))

        return row
    }

    override fun getItem(position: Int): Any {
return datos.get(position)
    }

    override fun getItemId(position: Int): Long {
return position.toLong()
    }


    override fun getCount(): Int {
return datos.size
    }


    inner class viewholder{
        lateinit var color:TextView


    }

}