package com.nordiws.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    // Declarando as variaveis do view do projeto
    TextView displayView;

    Button zeroBtn;
    Button oneBtn;
    Button twoBtn;
    Button threeBtn;
    Button fourBtn;
    Button fiveBtn;
    Button sixBtn;
    Button sevenBtn;
    Button eightBtn;
    Button nineBtn;
    Button dotBtn;

    Button equalBtn;
    Button clearBtn;
    Button backSpaceBtn;

    Button plusBtn;
    Button minusBtn;
    Button multiplicationBtn;
    Button divisionBtn;
    Button reminderBtn;

    // variáveis de controle das equações.
    Float valueOne, valueTwo;
    String currentEquation;
    Boolean calculatorState;
    Boolean isSecondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciando os botões
        displayView = findViewById(R.id.displayView);
        displayView.setText("0");
        calculatorState = false;
        isSecondValue = false;

        zeroBtn = findViewById(R.id.zeroBtn);
        oneBtn = findViewById(R.id.oneBtn);
        twoBtn = findViewById(R.id.twoBtn);
        threeBtn = findViewById(R.id.threeBtn);
        fourBtn = findViewById(R.id.fourBtn);
        fiveBtn = findViewById(R.id.fiveBtn);
        sixBtn = findViewById(R.id.sixBtn);
        sevenBtn = findViewById(R.id.sevenBtn);
        eightBtn = findViewById(R.id.eightBtn);
        nineBtn = findViewById(R.id.nineBtn);
        dotBtn = findViewById(R.id.dotBtn);

        equalBtn = findViewById(R.id.equalBtn);
        clearBtn = findViewById(R.id.clearBtn);
        backSpaceBtn = findViewById(R.id.backSpaceBtn);

        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        multiplicationBtn = findViewById(R.id.multiplicationBtn);
        divisionBtn = findViewById(R.id.divisionBtn);
        reminderBtn = findViewById(R.id.reminderBtn);

        // Configuração dos listeners para os números
        zeroBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "0");
        });
        oneBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "1");
        });
        twoBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "2");
        });
        threeBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "3");
        });
        fourBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "4");
        });
        fiveBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "5");
        });
        sixBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "6");
        });
        sevenBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "7");
        });
        eightBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "8");
        });
        nineBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(displayView.getText() + "9");
        });
        dotBtn.setOnClickListener(v -> {
            if (displayView != null) {
                displayView.setText(displayView.getText() + ".");
            } else {
                displayView.setText("0.");
            }

        });

        // Configuração dos listeners para limpar e deletar um caractere
        clearBtn.setOnClickListener(v -> {
            displayView.setText("0");
            calculatorState = false;
            currentEquation = null;
        });
        backSpaceBtn.setOnClickListener(v -> {
            StringBuffer sb = new StringBuffer(displayView.getText());
            if(sb.length() <= 1){
                displayView.setText("0");
                calculatorState = false;
            } else {
                sb.deleteCharAt(sb.length()-1);
                displayView.setText(sb);
            }

        });

        //Configuração dos listeners das equações
        plusBtn.setOnClickListener(v -> {
            valueOne = Float.parseFloat(displayView.getText().toString());
            currentEquation = "plus";
            displayView.setText(displayView.getText() + " +");
            calculatorState = false;
        });
        minusBtn.setOnClickListener(v -> {
            valueOne = Float.parseFloat(displayView.getText().toString());
            currentEquation = "minus";
            displayView.setText(displayView.getText() + " -");
            calculatorState = false;
        });
        multiplicationBtn.setOnClickListener(v -> {
            valueOne = Float.parseFloat(displayView.getText().toString());
            currentEquation = "multiplication";
            displayView.setText(displayView.getText() + " x");
            calculatorState = false;
        });
        divisionBtn.setOnClickListener(v -> {
            valueOne = Float.parseFloat(displayView.getText().toString());
            currentEquation = "division";
            displayView.setText(displayView.getText() + " /");
            calculatorState = false;
        });
        reminderBtn.setOnClickListener(v -> {
            valueOne = Float.parseFloat(displayView.getText().toString());
            currentEquation = "reminder";
            displayView.setText(displayView.getText() + " %");
            calculatorState = false;
        });

        // Configuração do listener de resultado e cálculo das equações
        equalBtn.setOnClickListener(v -> {
            // Verifica se não foi inserido nenhum valor
            if(valueOne == null){
                displayView.setText("0");
                resetState();
                return;
            }

            // verifica se não foi inserido o segundo valor
            if (displayView.getText().toString().matches("^\\d+(\\.\\d+)*$")){
                valueTwo = Float.parseFloat(displayView.getText().toString());
            } else {
                valueTwo = 0f;
            }

            switch (currentEquation){
                case "plus":
                    displayView.setText(String.valueOf((int) (valueOne + valueTwo)));
                    resetState();
                    break;
                case "minus":
                    displayView.setText(String.valueOf((int) (valueOne - valueTwo)));
                    resetState();
                    break;
                case "multiplication":
                    displayView.setText(String.valueOf((int) (valueOne * valueTwo)));
                    resetState();
                    break;
                case "division":
                    displayView.setText(String.valueOf(valueOne / valueTwo));
                    resetState();
                    break;
                case  "reminder":
                    displayView.setText(String.valueOf(valueOne % valueTwo));
                    resetState();
                    break;
                default:
                    displayView.setText("0");
                    resetState();
            }
        });
    }

    private void resetState(){
        currentEquation = null;
        calculatorState = false;
        valueOne = null;
        valueTwo = null;
    }
}