package com.example.crudjavafxhorror;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HorrorCharacterVaultApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HorrorCharacterVaultApplication.class.getResource("root-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Horror Vault");
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(750);
        stage.setResizable(false);
        stage.show();

    }

}
