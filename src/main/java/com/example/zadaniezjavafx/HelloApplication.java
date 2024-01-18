package com.example.zadaniezjavafx;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {


        Text text1 = new Text("Email");
        Text text2 = new Text("Password");
        TextField textField1 = new TextField();
        PasswordField textField2 = new PasswordField();
        Text pwstrength = new Text("Password strength");
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0.0);

        textField1.setOnKeyTyped(event->{
            textField1.setStyle("-fx-text-fill:black");
            String text = textField1.getText();
        });


        textField2.setOnKeyTyped(event->{
            textField2.setStyle("-fx-text-fill:black");
            String pw = textField2.getText();


            double pro = (double)pw.length()/8;
            progressBar.setProgress(pro);

            if (pro < 0.40) {
                progressBar.setStyle("-fx-accent:red");
            } else if (pro < 0.75) {
                progressBar.setStyle("-fx-accent:orange");
            } else if (pro < 0.95) {
                progressBar.setStyle("-fx-accent:yellow");
            } else {
                progressBar.setStyle("-fx-accent:green");
            }
        });


        Button button1 = new Button("Submit");
        Button button2 = new Button("Clear");


        button1.setOnMouseClicked(event->{
            String text = textField1.getText();
            String pw = textField2.getText();

            // kod sprawdzający poprawność e-maila
            if (!text.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
                System.out.println("Podany e-mail nie jest poprawny:  " + text);
                textField1.setStyle("-fx-text-fill:red");

                } else {
                System.out.println("Podany e-mail nie jest poprawny:  " + text);
                textField1.setStyle("-fx-text-fill:green");
            }
            if (pw.length()<8) {
                System.out.println("Podane haslo jest zbyt krotkie:  " + pw);
                textField2.setStyle("-fx-text-fill:orange");
            } else {
                System.out.println("Podane haslo jest poprawne:  " + pw);
                textField2.setStyle("-fx-text-fill:green");
            }

        });

        button2.setOnMouseClicked(event->{
            textField1.clear();
            textField2.clear();
            textField1.setStyle("-fx-text-fill:black");
            textField2.setStyle("-fx-text-fill:black");
            progressBar.setProgress(0.0);
        });


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(550, 300);
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setVgap(8);
        gridPane.setHgap(8);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(pwstrength, 0, 2);
        gridPane.add(progressBar, 1, 2);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);



        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        text1.setStyle("-fx-font: normal bold 20px 'serif' ");
        text2.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");

        Scene scene = new Scene(gridPane);
        stage.setTitle("CSS Example");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}