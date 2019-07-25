package com.mateocvas.laboratorio1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.punto2.view.*

class Punto2:Fragment(),AdapterView.OnItemSelectedListener{
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val tempo=conversion()
        if(tempo<0 && tempo>-3)
            Toast.makeText(vista.context,R.string.errore_moneda,Toast.LENGTH_LONG).show()
        else if (tempo>=0){
            vista.tv_salida.setText(tempo.toString().plus(divisa()))
        }    }

    lateinit var vista:View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vista=inflater.inflate(R.layout.punto2, container, false)
        inicie()
        return vista
    }


    fun inicie(){

        val list = ArrayList<String>()
        list.add(vista.context.getString(R.string.moneda1))
        list.add(vista.context.getString(R.string.moneda2))
        list.add(vista.context.getString(R.string.moneda3))

        val dataAdapter = ArrayAdapter<String>(vista.context, android.R.layout.simple_spinner_item, list)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        vista.spiner_destino.setAdapter(dataAdapter)
        vista.espiner_origen.setAdapter(dataAdapter)


        vista.tv_entrada.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                val tempo=conversion()
                if(tempo<0 && tempo>-3)
                    Toast.makeText(vista.context,R.string.errore_moneda,Toast.LENGTH_LONG).show()
                else if (tempo>=0){
                    vista.tv_salida.setText(tempo.toString().plus(divisa()))
                }
            }
        })


        vista.spiner_destino.setOnItemSelectedListener(this)
        vista.espiner_origen.setOnItemSelectedListener(this)

    }


fun conversion():Double{
    val spin2=vista.spiner_destino.selectedItem.toString()
    val spin1=vista.espiner_origen.selectedItem.toString()
    if(!vista.tv_entrada.text.toString().equals("")) {
        val entrada = vista.tv_entrada.text.toString().toDouble()
        if (vista.spiner_destino.selectedItem.toString().equals(vista.espiner_origen.selectedItem.toString()))
            return -1.0
        if (spin1.equals(vista.context.getString(R.string.moneda1)) && spin2.equals(vista.context.getString(R.string.moneda2)))
            return    Math.round( (entrada / 3179.55)* 1000.0) / 1000.0
        else if (spin1.equals(vista.context.getString(R.string.moneda2)) && spin2.equals(vista.context.getString(R.string.moneda1)))
            return  Math.round((3179.55 / entrada)* 1000.0) / 1000.0
        else if (spin1.equals(vista.context.getString(R.string.moneda1)) && spin2.equals(vista.context.getString(R.string.moneda3)))
            return  Math.round((entrada / 0.42485)* 1000.0) / 1000.0
        else if (spin1.equals(vista.context.getString(R.string.moneda3)) && spin2.equals(vista.context.getString(R.string.moneda1)))
            return  Math.round( (0.42485/entrada)* 1000.0) / 1000.0
        else if (spin1.equals(vista.context.getString(R.string.moneda2)) && spin2.equals(vista.context.getString(R.string.moneda3)))
            return Math.round( (entrada / 0.100125)* 1000.0) / 1000.0
        else
            return Math.round( ( 0.100125 / entrada)* 1000.0) / 1000.0
    }
    return-4.0
}

    fun divisa():String{
        if (vista.spiner_destino.selectedItem.toString().equals(vista.context.getString(R.string.moneda1)))
            return " COP"
        else if (vista.spiner_destino.selectedItem.toString().equals(vista.context.getString(R.string.moneda2)))
            return " USA"
        else
            return  " VEF"
    }

}