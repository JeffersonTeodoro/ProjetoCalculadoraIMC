import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class IMC extends Application {

    @Override
    public void start(Stage palco) {
        // Etiquetas para os campos de entrada
        Label etiquetaPeso = new Label("Peso");
        etiquetaPeso.getStyleClass().add("label-peso");
        Label etiquetaAltura = new Label("Altura");
        etiquetaAltura.getStyleClass().add("label-altura");


        // Campos de texto para entrada de dados
        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em kg");
        campoPeso.getStyleClass().add("campo-peso");

        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em metros");
        campoAltura.getStyleClass().add("campo-altura");

        // Label para mostrar o resultado do IMC
        Label etiquetaResultado = new Label();

        // Botão para calcular p IMC
        Button botaoCalcular = new Button("Calcular IMC");
        botaoCalcular.getStyleClass().add("botao-calcular");


        botaoCalcular.setOnAction(e -> {
            try {
                double peso = Double.parseDouble(campoPeso.getText().replace(',', '.'));
                double altura = Double.parseDouble(campoAltura.getText().replace(',', '.'));

                double imc = peso / (altura * altura);
                etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
                etiquetaResultado.getStyleClass().add("label-resultado");
            }catch (NumberFormatException ex) {
                etiquetaResultado.setText("Por favor, insira valores válidos para peso e altura.");
            }
        });

        // Layout vertical
        VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        // Cena e palco
        Scene cena = new Scene(layout, 350,250);
        cena.getStylesheets().add("file:///C:/ProjetoCalculadoraIMC/CalculadoraIMC/src/Style.css");
        palco.setTitle("Calculadora de IMC");
        palco.setScene(cena);
        palco.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
