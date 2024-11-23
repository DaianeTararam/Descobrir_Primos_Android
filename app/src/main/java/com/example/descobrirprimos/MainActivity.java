/*
 *@author: Daiane Tararam
 *RA: 1110482322003
 */
package com.example.descobrirprimos;

import android.content.Intent;
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
    private EditText etNum1;
    private EditText etNum2;
    private TextView tvResposta;
    private Button btnPrimos;

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
        etNum1 = findViewById(R.id.etNum1);
        etNum1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etNum2 = findViewById(R.id.etNum2);
        etNum2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tvResposta = findViewById(R.id.tvResposta);
        tvResposta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnPrimos = findViewById(R.id.btnPrimos);
        btnPrimos.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnPrimos.setOnClickListener(op -> decobrirPrimos());

    }

    private void decobrirPrimos() {
        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());
        int maior = Math.max(num1, num2);
        int menor = Math.min(num1, num2);
        if (menor < 0 || maior > 50) {
            etNum1.setText("");
            etNum2.setText("");
            tvResposta.setText("ERRO: O número deve estar entre 0 e 50");
            reiniciar();
        }else{
            String resposta = getString(R.string.tvResposta);
            tvResposta.setText(resposta);
            for (int i = menor; i <= maior; i++) {
                boolean primo = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        primo = false;
                        break;
                    }
                }
                if (primo) {
                    tvResposta.append(" [" + i);
                    tvResposta.append("] ");
                }
            }
            tvResposta.append(".");
        }
    }
    public void reiniciar() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        this.finish();

    }
}