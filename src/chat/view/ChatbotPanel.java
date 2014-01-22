package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;
import chat.model.Chatbot;

/**
 * 
 * @author zeas9357
 * @version 1.1 10/23/13 Added setupPanel, setupLayout helper methods
 */

public class ChatbotPanel extends JPanel
{
	
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	private JButton submitChatButton;
	private JTextField userTextField;
	private JTextArea chatArea;
	private Chatbot appBot;
	private JScrollPane chatPane;
	private int clickCount;
	//Constructor
	public ChatbotPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getAppBot();
		
		submitChatButton = new JButton("Click here to type to the chatbot!");
		baseLayout = new SpringLayout();
		
		userTextField = new JTextField(30);
		
		chatPane = new JScrollPane();
		clickCount = 0;
		
		setupPanel();
		setupLayout();
		setupChat();
		setupListeners();
	}
	
	/**
	 * Starts the chatbot chat screen with a topic.
	 */
	private void setupChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}
	
	/**
	 * Loads all components into the panel and sets the layout manager and color.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatPane);
		this.add(submitChatButton);
		this.add(userTextField);
		chatArea = new JTextArea(10, 30);
		add(chatArea);
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
	}
	
	/**
	 * Creates listeners for all user interactive objects in the panel.
	 */
	private void setupListeners()
	{
		submitChatButton.addActionListener(new ActionListener()
		{
			/**
			 *  Do this when the submitChatButton is clicked!
			 */
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String userInput = userTextField.getText();
				
				if(clickCount % 7 == 0)
				{
					String currentPhrase = baseController.dominateTheConversation();
					if(currentPhrase.length() != 0)
					{
						chatArea.append("\n" + currentPhrase);
						clickCount--;		
					}
					
				}
				else if(clickCount % 5 == 0)
				{
					chatArea.append(baseController.memeValidation(userInput));
				}
				else if(clickCount % 8 == 0)
				{
					chatArea.append(baseController.gameValidation(userInput));
				}
				else
				{
					
					chatArea.append(" \n" + userInput);
					String processedInput = baseController.processUserInput(userInput);
					chatArea.append(processedInput);
					userTextField.setText("");
					chatArea.append(appBot.getRandomTopic());
					//This should be a method in the controller that would be returned as a string to place in the chatArea.
					String me, you, other;
					me = "Cody";
					you = "Ryan";
					other = "Devvin";
					chatArea.append(appBot.putNameInAlphabeticOrder(me, you, other));
				}
				
				
			}
		});
	}
	
	/**
	 * Places all objects with the computer generated code.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, submitChatButton, 257, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitChatButton, 102, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitChatButton, -102, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, userTextField, -17, SpringLayout.NORTH, submitChatButton);
		baseLayout.putConstraint(SpringLayout.WEST, userTextField, 102, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, userTextField, -102, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 17, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 78, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -6, SpringLayout.NORTH, userTextField);
	}
	
}
