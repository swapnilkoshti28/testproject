package com.sdk.app;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class RectComponent {

	private Rectangle rectangle;
	private Line line;
	
	
	protected RectComponent(Rectangle rectangle, Line line) {
		super();
		this.rectangle = rectangle;
		this.line = line;
		
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public void setStyle(Color color, double size) {
		rectangle.setStroke(color);
		rectangle.setStrokeWidth(size);
		line.setStroke(color);
		line.setStrokeWidth(size);
	}
	
	
	public void selectRect() {
		setStyle(Color.BROWN, 2);
	}
	
	public void delesectRect() {
		setStyle(Color.CORAL, 1);
	}
}
