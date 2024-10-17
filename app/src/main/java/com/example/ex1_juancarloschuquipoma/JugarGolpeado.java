package com.example.ex1_juancarloschuquipoma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class JugarGolpeado extends Fragment {
    private TextView txtNombreJugador, txtNumeroJugadores, txtCartasGeneradas;
    private Button btnGenerarCartas, btnRegresarInicio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout para este Fragment
        View view = inflater.inflate(R.layout.jugar_golpeado, container, false);

        // Inicializar los componentes del layout
        txtNombreJugador = view.findViewById(R.id.txtNombreJugador);
        txtNumeroJugadores = view.findViewById(R.id.txtNumeroJugadores);
        txtCartasGeneradas = view.findViewById(R.id.txtCartasGeneradas);
        btnGenerarCartas = view.findViewById(R.id.btnGenerarCartas);
        btnRegresarInicio = view.findViewById(R.id.btnRegresar);

        // Obtener el nombre del jugador a través del Bundle
        if (getArguments() != null) {
            String nombreJugador = getArguments().getString("NOMBRE_JUGADOR");
            txtNombreJugador.setText("Jugador: " + nombreJugador);
        }

        // Configurar el listener para el botón de generar cartas
        btnGenerarCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarCartas();
            }
        });

        btnRegresarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(JugarGolpeado.this)
                        .navigate(R.id.bienvenidaFragment);
            }
        });

        return view;
    }

    private void generarCartas() {

        Random random = new Random();
        int numeroJugadores = random.nextInt(4) + 1; // aleatorio entre 1 y 4
        txtNumeroJugadores.setText("Numero de jugadores: " + numeroJugadores);

        // Crear la baraja y mezclarla
        List<String> baraja = crearBaraja();
        Collections.shuffle(baraja); // Mezclar las cartas

        StringBuilder cartasGeneradas = new StringBuilder();

        // Asignar cartas a cada jugador
        for (int i = 0; i < numeroJugadores; i++) {
            int cartasPorJugador = (i == 0) ? 8 : 7; // El primer jugador recibe 8 cartas, los demás 7
            cartasGeneradas.append("Jugador ").append(i + 1).append(": ");

            for (int j = 0; j < cartasPorJugador; j++) {
                if (j > 0) {
                    cartasGeneradas.append(", ");
                }
                cartasGeneradas.append(baraja.remove(0)); // Eliminar la carta de la baraja
            }
            cartasGeneradas.append("\n\n");
        }

        // Mostrar las cartas generadas en el TextView
        txtCartasGeneradas.setText(cartasGeneradas.toString());
    }

    private List<String> crearBaraja() {
        List<String> baraja = new ArrayList<>();
        String[] tipos = {"Corazones", "Espadas", "Flores", "Diamantes"};

        // Crear cartas de la baraja
        for (String tipo : tipos) {
            for (int i = 1; i <= 13; i++) {
                baraja.add(i + " de " + tipo); // Agregar cartas a la baraja
            }
        }
        return baraja;
    }
}
