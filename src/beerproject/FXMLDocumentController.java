
package beerproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Henrique
 */
public class FXMLDocumentController implements Initializable {
    
    int counter = 0;
    String[] base = {null,"Pilsner","Lager","Ale","Wheat"};
    String[] ibu = {"0","10","30","50","70"};
    ObservableList obsIbu = FXCollections.observableArrayList(ibu);
    ObservableList obsBase = FXCollections.observableArrayList(base);
   
    
    @FXML
    private ComboBox<String> ddlBase,ddlIbu;
    
    @FXML
    private TextArea txtOut;
    
    @FXML
    private TextField txtName;
    
    @FXML 
    private CheckBox chkIPA;
    
    @FXML
    private Button btnExit, btnCalc, btnNext, btnPrev, btnAdd, btnRem;
    
    @FXML
    
    private void find(MouseEvent event) {
        if(txtName.getText().isEmpty()){
            if(ddlBase.getSelectionModel().getSelectedItem() == null){
                if(Integer.parseInt(ddlIbu.getSelectionModel().getSelectedItem()) == 0){
                    if(!chkIPA.isSelected()){
                       txtOut.setText("No parameter selected"); 
                       
                    }
                    else{//IPA true
                        txtOut.setText
                     (Catalog.searchIPA(true));
                        System.out.println("IPA");
                    }
                }
                else{//ibu not empty
                    txtOut.setText
            (Catalog.searchIbu(Integer.parseInt(ddlIbu.getSelectionModel().getSelectedItem())));
                    System.out.println("IBU");
                }
            }
            else{ // not empty style field
                txtOut.setText(Catalog.searchStyle(ddlBase.getSelectionModel().getSelectedItem()));
                System.out.println("STYLE");
            }
        }
        else{// not empty name field
            txtOut.setText
            (Catalog.search(txtName.getText()));
            System.out.println("NAME");
        }    
        
    }
    
    @FXML
    private void next(MouseEvent event){
        txtOut.setText(Catalog.next());
    }
  @FXML
    private void previous(MouseEvent event){
        txtOut.setText(Catalog.previous());
    }
    
    @FXML
    private void add(MouseEvent event){
    Beer addBeer = new Beer(Integer.parseInt(ddlIbu.getSelectionModel().getSelectedItem())
            , ddlBase.getSelectionModel().getSelectedItem(), chkIPA.isSelected(), txtName.getText());
    Catalog.add(addBeer);
    txtOut.setText("Beer added!");
    }
 
    @FXML
    private void remove(MouseEvent event){
        txtOut.setText(Catalog.remove());
    }
    
    @FXML
    private void save(MouseEvent event){
        Catalog.WriteFile();
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ddlBase.setItems(obsBase);
       ddlBase.getSelectionModel().select(0);
       ddlIbu.setItems(obsIbu);
       ddlIbu.getSelectionModel().select(0);
       txtOut.setEditable(false);
       //Catalog.iniList();
      // Catalog.WriteFile();
       Catalog.Readfile();
       
    
       
       
       
      
    }    
    
}
