package com.example.calculatorajbm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Creo las variables
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonPlus, buttonMinus, buttonMult, buttonDiv, buttonResult, buttonDel;
    TextView tvNumber;
    double num1, num2;
    boolean isPlus, isMinus, isMul, isDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recojo los elementos de la interfaz y lo asigno a las variables
        tvNumber = findViewById(R.id.tvNumber);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMult = findViewById(R.id.buttonMult);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonResult = findViewById(R.id.buttonResult);
        buttonDel = findViewById(R.id.buttonDel);

        //Listener que obtiene el valor del boton y lo concatena con el texto ya recogido
        View.OnClickListener number = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                tvNumber.setText(tvNumber.getText().toString() + btn.getText().toString());

            }
        };


        // Asigno la funcion a cada boton numerico de la interfaz
        button0.setOnClickListener(number);
        button1.setOnClickListener(number);
        button2.setOnClickListener(number);
        button3.setOnClickListener(number);
        button4.setOnClickListener(number);
        button5.setOnClickListener(number);
        button6.setOnClickListener(number);
        button7.setOnClickListener(number);
        button8.setOnClickListener(number);
        button9.setOnClickListener(number);


        // Listener para el botón de sumar
        View.OnClickListener plus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(tvNumber.getText().toString());
                isPlus = true;
                tvNumber.setText("");  // Limpiar el campo para el segundo número
            }
        };
        buttonPlus.setOnClickListener(plus);

        // Listener para el botón de restar
        View.OnClickListener minus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(tvNumber.getText().toString());
                isMinus = true;
                tvNumber.setText("");
            }
        };
        buttonMinus.setOnClickListener(minus);

        // Listener para el botón de multiplicar
        View.OnClickListener mult = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(tvNumber.getText().toString());
                isMul = true;
                tvNumber.setText("");
            }
        };
        buttonMult.setOnClickListener(mult);

        // Listener para el botón de dividir
        View.OnClickListener div = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(tvNumber.getText().toString());
                isDiv = true;
                tvNumber.setText("");
            }
        };
        buttonDiv.setOnClickListener(div);

        // Listener para el boton del resultado, incluyendo las banderas que indican si se esta
        // realizando cierta operacion
        View.OnClickListener result = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2 = Integer.parseInt(tvNumber.getText().toString());

                if (isPlus) {
                    tvNumber.setText(String.valueOf(num1 + num2));
                    isPlus = false;  // Resetear la bandera
                }

                if (isMinus) {
                    tvNumber.setText(String.valueOf(num1 - num2));
                    isMinus = false;
                }

                if (isMul) {
                    tvNumber.setText(String.valueOf(num1 * num2));
                    isMul = false;
                }

                //Control in case of introducing 0
                if (isDiv) {
                    if (num2 != 0) {
                        tvNumber.setText(String.valueOf(num1 / num2));
                    } else {
                        tvNumber.setText("Error");
                    }
                    isDiv = false;
                }
        };
        };
        buttonResult.setOnClickListener(result);

    // Listener para el boton de limpiar C
    View.OnClickListener delete = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tvNumber.setText("");
        }
    };
    buttonDel.setOnClickListener(delete);

    }
}
