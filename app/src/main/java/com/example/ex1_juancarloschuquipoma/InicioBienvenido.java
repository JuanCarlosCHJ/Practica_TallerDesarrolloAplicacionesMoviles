package com.example.ex1_juancarloschuquipoma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class InicioBienvenido extends Fragment {

    private EditText nombreUsuario;
    private Button btnAdivinaNumero, btnJugarGolpeado;

    // En lugar de onCreate, utilizamos onCreateView en los Fragments
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del Fragment
        View view = inflater.inflate(R.layout.inicio_bienvenido, container, false);

        // Inicializar los elementos del layout
        nombreUsuario = view.findViewById(R.id.nombreUsuario);
        btnAdivinaNumero = view.findViewById(R.id.btnAdivinaNumero);
        btnJugarGolpeado = view.findViewById(R.id.btnJugarGolpeado);

        // Configurar los listeners para los botones
        btnAdivinaNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreUsuario.getText().toString();

                // Crear un Bundle para pasar datos al siguiente Fragment
                Bundle bundle = new Bundle();
                bundle.putString("NOMBRE_JUGADOR", nombre);

                // Navegar al fragmento AdivinaNumeroFragment
                NavHostFragment.findNavController(InicioBienvenido.this)
                        .navigate(R.id.action_bienvenidaFragment_to_adivinaNumeroFragment, bundle);
            }
        });

        btnJugarGolpeado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreUsuario.getText().toString();

                // Crear un Bundle para pasar datos al siguiente Fragment
                Bundle bundle = new Bundle();
                bundle.putString("NOMBRE_JUGADOR", nombre);

                // Navegar al fragmento JugarGolpeadoFragment
                NavHostFragment.findNavController(InicioBienvenido.this)
                        .navigate(R.id.action_bienvenidaFragment_to_golpeadoFragment, bundle);
            }
        });

        // Retornar la vista del Fragment
        return view;
    }
}
