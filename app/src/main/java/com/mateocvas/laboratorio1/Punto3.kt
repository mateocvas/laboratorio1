package com.mateocvas.laboratorio1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.punto2.view.*
import kotlinx.android.synthetic.main.punto3.view.*

class Punto3: Fragment(),View.OnClickListener {
    override fun onClick(v: View?) {

        when (v?.id){
            R.id.b0->
            concatene("0")
            R.id.b1->
                concatene("1")
            R.id.b2->
                concatene("2")
            R.id.b3->
                concatene("3")
            R.id.b4->
                concatene("4")
            R.id.b5->
                concatene("5")
            R.id.b6->
                concatene("6")
            R.id.b7->
                concatene("7")
            R.id.b8->
                concatene("8")
            R.id.b9->
                concatene("9")
            R.id.bpun->
                concatene(".")
            R.id.bmas->{
                if(a.equals(""))
                    Toast.makeText(vista.context,R.string.error_ingresara_b,Toast.LENGTH_LONG).show()
                else{
                operacion=R.id.bmas
                bandera=true}}
            R.id.bmen->{
                if(a.equals(""))
                    Toast.makeText(vista.context,R.string.error_ingresara_b,Toast.LENGTH_LONG).show()
                else{
                operacion=R.id.bmen
                bandera=true}}
            R.id.bdiv->{
                if(a.equals(""))
                    Toast.makeText(vista.context,R.string.error_ingresara_b,Toast.LENGTH_LONG).show()
                else{
                operacion=R.id.bdiv
                bandera=true}}
            R.id.bpor->{
                if(a.equals(""))
                    Toast.makeText(vista.context,R.string.error_ingresara_b,Toast.LENGTH_LONG).show()
                else{
                operacion=R.id.bpor
                bandera=true}}
            R.id.bigu->{
                if(a.equals(""))
                    Toast.makeText(vista.context,R.string.error_ingresara_b,Toast.LENGTH_LONG).show()
                else if(b.equals(""))
                    Toast.makeText(vista.context,R.string.error_ingresara_b,Toast.LENGTH_LONG).show()
                else
                    when (operacion){
                        R.id.bpor->
                            vista.resultado.setText((a.toDouble()*b.toDouble()).toString())
                        R.id.bdiv->
                            vista.resultado.setText((a.toDouble()/b.toDouble()).toString())
                        R.id.bmas->
                            vista.resultado.setText((a.toDouble()+b.toDouble()).toString())
                        R.id.bmen->
                            vista.resultado.setText((a.toDouble()-b.toDouble()).toString())


                }

                a=""
                b=""
                bandera=false}
        }

    }

    var a=""
    var b=""
    var bandera=false
    var operacion=0


    lateinit var vista:View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vista=inflater.inflate(R.layout.punto3, container, false)
        inicie()
        return vista
    }

    fun inicie(){
        vista.b1.setOnClickListener (this)
        vista.b2.setOnClickListener (this)
        vista.b3.setOnClickListener (this)
        vista.b4.setOnClickListener (this)
        vista.b5.setOnClickListener (this)
        vista.b6.setOnClickListener (this)
        vista.b7.setOnClickListener (this)
        vista.b8.setOnClickListener (this)
        vista.b9.setOnClickListener (this)
        vista.b0.setOnClickListener (this)
        vista.bpor.setOnClickListener (this)
        vista.bdiv.setOnClickListener (this)
        vista.bmas.setOnClickListener (this)
        vista.bmen.setOnClickListener (this)
        vista.bpun.setOnClickListener (this)
        vista.bigu.setOnClickListener (this)


    }
    fun concatene (tempo:String){
        if(!bandera) {
            a+=tempo
            vista.resultado.setText(a)
        }
        else {
            b+=tempo
            vista.resultado.setText(b)

        }



    }



}