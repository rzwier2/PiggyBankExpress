package piggybankexpress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 

public class ExpenseHistory extends Application {
	
	private ObservableList<ObservableList> data;
    private TableView tableview;
	Scene scene; 
	Stage primaryStage;
	String SQL = "SELECT TransDate, FirstName, LastName, Category, Cost\n" + 
			"FROM user INNER JOIN transaction ON user.PersonID = transaction.PersonID  \n" + 
			"ORDER BY TransDate desc";

	public ExpenseHistory() {
		
	}
	public void start(Stage primaryStage) {
		tableview = new TableView();
		buildData();
		primaryStage.setTitle("Piggy Bank Express");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.BASELINE_CENTER);
		grid.setHgap(20);
		grid.setVgap(5);
		grid.setPadding(new Insets(40, 40, 40, 40));
		
		
        
		HBox paneForButtons = new HBox(20);
		Button loadButton = new Button("Back");
	    paneForButtons.setAlignment(Pos.BOTTOM_CENTER);
	    paneForButtons.getChildren().add(loadButton);
	    paneForButtons.setStyle("-fx-border-color: gray");
		
		Text scenetitle = new Text("Piggy Bank Express");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));
		grid.add(scenetitle, 0, 1, 3, 2);
		
		
		VBox vbox = new VBox();
	    vbox.setSpacing(5);
	    vbox.setPadding(new Insets(10, 0, 0, 10));
	    vbox.getChildren().addAll(grid, loadButton);
	    grid.add(tableview, 0, 25);
			
			
        Scene scene = new Scene(vbox, 1800, 1800);
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	
	public void buildData() {
		Connection conn2 = null;
		
		try {
		String url2 = "jdbc:mysql://localhost:3306/piggybank?user=root&password=baseball";
        conn2 = DriverManager.getConnection(url2);
        if (conn2 != null) {
            System.out.println("Connected to the database test2");
        }
		}
        catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
       // Connection c = null;
        data = FXCollections.observableArrayList();
        try {
        	
            ResultSet rs = conn2.createStatement().executeQuery(SQL);
 
            // Populate the table
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
 
                tableview.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }
 
            //Adds data to the ObservedList
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
 
            }
 
            //FINALLY ADDED TO TableView
            tableview.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

	
	public static void main(String[] args) {
        //new ExpenseHistoryGUI(); //call constructor
    	launch(args);
        
    }
	
}