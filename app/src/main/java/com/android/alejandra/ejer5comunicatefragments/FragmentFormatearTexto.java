package com.android.alejandra.ejer5comunicatefragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentFormatearTexto.OnButtonClickListener} interface
 * to handle interaction events.
 * Use the {@link FragmentFormatearTexto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFormatearTexto extends Fragment {
    public static final String TEXTO="texto";
    public static final String COLOR="color";
    public static final String TAMANIO="tamanio";
    public static final String NEGRITA="negrita";

    private OnButtonClickListener mListener;

    public FragmentFormatearTexto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentFormatearTexto.
     */

    public static FragmentFormatearTexto newInstance() {
        FragmentFormatearTexto fragment = new FragmentFormatearTexto();
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
        View v= inflater.inflate(R.layout.fragment_fragment_formatear_texto, container, false);
        //obtengo referencias
        final EditText textoSinFormato=(EditText)v.findViewById(R.id.etTextoSinFormato);
        final CheckBox cbRojo=(CheckBox) v.findViewById(R.id.cbRojo);
        final CheckBox cbGrande=(CheckBox) v.findViewById(R.id.cbGrande);
        final CheckBox cbNegrita=(CheckBox) v.findViewById(R.id.cbNegrita);

        Button btVerResultado=(Button)v.findViewById(R.id.btVerResultado);
        btVerResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto=textoSinFormato.getText().toString();
                int color=(cbRojo.isChecked())? Color.RED:Color.BLACK;
                float tamanio=(cbGrande.isChecked())?30:18;
                boolean isNegrita=(cbNegrita.isChecked())?true:false;
                Bundle opcionesFormato=new Bundle();
                opcionesFormato.putString(TEXTO,texto);
                opcionesFormato.putInt(COLOR,color);
                opcionesFormato.putFloat(TAMANIO,tamanio);
                opcionesFormato.putBoolean(NEGRITA,isNegrita);
                mListener.onButtonClick(opcionesFormato);
            }
        });

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonClickListener) {
            mListener = (OnButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnButtonClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnButtonClickListener {

        void onButtonClick(Bundle formatoTexto);
    }
}
