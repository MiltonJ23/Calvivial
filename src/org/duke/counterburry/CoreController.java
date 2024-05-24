/*
 * This file is part of the marquis valois distribution
 * Copyright (c) 2024 Acheron Systems.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */


package org.duke.counterburry;

import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;





public class CoreController implements Initializable{

//déclarons d'abord les composants fxml
@FXML
private Button ConfirmButton;
@FXML
private Button CancelButton;
@FXML
private Button ComputeButton;
@FXML
private Button ClearButton;
@FXML
private Button LogOutButton;
@FXML
private TextField NameField;
@FXML
private TextField Xfield;
@FXML
private TextField Yfield;
@FXML
private TextArea Display1Area;
@FXML
private TextArea Display2Area;
@FXML
private ComboBox OperandField;
@FXML
private AnchorPane pane;

private Stage primaryStage;

//on vient de finir de déclarer les différents composants de notre FXML


  public  void initialize(URL lim,ResourceBundle bundle){
    //on set d'abord le contenu de la ComboBox
    final ObservableList<String> avalaibleOperation =
             FXCollections.observableArrayList("+","-","/","x","%");
     OperandField.setItems(avalaibleOperation);
     //On vient de finir de configurer le contenu de la ComboBox

     //assurons nous que la taille de la page ne puisse pas être modifiée pendant le lancement
     pane.setMaxSize(874,622);
     pane.setMinSize(874,622);
     //la taille minimale et max assure que le pane ne sera pas modifiable

     //envoyons un léger message convivial dans le premier TextArea
     Display1Area.setPromptText("Bienvenue Visiteur !\n Vous devez entrer votre Nom d'utilisateur ,ensuite\n vous pouvez effectuer vos calculs"+
     "dans la Computation Area! \n Hope U will enjoy it!!!");
}

    @FXML
    public void ClearAllArea(MouseEvent event){
      //nettoyons les différents champs de saisie
          Display1Area.setText("");
          Display2Area.setText("");
          Yfield.setText("");
          Xfield.setText("");
          NameField.setText("");
    };

    @FXML
    public void Compute(MouseEvent event){

      if(!(Xfield.getText().isEmpty() && Yfield.getText().isEmpty() && OperandField.getSelectionModel().isEmpty())){
         String operator = String.valueOf(OperandField.getSelectionModel().getSelectedItem());
         switch (operator) {
           case "+" :
               float result = Float.valueOf(Xfield.getText()) + Float.valueOf(Yfield.getText()) ;
               String v = Display2Area.getText();
               Display2Area.setText( v +"\n\n "+ Xfield.getText()+" "+ operator+" "+ Yfield.getText() + "  = "+ String.valueOf(result));
               break;
           case "x" :
             float result1 = Float.valueOf(Xfield.getText()) * Float.valueOf(Yfield.getText()) ;
             String v1 = Display2Area.getText();
             Display2Area.setText( v1 +"\n\n "+ Xfield.getText()+" "+ operator+" "+ Yfield.getText() + "  = "+ String.valueOf(result1));
             break;
           case "-" :
             float result2 = Float.valueOf(Xfield.getText()) - Float.valueOf(Yfield.getText()) ;
             String v2 = Display2Area.getText();
             Display2Area.setText( v2 +"\n\n "+ Xfield.getText()+" "+ operator+" "+ Yfield.getText() + "  = "+ String.valueOf(result2));
             break;
           case "/":
             float result3 = Float.valueOf(Xfield.getText()) / Float.valueOf(Yfield.getText()) ;
             String v3 = Display2Area.getText();
             Display2Area.setText( v3 +"\n\n "+ Xfield.getText()+" "+ operator+" "+ Yfield.getText() + "  = "+ String.valueOf(result3));
             break;
           case "%" :
             float result4 = Float.valueOf(Xfield.getText()) %Float.valueOf(Yfield.getText()) ;
             String v4 = Display2Area.getText();
             Display2Area.setText( v4 +"\n\n "+ Xfield.getText()+" "+ operator+" "+ Yfield.getText() + "  = "+ String.valueOf(result4));
             break;
         };
     }else{
       String v = Display2Area.getText();
       Display2Area.setText( v +"\n\n  Désolé , mais vous devez au préalable choisir et remplir tous les champs");
     };

   };

   @FXML
   public void Confirm(MouseEvent event){
     String name = NameField.getText();
     Display1Area.setText("Bienvenue Mr/Mme " + name +" dans ce programme , vous pouvez effectuer un calcul et le résultat s'affichera plus bas \n\n" );
   }

   @FXML
   public void Cancel(MouseEvent event){
     Display1Area.setText("");
     NameField.setText("");
   }

   @FXML
   public void LogOut(MouseEvent event){
     this.primaryStage.close();
   }

   public void SetPrimaryStage(Stage stage){
     this.primaryStage=stage;
   }



}
