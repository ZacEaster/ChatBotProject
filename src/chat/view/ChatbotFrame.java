package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatbotFrame extends JFrame
{
	/**
	 * Declaration section
	 */
	private ChatbotController baseController;
	private ChatbotPanel basePanel;
	/**
	 * Constructor that initializes values
	 * @param baseController
	 */
	public ChatbotFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	/*
	 * Sets the visibility and size of the pop up window
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
}
