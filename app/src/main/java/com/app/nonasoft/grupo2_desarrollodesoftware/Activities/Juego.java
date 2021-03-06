package com.app.nonasoft.grupo2_desarrollodesoftware.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.nonasoft.grupo2_desarrollodesoftware.R;

/**
 * Created by Adara on 11/18/2016.
 */
public class Juego extends AppCompatActivity {

    Context context;
    SharedPreferences logros;

    private TextView pregunta;

    private Button btnOpcion_1;
    private Button btnOpcion_2;
    private Button btnOpcion_3;
    private Button btnOpcion_4;

    private String election;

    private Toolbar toolbar;

    private boolean isButtonClicked = false;
    private ImageView imgResultado;
    private ImageView imageLogro;


    public int intPuntaje;
    public TextView txtPuntaje;
    public int preguntaNumero = 0;

    public int puedoPulsarRespuesta = 1;



    //LISTA DE CONTENIDO PARA LOS MINIJUEGOS
    //NOTA: solo puede haber 3 preguntas y 4 opciones para ellas
        //para el btnInicial1
            //preguntas
    static String[] preguntasInicial1 = {"¿Cual red social se utiliza solo para subir imagenes y videos?", "pregunta 2", "pregunta 3"};
            //opciones
            //Orden de respuestas correctas: [3],[2],[0]
    static String[][] opcionesInicial1 = {
                    {"facebook", "gmail", "twitter", "instagram"},
                    {"opcion1", "opcion2", "opcion3", "opcion4"},
                    {"opcion1 a", "opcion2 b", "opcion3 c", "opcion4 d"}
            };
        //para el btnInicial2
           //preguntas
    static String[] preguntasInicial2 = {"pregunta 1", "pregunta 2", "pregunta 3"};
            //opciones
            //Orden de respuestas correctas: [2],[3],[2]
    static String[][] opcionesInicial2 = {
            {"opcion1", "opcion2", "opcion3", "opcion4"},
            {"opcion1 a", "opcion2 b", "opcion3 c", "opcion4 d"},
            {"opcion1 e", "opcion2 f", "opcion3 g", "opcion4 h"}
    };
         //para el btnInicial3
         //preguntas
    static String[] preguntasInicial3 = {"pregunta 1", "pregunta 2", "pregunta 3"};
         //opciones
         //Orden de respuestas correctas: [2],[0],[3]
    static String[][] opcionesInicial3 = {
            {"opcion1", "opcion2", "opcion3", "opcion4"},
            {"opcion1 a", "opcion2 b", "opcion33 c", "opcion4 d"},
            {"opcion1 e", "opcion2 f", "opcion3 g", "opcion4 h"}
    };

        //para el btnIntermedio1
            //preguntas
    static String[] preguntasIntermedio1 = {"¿Cual red social se utiliza solo para subir imagenes y videos?", "pregunta 2", "pregunta 3"};
            //opciones
            // Orden de respuestas correctas: [2],[2],[0]
    static String[][] opcionesIntermedio1 = {
            {"facebook", "gmail", "twitter", "instagram"},
            {"opcion1", "opcion2", "opcion3", "opcion4"},
            {"opcion1 a", "opcion2 b", "opcion3 c", "opcion4 d"}
    };
        //para el btnIntermedio2
            //preguntas
    static String[] preguntasIntermedio2 = {"pregunta 1", "pregunta 2", "pregunta 3"};
            //opciones
            //Orden de respuestas correctas: [0],[1],[0]
    static String[][] opcionesIntermedio2 = {
            {"opcion1", "opcion2", "opcion3", "opcion4"},
            {"opcion1 a", "opcion2 b", "opcion3 c", "opcion4 d"},
            {"opcion1 e", "opcion2 f", "opcion3 g", "opcion4 h"}
    };
        //para el btnIntermedio3
            //preguntas
    static String[] preguntasIntermedio3 = {"pregunta 1", "pregunta 2", "pregunta 3"};
            //opciones
            //Orden de respuestas correctas: [3],[2],[3]
    static String[][] opcionesIntermedio3 = {
            {"opcion1", "opcion2", "opcion3", "opcion4"},
            {"opcion1 a", "opcion2 b", "opcion33 c", "opcion4 d"},
            {"opcion1 e", "opcion2 f", "opcion3 g", "opcion4 h"}
    };


