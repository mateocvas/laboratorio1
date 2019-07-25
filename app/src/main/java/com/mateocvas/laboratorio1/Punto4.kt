package com.mateocvas.laboratorio1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import kotlinx.android.synthetic.main.punto4.view.*

class Punto4: Fragment(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val i1=vista.spinner.selectedItemPosition
        val i2=vista.spinner2.selectedItemPosition
        val i3=vista.spinner3.selectedItemPosition
        val i4=vista.spinner4.selectedItemPosition

        resultado=""
        var pot=""

        if(i3==2 || i3==5 || i3==8||i3==12)
            resultado+= i1.toString()+"."+i2.toString()

        else
            resultado+=i1.toString()+i2.toString()


        if(i3>=2 && i3<5)
            pot="K"
        else if(i3>=5 && i3<8)
            pot="M"
        else if (i3>=8 && i3<12)
            pot="G"


        var zeros=""

        if (i3==1 || i3==4 || i3==7  )
            zeros="0"


        resultado+=zeros+pot

        if(i4==0)
            resultado+=" %5"
        else
            resultado+=" %10"



        vista.result.setText(resultado)
    }

var resultado=""
lateinit var vista:View
lateinit var datos:ArrayList<Item>
lateinit var datos2:ArrayList<Item>
lateinit var Adap:Adaptador
lateinit var Adap2:Adaptador



override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    vista=inflater.inflate(R.layout.punto4, container, false)
    inicie()
    return vista
}
    fun inicie(){
        datos= ArrayList()
        datos2= ArrayList()

        datos.add(Item("#221716"))
        datos.add(Item("#C5824D"))
        datos.add(Item("#FB0106"))
        datos.add(Item("#E8771A"))
        datos.add(Item("#F7F220"))
        datos.add(Item("#00FE0E"))
        datos.add(Item("#174CDF"))
        datos.add(Item("#7A4267"))
        datos.add(Item("#828280"))
        datos.add(Item("#FDFFFF"))


        datos2.add(Item("#A59609"))
        datos2.add(Item("#8F908B"))


        Adap= Adaptador(datos,vista.context)
        Adap2= Adaptador(datos2,vista.context)
        vista.spinner.adapter=Adap
        vista.spinner2.adapter=Adap
        vista.spinner3.adapter=Adap
        vista.spinner4.adapter=Adap2
        vista.spinner.setOnItemSelectedListener(this)
        vista.spinner2.setOnItemSelectedListener(this)
        vista.spinner3.setOnItemSelectedListener(this)
        vista.spinner4.setOnItemSelectedListener(this)


        Adap.notifyDataSetChanged()
        Adap2.notifyDataSetChanged()






    }

}