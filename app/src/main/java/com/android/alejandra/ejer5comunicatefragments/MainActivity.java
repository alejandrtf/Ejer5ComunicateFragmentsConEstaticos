package com.android.alejandra.ejer5comunicatefragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentFormatearTexto.OnButtonClickListener{
  private FragmentVisualizaResultado fragmentVisualizaResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onButtonClick(Bundle formatoTexto) {
        //boton pulsado, lanzar el segundo fragment
        fragmentVisualizaResultado=(FragmentVisualizaResultado)getSupportFragmentManager().findFragmentById(R.id.fragmentVisualizaResultado);
        if(fragmentVisualizaResultado!=null)
            fragmentVisualizaResultado.mostrarTextoFormateado(formatoTexto);
    }


}
