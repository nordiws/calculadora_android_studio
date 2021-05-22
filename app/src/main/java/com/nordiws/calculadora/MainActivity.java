package com.nordiws.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
    Float valueOne, valueTwo = null;
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
            displayView.setText(String.format("%s0", displayView.getText()));
        });
        oneBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s1", displayView.getText()));
        });
        twoBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s2", displayView.getText()));
        });
        threeBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s3", displayView.getText()));
        });
        fourBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s4", displayView.getText()));
        });
        fiveBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s5", displayView.getText()));
        });
        sixBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s6", displayView.getText()));
        });
        sevenBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s7", displayView.getText()));
        });
        eightBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s8", displayView.getText()));
        });
        nineBtn.setOnClickListener(v -> {
            if (!calculatorState) {
                displayView.setText("");
                calculatorState = true;
            }
            displayView.setText(String.format("%s9", displayView.getText()));
        });
        dotBtn.setOnClickListener(v -> {
            if (calculatorState) {
                displayView.setText(String.format("%s.", displayView.getText()));
            } else {
                displayView.setText("0.");
            }

        });

        // Configuração dos listeners para limpar e deletar um caractere
        clearBtn.setOnClickListener(v -> {
            displayView.setText("0");
            resetState();
        });
        backSpaceBtn.setOnClickListener(v -> {
            StringBuffer sb = new StringBuffer(displayView.getText());
            if (sb.length() <= 1) {
                displayView.setText("0");
                calculatorState = false;
            } else {
                sb.deleteCharAt(sb.length() - 1);
                displayView.setText(sb);
            }

        });

        //Configuração dos listeners das equações
        plusBtn.setOnClickListener(v -> {
            if (!isSecondValue) {
                valueOne = Float.parseFloat(displayView.getText().toString());
                currentEquation = "addition";
                displayView.setText(String.format("%s +", displayView.getText()));
                calculatorState = false;
                isSecondValue = true;
            } else {
                String testValueTwo = displayView.getText().toString();
                if (testValueTwo.matches("^\\d+(\\.\\d+)*$")) {
                    valueTwo = Float.parseFloat(testValueTwo);
                } else {
                    valueTwo = 0f;
                }
                valueOne = calculate(valueOne, valueTwo);
                displayView.setText(String.format("%s +", valueOne));
                valueTwo = null;
                calculatorState = false;
                currentEquation = "addition";
                displayView.setText(checkForDecimals(valueOne));
            }
        });
        minusBtn.setOnClickListener(v -> {
            if(!isSecondValue){
                valueOne = Float.parseFloat(displayView.getText().toString());
                currentEquation = "subtraction";
                displayView.setText(String.format("%s -", displayView.getText()));
                calculatorState = false;
                isSecondValue = true;
            } else {
                String testValueTwo = displayView.getText().toString();
                if (testValueTwo.matches("^\\d+(\\.\\d+)*$")) {
                    valueTwo = Float.parseFloat(testValueTwo);
                } else {
                    valueTwo = 0f;
                }
                valueOne = calculate(valueOne, valueTwo);
                displayView.setText(String.format("%s -", valueOne));
                valueTwo = null;
                calculatorState = false;
                currentEquation = "subtraction";
                displayView.setText(checkForDecimals(valueOne));
            }
        });
        multiplicationBtn.setOnClickListener(v -> {
            if(!isSecondValue){
                valueOne = Float.parseFloat(displayView.getText().toString());
                currentEquation = "multiplication";
                displayView.setText(String.format("%s x", displayView.getText()));
                calculatorState = false;
                isSecondValue = true;
            } else {
                String testValueTwo = displayView.getText().toString();
                if (testValueTwo.matches("^\\d+(\\.\\d+)*$")) {
                    valueTwo = Float.parseFloat(testValueTwo);
                } else {
                    valueTwo = 0f;
                }
                valueOne = calculate(valueOne, valueTwo);
                displayView.setText(String.format("%s x", valueOne));
                valueTwo = null;
                calculatorState = false;
                currentEquation = "multiplication";
                displayView.setText(checkForDecimals(valueOne));
            }
        });
        divisionBtn.setOnClickListener(v -> {
            if(!isSecondValue){
                valueOne = Float.parseFloat(displayView.getText().toString());
                currentEquation = "division";
                displayView.setText(String.format("%s ÷", displayView.getText()));
                calculatorState = false;
                isSecondValue = true;
            } else {
                String testValueTwo = displayView.getText().toString();
                if (testValueTwo.matches("^\\d+(\\.\\d+)*$")) {
                    valueTwo = Float.parseFloat(testValueTwo);
                } else {
                    valueTwo = 0f;
                }
                valueOne = calculate(valueOne, valueTwo);
                displayView.setText(String.format("%s ÷", valueOne));
                valueTwo = null;
                calculatorState = false;
                currentEquation = "division";
                displayView.setText(checkForDecimals(valueOne));
            }
        });
        reminderBtn.setOnClickListener(v -> {
            if(!isSecondValue){
                valueOne = Float.parseFloat(displayView.getText().toString());
                currentEquation = "reminder";
                displayView.setText(String.format("%s %%", displayView.getText()));
                calculatorState = false;
                isSecondValue = true;
            } else {
                String testValueTwo = displayView.getText().toString();
                if (testValueTwo.matches("^\\d+(\\.\\d+)*$")) {
                    valueTwo = Float.parseFloat(testValueTwo);
                } else {
                    valueTwo = 0f;
                }
                valueOne = calculate(valueOne, valueTwo);
                displayView.setText(String.format("%s %%", valueOne));
                valueTwo = null;
                calculatorState = false;
                currentEquation = "reminder";
                displayView.setText(checkForDecimals(valueOne));
            }
        });

        // Configuração do listener de resultado e cálculo das equações
        equalBtn.setOnClickListener(v -> {
            valueTwo = Float.parseFloat(displayView.getText().toString());
            displayView.setText(checkForDecimals(calculate(valueOne, valueTwo)));
            resetState();
        });
    }

    private float calculate(Float value1, Float value2) {

        float result;

        // Verifica se não foi inserido nenhum valor
        if (value1 == null) {
            return 0f;
        }

        // Verifica se não foi inserido o segundo valor
        if (value2 == null) {
            value2 = 0f;
        }

        // Efetua os calculos conforme a operação selecionada
        switch (currentEquation) {
            case "addition":
                result = value1 + value2;
                break;
            case "subtraction":
                result = value1 - value2;
                break;
            case "multiplication":
                result = value1 * value2;
                break;
            case "division":
                result = value1 / value2;
                break;
            case "reminder":
                result = value1 % value2;
                break;
            default:
                result = 0f;
        }
        return result;
    }

    // Reinicializa as variaveis de estado
    private void resetState() {
        currentEquation = null;
        calculatorState = false;
        valueOne = null;
        valueTwo = null;
        isSecondValue = false;
    }

    // Verifica se o resultado e um numero enteiro, converte ele para integer e devolve uma String
    private String checkForDecimals(float number) {
        int result;
        if (number % 1 == 0) {
            result = (int) number;
            return Integer.toString(result);
        }
            return String.valueOf(number);
    }
}