package com.android.alejandra.ejer5comunicatefragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * Use the {@link FragmentVisualizaResultado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentVisualizaResultado extends Fragment {

    private static final String OPCIONES_FORMATO= "formato";


    //para guardar estado
    private Bundle opcionesFormatoWithTexto;



    public FragmentVisualizaResultado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
              * @return A new instance of fragment FragmentVisualizaResultado.
     */

    public static FragmentVisualizaResultado newInstance() {
        FragmentVisualizaResultado fragment = new FragmentVisualizaResultado();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_visualiza_resultado, container, false);

        return v;
    }



    public void mostrarTextoFormateado(Bundle opcionesFormato){
        if (opcionesFormato!= null) {
            opcionesFormatoWithTexto=opcionesFormato;

            formatearTexto(opcionesFormato,(TextView)getView().findViewById(R.id.tvTextoFormateado));
        }
    }

    /*Método que recibe un bundle con un texto, y unos atributos de formato, ademas recibe también un TextView
     y formatea el texto del TextView con esos atributos
      */
    private void formatearTexto(Bundle opcionesFormato, TextView textoFormateado) {
        //recojo atributos formato, del bundle
        String texto=opcionesFormato.getString(FragmentFormatearTexto.TEXTO);
        int color=opcionesFormato.getInt(FragmentFormatearTexto.COLOR);
        float tamanio=opcionesFormato.getFloat(FragmentFormatearTexto.TAMANIO);
        boolean isNegrita=opcionesFormato.getBoolean(FragmentFormatearTexto.NEGRITA);
        //formateo texto
        textoFormateado.setText(texto);
        textoFormateado.setTextSize(tamanio);
        textoFormateado.setTextColor(color);
        if(isNegrita)
            textoFormateado.setTypeface(Typeface.DEFAULT_BOLD);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(opcionesFormatoWithTexto!=null)
            outState.putBundle(OPCIONES_FORMATO,opcionesFormatoWithTexto);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState!=null)
        {
            opcionesFormatoWithTexto=savedInstanceState.getBundle(OPCIONES_FORMATO);
            formatearTexto(opcionesFormatoWithTexto,(TextView)getView().findViewById(R.id.tvTextoFormateado));
        }
    }
}
