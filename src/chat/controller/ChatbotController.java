package chat.controller;

import java.util.ArrayList;

import chat.model.Chatbot;
import chat.view.ChatbotFrame;
import chat.view.ChatbotView;

/**
 * 
 * @author zeas9357
 * @version 1.6 10/30/13 Adding Model to the project and changed GUI load. Added a getter for the 
 * Chatbot. Removed the references to the pop up view. Added documentation.
 */

public class ChatbotController
{
	/**
	 * The application frame for the Chatbot program.
	 */
 	private ChatbotFrame appFrame;
	/**
	 * The main chatbot for the application.
	 */
	private Chatbot appBot;
	/**
	 * creates a ChatbotController and initializes the Chatbot model instance. 
	 */
	public ChatbotController()
	{
		appBot = new Chatbot();
	}
	/**
	 * Getter method for the Chatbot instance.
	 * @return The Chatbot for the application
	 */
	public Chatbot getAppBot()
	{
		return appBot;
	}
	/**
	 * Initializes the ChabotFrame for the GUE
	 */
	public void start()
	{
		appFrame = new ChatbotFrame(this);
	}
	/**
	 * Checks to see if a meme was input. It prompts based on those results.
	 * @param currentInput
	 * @return memeReaction
	 */
	
	public String memeValidation(String currentInput)
	{
		String memeReaction = "Why aren't you talking about the memes?";
		if(appBot.memeChecker(currentInput))
		{
			memeReaction = currentInput + " is the coolest meme huh";
		}
		return memeReaction;
	}
	/**
	 * Checks to see if a game was input. It then prompts based on the results
	 * @param currentInput
	 * @return gameReaction
	 */
	public String gameValidation(String currentInput)
	{
		String gameReaction = "Why are you not talking about the goods?";
		if(appBot.gameChecker(currentInput))
		{
			gameReaction = currentInput + " is a really sweet game!!!!!!!!! WOOOOOOOOOOOOOOO";
		}
		return gameReaction;
	}
	/**
	 * Removed the position 0 from the Array so it would not break
	 * @param currentList
	 * @return current phrase
	 */
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentPhrase = "";
		
		if(currentList.size() > 0)
		{
			currentPhrase = currentList.remove(0);
		}
		
		return currentPhrase;
	}
	/**
	 * passes conversation piece to the conversationHelper
	 * @return currentConversationPiece
	 */
	public String dominateTheConversation()
	{
		String currentConversationPiece = "";
		
		currentConversationPiece = conversationHelper(appBot.conversationPiece());
		
		return currentConversationPiece;
	}
	
	/**
	 * Checks the input given by the user
	 * @param currentInput
	 * @return response
	 */
	public String processUserInput(String currentInput)
	{
		String response = "";
		
		if (appBot.memeChecker(currentInput))
		{
			response = "memes!!!!";
		}
		else if(true)
		{
			
		}
		return response;
	}
}
