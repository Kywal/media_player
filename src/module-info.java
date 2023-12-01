module mediaplayer {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;	
	requires javafx.media;
	requires javafx.swing;
	requires javafx.swt;
	requires javafx.web;	
	
	exports br.ufrn.imd.controller;
	
	opens br.ufrn.imd to javafx.graphics, javafx.fxml;
	opens br.ufrn.imd.controller to javafx.fxml;
}
