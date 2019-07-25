package com.mateocvas.laboratorio1

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.punto1.*
import kotlinx.android.synthetic.main.punto1.view.*
import java.util.*
import kotlin.collections.ArrayList


class Punto1(): Fragment() {

    lateinit var nombre:String
    lateinit var contrasena1:String
    lateinit var contrasena2:String
    lateinit var correo:String
    lateinit var fecha:String
    lateinit var sexo:String
    lateinit var ciudad:String
    lateinit var hobbies:String
    lateinit var datelistener:DatePickerDialog.OnDateSetListener





    fun inicie(){
        val list = ArrayList<String>()
        list.add("Ciudad")
        list.add(vista.context.getString(R.string.ciudad1))
        list.add(vista.context.getString(R.string.ciudad2))
        list.add(vista.context.getString(R.string.ciudad3))
        list.add(vista.context.getString(R.string.ciudad4))
        val dataAdapter = ArrayAdapter<String>(vista.context, android.R.layout.simple_spinner_item, list)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        vista.ciudad.setAdapter(dataAdapter)

        vista.boton.setOnClickListener {
            fijeInformacion()
            val temp =verifique()
            Toast.makeText(vista.context,temp,Toast.LENGTH_LONG).show()
            if(temp.equals(vista.context.getString(R.string.entrada_correcta)))
                vista.respuesta.setText(acomul())

        }

        vista.fecha.setOnClickListener{
        fije_fecha()
        }

        datelistener=DatePickerDialog.OnDateSetListener{ datePicker: DatePicker, i: Int, i1: Int, i2: Int ->
            val conc=i2.toString()+"/"+i1.toString()+"/"+i.toString()
            vista.fecha.setText(conc)
        }

    }

    fun fije_fecha(){
        val calendario= Calendar.getInstance()
        val dia=calendario.get(Calendar.DAY_OF_MONTH)
        val mes=calendario.get(Calendar.MONTH)
        val ano=calendario.get(Calendar.YEAR)
        val dialogFecha=
            DatePickerDialog(vista.context,android.R.style.Theme_Holo_Light_Dialog_MinWidth,datelistener,ano,mes,dia)
        dialogFecha.show()
    }

       fun acomul():String{
           var concatenen=""
           concatenen=concatenen+" Nombre:"+nombre+"\n"
           concatenen=concatenen+" contraseña:"+contrasena2+"\n"
           concatenen=concatenen+" Correo:"+correo+"\n"
           concatenen=concatenen+" Fecha:"+fecha+"\n"
           concatenen=concatenen+" Sexo:"+sexo+"\n"
           concatenen=concatenen+" Ciudad:"+ciudad+"\n"
           concatenen=concatenen+" Hobbies:"+hobbies+"\n"
           return concatenen

       }


        fun fijeInformacion(){
        nombre=vista.nombre.text.toString()
        contrasena1=vista.contrasena.text.toString()
        contrasena2=vista.contrasena2.text.toString()
        correo=vista.correo.text.toString()
        fecha=vista.fecha.text.toString()
        sexo=vista.findViewById<RadioButton>(radioGroup3.checkedRadioButtonId).text.toString()
        ciudad=vista.findViewById<Spinner>(R.id.ciudad).selectedItem.toString()
            hobbies=""
            if(vista.hobbie1.isChecked)
                hobbies+=vista.hobbie1.text.toString()+"\n"
            if(vista.hobbie2.isChecked)
                hobbies+=vista.hobbie2.text.toString()+"\n"
            if(vista.hobbie3.isChecked)
                hobbies+=vista.hobbie3.text.toString()+"\n"
            if(vista.hobbie4.isChecked)
                hobbies+=vista.hobbie4.text.toString()+"\n"

    }
    fun verifique():String{
       val returno = if (nombre.equals("")||contrasena1.equals("")||contrasena2.equals("")||correo.equals("")||fecha.equals(""))
                          vista.context.getString(R.string.error_entradas_vacias)
                     else if(ciudad.equals("Ciudad"))
                           vista.context.getString(R.string.errore_ingresa_ciudad)
                     else if(!contrasena1.equals(contrasena2))
                           vista.context.getString(R.string.errore_contrasena)
                     else
                           vista.context.getString(R.string.entrada_correcta)

         return returno
    }
    lateinit var vista:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vista=inflater.inflate(R.layout.punto1, container, false)
        inicie()
        return vista
    }


}