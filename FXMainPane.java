


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button button1, 
	       button2, 
	       button3, 
	       button4,
	       button5;
	Label label;
	TextField textField;
	HBox hBox1, hBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * 
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	
	DataManager dataManager = new DataManager();
	
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		
		label = new Label("Feedback: ");
		textField = new TextField();
		hBox1 = new HBox();
		hBox2 = new HBox();
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		   HBox.setMargin(button1, new Insets(10));
	       HBox.setMargin(button2, new Insets(10));
	       HBox.setMargin(button3, new Insets(10));
	       HBox.setMargin(button4, new Insets(10));
	       HBox.setMargin(button5, new Insets(10));
	       hBox1.setAlignment(Pos.CENTER);
	       hBox2.setAlignment(Pos.CENTER);
		
		
		
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
		hBox1.getChildren().addAll(button1, button2, button3, button4, button5);
		hBox2.getChildren().addAll(label, textField);
		getChildren().addAll(hBox1, hBox2);
	

	
	//Task #4:
	//  create a private inner class to handle the button clicks
	
		
		button1.setOnAction(new EventHandler<ActionEvent>()
	    {
	        public void handle(ActionEvent e)
	        {
	        	textField.setText(dataManager.getHello());
	        }
	    });
		button2.setOnAction(new EventHandler<ActionEvent>()
	    {
	        public void handle(ActionEvent e)
	        {
	        	 textField.setText(dataManager.getHowdy());
	        }
	    }); 
		button3.setOnAction(new EventHandler<ActionEvent>()
	    {
	        public void handle(ActionEvent e)
	        {
	        	 textField.setText(dataManager.getChinese());
	        }
	    }); 
		button4.setOnAction(new EventHandler<ActionEvent>()
	    {
	        public void handle(ActionEvent e)
	        {
	        	textField.setText(""); 
	        }
	    }); 
		button5.setOnAction(new EventHandler<ActionEvent>()
	    {
	        public void handle(ActionEvent e)
	        {
	        	Platform.exit(); 
	        	System.exit(0); 
	        }
	    }); 
	}
}
	

	