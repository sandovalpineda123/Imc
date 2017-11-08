package com.papi.samuel.imc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculaMCFragments extends Fragment {

    EditText etPeso, etTalla;
    TextView tvResNum, tvResText;
    Button btnCalcular;
    ImageView imageView2;

    public CalculaMCFragments() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaPrincipal = inflater.inflate(R.layout.fragment_calcula_mcfragments,container,false);
        etPeso = (EditText) vistaPrincipal.findViewById(R.id.etPeso);
        etTalla = (EditText) vistaPrincipal.findViewById(R.id.etTalla);
        tvResNum = (TextView) vistaPrincipal.findViewById(R.id.tvResNum);
        tvResText = (TextView) vistaPrincipal.findViewById(R.id.tvResTex);
        btnCalcular = (Button) vistaPrincipal.findViewById(R.id.btnCalcular);
        imageView2 = (ImageView) vistaPrincipal.findViewById(R.id.imageView2);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso, altura, IMC;
                peso = Double.parseDouble(etPeso.getText().toString());
                altura = Double.parseDouble(etTalla.getText().toString());

                IMC=peso/Math.pow(altura,2);
                int situacion;
                if (IMC<18.5){
                    situacion=1;
                }
                else if (IMC>18.5 && IMC<=24.99){
                    situacion=2;
                }
                else  {
                    situacion=3;
                }

                switch (situacion){
                    case  1:
                        tvResText.setText("Estas bajo de peso");
                        Picasso.with(getActivity()).load(R.drawable.flaco).into(imageView2);

                        Crouton.makeText(getActivity(),"Bajo peso", Style.INFO).show();

                        break;
                    case 2:
                        tvResText.setText("Estas en tu peso normal");
                        Picasso.with(getActivity()).load(R.drawable.normal).into(imageView2);
                        Crouton.makeText(getActivity(),"Peso normal", Style.CONFIRM).show();
                        break;
                    case 3:
                        tvResText.setText("Estas en sobre peso");
                        Picasso.with(getActivity()).load(R.drawable.gordo).into(imageView2);
                        Crouton.makeText(getActivity(),"Sobre Peso", Style.ALERT).show();
                        break;

                }
                tvResNum.setText(""+IMC);



            }
        });
        return vistaPrincipal;
    }

}
