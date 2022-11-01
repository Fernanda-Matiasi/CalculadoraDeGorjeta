package com.udemy.calculadoranova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor         = findViewById(R.id.editValor);
        textPorcentagem   = findViewById(R.id.textPorcentagem);
        textGorjeta       = findViewById(R.id.textGorjeta);
        textTotal         = findViewById(R.id.textTotal);
        seekBarGorjeta   = findViewById(R.id.seekBarGorjeta);

        //Adicionar listener SeekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText( Math.round( porcentagem ) + " %" );
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        String valorResuperado = editValor.getText().toString();
        if( valorResuperado == null || valorResuperado.equals("") ){

            Toast.makeText(
                    getApplicationContext(),
                     "Digite o valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();

        }else{
            //Converter valor Double
            double valorDigitado = Double.parseDouble( valorResuperado );

            //Calcula a gorjeta total
            double gorjeta = valorDigitado * ( porcentagem/100 );
            double total = gorjeta + valorDigitado;

            //exibe a gorjeta e o total
            textGorjeta.setText( "R$ " + Math.round(gorjeta) );
            textTotal.setText( "R$ " + Math.round(total));
        }

    }
}