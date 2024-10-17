package com.example.ex1_juancarloschuquipoma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.Random;

public class AdivinaNumero extends Fragment {
    private TextView txtNombreJugador, txtResultado, txtIntentosAnteriores;
    private EditText inputIntento;
    private Button btnEnviarIntento, btnReiniciar, btnRegresar;

    private int numeroSecreto;
    private ArrayList<Integer> intentos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout para este Fragment
        View view = inflater.inflate(R.layout.adivina_numero, container, false);

        // Inicializar los componentes del layout
        txtNombreJugador = view.findViewById(R.id.txtNombreJugador);
        txtResultado = view.findViewById(R.id.txtResultado);
        txtIntentosAnteriores = view.findViewById(R.id.txtIntentosAnteriores);
        inputIntento = view.findViewById(R.id.inputIntento);
        btnEnviarIntento = view.findViewById(R.id.btnEnviarIntento);
        btnReiniciar = view.findViewById(R.id.btnReiniciar);
        btnRegresar = view.findViewById(R.id.btnRegresar);

        intentos = new ArrayList<>();
        numeroSecreto = new Random().nextInt(100) + 1; // Número secreto entre 1 y 100

        // Obtener el nombre del jugador del Bundle
        if (getArguments() != null) {
            String nombreJugador = getArguments().getString("NOMBRE_JUGADOR");
            txtNombreJugador.setText("Jugador: " + nombreJugador);
        }

        // Configurar el listener para enviar intento
        btnEnviarIntento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intento = Integer.parseInt(inputIntento.getText().toString());
                intentos.add(intento);
                verificarIntento(intento);
            }
        });

        // Configurar el listener para reiniciar el juego
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarJuego();
            }
        });

        // Configurar el listener para el botón de regresar (navegar al fragmento anterior)
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar al fragmento anterior
                NavHostFragment.findNavController(AdivinaNumero.this).popBackStack();
            }
        });

        return view;
    }

    private void verificarIntento(int intento) {
        if (intento == numeroSecreto) {
            txtResultado.setText("Has adivinado el número");
            txtResultado.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.holo_green_dark));
            txtResultado.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.white));
        } else {
            txtResultado.setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark));
            txtResultado.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.white));

            if (intento < numeroSecreto) {
                txtResultado.setText("Demasiado bajo");
            } else {
                txtResultado.setText("Demasiado alto");
            }
        }
        actualizarIntentosAnteriores();
    }

    private void actualizarIntentosAnteriores() {
        txtIntentosAnteriores.setText("Intentos anteriores: " + intentos.toString());
    }

    private void reiniciarJuego() {
        numeroSecreto = new Random().nextInt(100) + 1;
        intentos.clear();
        txtResultado.setText("Resultado: ");
        txtIntentosAnteriores.setText("Intentos anteriores: ");
        inputIntento.setText("");
    }
}