        //para el btnAvanzado1
            //preguntas
    static String[] preguntasAvanzado1 = {"pregunta Avanzado 1", "pregunta Avanzado 2", "pregunta Avanzado 3"};
            //opciones
            // Orden de respuestas correctas: [3],[1],[2]
    static String[][] opcionesAvanzado1 = {
            {"Avanzado 1", "Avanzado 2", "Avanzado 3", "Avanzado 4"},
            {"Avanzado opcion1", "Avanzado opcion2", "Avanzado opcion3", "Avanzado opcion4"},
            {"Avanzado opcion1 a", "Avanzado opcion2 b", "Avanzado opcion3 c", "Avanzado opcion4 d"}
    };
        //para el btnAvanzado2
            //preguntas
    static String[] preguntasAvanzado2 = {"Avanzado 2", "Avanzado 2", "Avanzado 2"};
            //opciones
            //Orden de respuestas correctas: [0],[2],[3]
    static String[][] opcionesAvanzado2 = {
            {"opcion1", "opcion2", "opcion3", "opcion4"},
            {"opcion1 a", "opcion2 b", "opcion3 c", "opcion4 d"},
            {"opcion1 e", "opcion2 f", "opcion3 g", "opcion4 h"}
    };
        //para el btnIntermedio3
            //preguntas
    static String[] preguntasAvanzado3 = {"Avanzado 3", "Avanzado 3", "Avanzado 3"};
            //opciones
            //Orden de respuestas correctas: [3],[2],[0]
    static String[][] opcionesAvanzado3 = {
            {"opcion1", "opcion2", "opcion3", "opcion4"},
            {"opcion1 a", "opcion2 b", "opcion33 c", "opcion4 d"},
            {"opcion1 e", "opcion2 f", "opcion3 g", "opcion4 h"}
    };

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_juego_opciones);

        //para el almacenamiento de logros conseguidos
        context = this;
        logros = getSharedPreferences("logrosConseguidos", 0);


        //creando toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar1);
        setSupportActionBar(toolbar);
        //para poner boton atras
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intPuntaje = 0;
        txtPuntaje = (TextView) findViewById(R.id.txtPuntaje);

        pregunta = (TextView) findViewById(R.id.txtPregunta);

        btnOpcion_1 = (Button) findViewById(R.id.btnOpcion1);
        btnOpcion_2 = (Button) findViewById(R.id.btnOpcion2);
        btnOpcion_3 = (Button) findViewById(R.id.btnOpcion3);
        btnOpcion_4 = (Button) findViewById(R.id.btnOpcion4);

        imgResultado = (ImageView) findViewById(R.id.imgResultado);
        imageLogro = (ImageView) findViewById(R.id.imageLogro);

        //----TIPOGRAFIA----
        //cargando ruta
        final String fontPach = "fonts/century-gothic.ttf";
        //cargando fuente
        final Typeface tf = Typeface.createFromAsset(getAssets(), fontPach);
        //----TIPOGRAFIA----
        pregunta.setTypeface(tf);
        btnOpcion_1.setTypeface(tf);
        btnOpcion_2.setTypeface(tf);
        btnOpcion_3.setTypeface(tf);
        btnOpcion_4.setTypeface(tf);


        //capturando eleccion
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        if(extra != null){
            election = extra.getString("ELECCION");
        }

        actualizarContenido();
    }

    private void actualizarContenido() {
        //si la eleccion es igual a alguna categoria perteneciente al nivel 1
        if(election.equals("btnInicial1") || election.equals("btnInicial2") || election.equals("btnInicial3")) {
            // Se da el estilo de botón predeterminado a todos los botones
            btnOpcion_1.setBackgroundColor(Color.parseColor("#DA251D"));
            btnOpcion_2.setBackgroundColor(Color.parseColor("#e35d19"));
            btnOpcion_3.setBackgroundColor(Color.parseColor("#D9D207"));
            btnOpcion_4.setBackgroundColor(Color.parseColor("#BADA1C"));

            //se carga el contenido de la pregunta y las opciones dependiendo de donde he ingresado yo
            if (election.equals("btnInicial1")) {
                inicial1(); //cargo el siguiente contenido
            } else if(election.equals("btnInicial2")) {
                inicial2(); //cargo el siguiente contenido
            } else if(election.equals("btnInicial3")) {
                inicial3(); //cargo el siguiente contenido
            }
        } else if(election.equals("btnIntermedio1") || election.equals("btnIntermedio2") || election.equals("btnIntermedio3")) {
            // Se da el estilo de botón predeterminado a todos los botones
            btnOpcion_1.setBackgroundColor(Color.parseColor("#007CC3"));
            btnOpcion_2.setBackgroundColor(Color.parseColor("#75C5F0"));
            btnOpcion_3.setBackgroundColor(Color.parseColor("#4DB4BB"));
            btnOpcion_4.setBackgroundColor(Color.parseColor("#007CC3"));

            //se carga el contenido de la pregunta y las opciones dependiendo de donde he ingresado yo
            if (election.equals("btnIntermedio1")) {
                intermedio1(); //cargo el siguiente contenido
            } else if(election.equals("btnIntermedio2")) {
                intermedio2(); //cargo el siguiente contenido
            } else if(election.equals("btnIntermedio3")) {
                intermedio3(); //cargo el siguiente contenido
            }
        } else if(election.equals("btnAvanzado1") || election.equals("btnAvanzado2") || election.equals("btnAvanzado3")) {
            // Se da el estilo de botón predeterminado a todos los botones
            btnOpcion_1.setBackgroundColor(Color.parseColor("#DD137B"));
            btnOpcion_2.setBackgroundColor(Color.parseColor("#C985A3"));
            btnOpcion_3.setBackgroundColor(Color.parseColor("#974578"));
            btnOpcion_4.setBackgroundColor(Color.parseColor("#DD137B"));

            //se carga el contenido de la pregunta y las opciones dependiendo de donde he ingresado yo
            if (election.equals("btnAvanzado1")) {
                avanzado1(); //cargo el siguiente contenido
            } else if(election.equals("btnAvanzado2")) {
                avanzado2(); //cargo el siguiente contenido
            } else if(election.equals("btnAvanzado3")) {
                avanzado3(); //cargo el siguiente contenido
            }
        }

    }


    private void avanzado3() {
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasAvanzado3[0]);

            btnOpcion_1.setText(opcionesAvanzado3[0][0]);
            btnOpcion_2.setText(opcionesAvanzado3[0][1]);
            btnOpcion_3.setText(opcionesAvanzado3[0][2]);
            btnOpcion_4.setText(opcionesAvanzado3[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasAvanzado3[1]);

            btnOpcion_1.setText(opcionesAvanzado3[1][0]);
            btnOpcion_2.setText(opcionesAvanzado3[1][1]);
            btnOpcion_3.setText(opcionesAvanzado3[1][2]);
            btnOpcion_4.setText(opcionesAvanzado3[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasAvanzado3[2]);

            btnOpcion_1.setText(opcionesAvanzado3[2][0]);
            btnOpcion_2.setText(opcionesAvanzado3[2][1]);
            btnOpcion_3.setText(opcionesAvanzado3[2][2]);
            btnOpcion_4.setText(opcionesAvanzado3[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();
        }
    }

    private void avanzado2() {
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasAvanzado2[0]);

            btnOpcion_1.setText(opcionesAvanzado2[0][0]);
            btnOpcion_2.setText(opcionesAvanzado2[0][1]);
            btnOpcion_3.setText(opcionesAvanzado2[0][2]);
            btnOpcion_4.setText(opcionesAvanzado2[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasAvanzado2[1]);

            btnOpcion_1.setText(opcionesAvanzado2[1][0]);
            btnOpcion_2.setText(opcionesAvanzado2[1][1]);
            btnOpcion_3.setText(opcionesAvanzado2[1][2]);
            btnOpcion_4.setText(opcionesAvanzado2[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasAvanzado2[2]);

            btnOpcion_1.setText(opcionesAvanzado2[2][0]);
            btnOpcion_2.setText(opcionesAvanzado2[2][1]);
            btnOpcion_3.setText(opcionesAvanzado2[2][2]);
            btnOpcion_4.setText(opcionesAvanzado2[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();
        }
    }

    //contenido de la categoria 1 nivel inicial
    public void avanzado1(){
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasAvanzado1[0]);

            btnOpcion_1.setText(opcionesAvanzado1[0][0]);
            btnOpcion_2.setText(opcionesAvanzado1[0][1]);
            btnOpcion_3.setText(opcionesAvanzado1[0][2]);
            btnOpcion_4.setText(opcionesAvanzado1[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasAvanzado1[1]);

            btnOpcion_1.setText(opcionesAvanzado1[1][0]);
            btnOpcion_2.setText(opcionesAvanzado1[1][1]);
            btnOpcion_3.setText(opcionesAvanzado1[1][2]);
            btnOpcion_4.setText(opcionesAvanzado1[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasAvanzado1[2]);

            btnOpcion_1.setText(opcionesAvanzado1[2][0]);
            btnOpcion_2.setText(opcionesAvanzado1[2][1]);
            btnOpcion_3.setText(opcionesAvanzado1[2][2]);
            btnOpcion_4.setText(opcionesAvanzado1[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();

        }
    }


    private void intermedio3() {
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasIntermedio1[0]);

            btnOpcion_1.setText(opcionesIntermedio3[0][0]);
            btnOpcion_2.setText(opcionesIntermedio3[0][1]);
            btnOpcion_3.setText(opcionesIntermedio3[0][2]);
            btnOpcion_4.setText(opcionesIntermedio3[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasIntermedio3[1]);

            btnOpcion_1.setText(opcionesIntermedio3[1][0]);
            btnOpcion_2.setText(opcionesIntermedio3[1][1]);
            btnOpcion_3.setText(opcionesIntermedio3[1][2]);
            btnOpcion_4.setText(opcionesIntermedio3[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasIntermedio3[2]);

            btnOpcion_1.setText(opcionesIntermedio3[2][0]);
            btnOpcion_2.setText(opcionesIntermedio3[2][1]);
            btnOpcion_3.setText(opcionesIntermedio3[2][2]);
            btnOpcion_4.setText(opcionesIntermedio3[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();
        }
    }

    private void intermedio2() {
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasIntermedio2[0]);

            btnOpcion_1.setText(opcionesIntermedio2[0][0]);
            btnOpcion_2.setText(opcionesIntermedio2[0][1]);
            btnOpcion_3.setText(opcionesIntermedio2[0][2]);
            btnOpcion_4.setText(opcionesIntermedio2[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasIntermedio2[1]);

            btnOpcion_1.setText(opcionesIntermedio2[1][0]);
            btnOpcion_2.setText(opcionesIntermedio2[1][1]);
            btnOpcion_3.setText(opcionesIntermedio2[1][2]);
            btnOpcion_4.setText(opcionesIntermedio2[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasIntermedio2[2]);

            btnOpcion_1.setText(opcionesIntermedio2[2][0]);
            btnOpcion_2.setText(opcionesIntermedio2[2][1]);
            btnOpcion_3.setText(opcionesIntermedio2[2][2]);
            btnOpcion_4.setText(opcionesIntermedio2[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();
        }
    }

    //contenido de la categoria 1 nivel inicial
    public void intermedio1(){
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasInicial1[0]);

            btnOpcion_1.setText(opcionesIntermedio1[0][0]);
            btnOpcion_2.setText(opcionesIntermedio1[0][1]);
            btnOpcion_3.setText(opcionesIntermedio1[0][2]);
            btnOpcion_4.setText(opcionesIntermedio1[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasInicial1[1]);

            btnOpcion_1.setText(opcionesIntermedio1[1][0]);
            btnOpcion_2.setText(opcionesIntermedio1[1][1]);
            btnOpcion_3.setText(opcionesIntermedio1[1][2]);
            btnOpcion_4.setText(opcionesIntermedio1[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasInicial1[2]);

            btnOpcion_1.setText(opcionesIntermedio1[2][0]);
            btnOpcion_2.setText(opcionesIntermedio1[2][1]);
            btnOpcion_3.setText(opcionesIntermedio1[2][2]);
            btnOpcion_4.setText(opcionesIntermedio1[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();

        }
    }


    private void inicial3() {
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasInicial3[0]);

            btnOpcion_1.setText(opcionesInicial3[0][0]);
            btnOpcion_2.setText(opcionesInicial3[0][1]);
            btnOpcion_3.setText(opcionesInicial3[0][2]);
            btnOpcion_4.setText(opcionesInicial3[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasInicial3[1]);

            btnOpcion_1.setText(opcionesInicial3[1][0]);
            btnOpcion_2.setText(opcionesInicial3[1][1]);
            btnOpcion_3.setText(opcionesInicial3[1][2]);
            btnOpcion_4.setText(opcionesInicial3[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasInicial3[2]);

            btnOpcion_1.setText(opcionesInicial3[2][0]);
            btnOpcion_2.setText(opcionesInicial3[2][1]);
            btnOpcion_3.setText(opcionesInicial3[2][2]);
            btnOpcion_4.setText(opcionesInicial3[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();
        }
    }

    private void inicial2() {
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasInicial2[0]);

            btnOpcion_1.setText(opcionesInicial2[0][0]);
            btnOpcion_2.setText(opcionesInicial2[0][1]);
            btnOpcion_3.setText(opcionesInicial2[0][2]);
            btnOpcion_4.setText(opcionesInicial2[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasInicial2[1]);

            btnOpcion_1.setText(opcionesInicial2[1][0]);
            btnOpcion_2.setText(opcionesInicial2[1][1]);
            btnOpcion_3.setText(opcionesInicial2[1][2]);
            btnOpcion_4.setText(opcionesInicial2[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasInicial2[2]);

            btnOpcion_1.setText(opcionesInicial2[2][0]);
            btnOpcion_2.setText(opcionesInicial2[2][1]);
            btnOpcion_3.setText(opcionesInicial2[2][2]);
            btnOpcion_4.setText(opcionesInicial2[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();
        }
    }

    //contenido de la categoria 1 nivel inicial
    public void inicial1(){
        //contenido de la pregunta 1
        if(preguntaNumero == 0){
            pregunta.setText(preguntasInicial1[0]);

            btnOpcion_1.setText(opcionesInicial1[0][0]);
            btnOpcion_2.setText(opcionesInicial1[0][1]);
            btnOpcion_3.setText(opcionesInicial1[0][2]);
            btnOpcion_4.setText(opcionesInicial1[0][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 2
        if(preguntaNumero == 1){
            pregunta.setText(preguntasInicial1[1]);

            btnOpcion_1.setText(opcionesInicial1[1][0]);
            btnOpcion_2.setText(opcionesInicial1[1][1]);
            btnOpcion_3.setText(opcionesInicial1[1][2]);
            btnOpcion_4.setText(opcionesInicial1[1][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //contenido de la pregunta 3
        if(preguntaNumero == 2){
            pregunta.setText(preguntasInicial1[2]);

            btnOpcion_1.setText(opcionesInicial1[2][0]);
            btnOpcion_2.setText(opcionesInicial1[2][1]);
            btnOpcion_3.setText(opcionesInicial1[2][2]);
            btnOpcion_4.setText(opcionesInicial1[2][3]);

            btnOpcion_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaCorrecta(btnOpcion_1);
                }
            });
            btnOpcion_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_2);
                }
            });
            btnOpcion_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_3);
                }
            });
            btnOpcion_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respuestaIncorrecta(btnOpcion_4);
                }
            });
        }
        //mensaje de resultado
        if(preguntaNumero == 3) {
            resultadoFinal();

        }
    }

    private void resultadoFinal() {
        btnOpcion_1.setVisibility(View.INVISIBLE);
        btnOpcion_2.setVisibility(View.INVISIBLE);
        btnOpcion_3.setVisibility(View.INVISIBLE);
        btnOpcion_4.setVisibility(View.INVISIBLE);
        //si el usuario atino en las 3 preguntas
        if (intPuntaje == 3) {
            //para guardar el logro una ves conseguido
            //---------------LOGRO---------------
                //INICIAL
            if (election.equals("btnInicial1")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroInicial1", 1);
                editor.commit();
            }
            if (election.equals("btnInicial2")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroInicial2", 1);
                editor.commit();
            }
            if (election.equals("btnInicial3")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroInicial3", 1);
                editor.commit();
            }
                //INTERMEDIO
            if (election.equals("btnIntermedio1")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroIntermedio1", 1);
                editor.commit();
            }
            if (election.equals("btnIntermedio2")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroIntermedio2", 1);
                editor.commit();
            }
            if (election.equals("btnIntermedio3")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroIntermedio3", 1);
                editor.commit();
            }
                //AVANSADO
            if (election.equals("btnAvanzado1")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroAvanzado1", 1);
                editor.commit();
            }
            if (election.equals("btnAvanzado2")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroAvanzado2", 1);
                editor.commit();
            }
            if (election.equals("btnAvanzado3")){
                SharedPreferences.Editor editor = logros.edit();
                editor.putInt("btnLogroAvanzado3", 1);
                editor.commit();
            }
            //---------------LOGRO--------------

            imageLogro.setImageResource(android.R.drawable.star_big_on);
            new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    pregunta.setText("¡FELICIDADES!, has acertado en todas las preguntas y has conseguido un logro \nSeras redirigido al menu de los minijuegos en: " + (millisUntilFinished / 1000));
                }

                @Override
                //me voy a otro activity
                public void onFinish() {
                    Intent intent = new Intent(Juego.this, MiniJuegoActivity.class);
                    startActivity(intent);
                }
            }.start();
            //si no atino en las 3 preguntas
        } else {
            new CountDownTimer(5000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    pregunta.setText("Parece que no has logrado llegar a los 3 acierto vuelve a intentarlo la propcima ves\nSeras redirigido al menu de los minijuegos en: " + (millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                    Intent intent = new Intent(Juego.this, MiniJuegoActivity.class);
                    startActivity(intent);
                }
            }.start();

        }
    }

    private void respuestaCorrecta(Button botonCorrecto) {
        if(puedoPulsarRespuesta == 1) {
            puedoPulsarRespuesta = 0;
            intPuntaje = intPuntaje + 1;
            txtPuntaje.setText(intPuntaje + "/ 3");

            imgResultado.setImageResource(R.drawable.correcto);
            imgResultado.setVisibility(View.VISIBLE);
            botonCorrecto.setBackgroundColor(Color.parseColor("#4DBB58"));
            siguientePregunta();
        }
    }

    private void respuestaIncorrecta(Button botonIncorrecto) {
        if(puedoPulsarRespuesta == 1) {
            puedoPulsarRespuesta = 0;
            imgResultado.setImageResource(R.drawable.incorrecto);
            imgResultado.setVisibility(View.VISIBLE);
            botonIncorrecto.setBackgroundColor(Color.parseColor("#B11B1B"));
            siguientePregunta();
        }
    }

    private void siguientePregunta() {
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //mostrar mensaje dicieno: "pasando a la siguiente pregunta en: -tiempo-"
                if(preguntaNumero == 3){
                    //me voy a otro activity
                    pregunta.setText("Cargando resultado en: " + (millisUntilFinished/1000));
                } else{
                    pregunta.setText("Pregunta siguiente en: " + (millisUntilFinished/1000));
                }
            }

            @Override
            public void onFinish() {
                //PASANDO A LA SIGUIENTE PREGUNTA
                    //vuelvo a hacer el resultado invisible
                imgResultado.setVisibility(View.INVISIBLE);
                    //para pasar a la siguiente pregunta
                preguntaNumero = preguntaNumero + 1;
                    //vuelvo a permitir volver a precionar sobre una opcion
                puedoPulsarRespuesta = 1;
                    //vuelvo a cargar el contenido
                actualizarContenido();
            }
        }.start();
    }
    @Override public boolean onCreateOptionsMenu(android.view.Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_tutorial, mimenu);

        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id = opcion_menu.getItemId();

        switch (id){
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }
}
