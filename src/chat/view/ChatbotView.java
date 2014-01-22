package chat.view;

import javax.swing.JOptionPane;
import chat.model.Chatbot;

public class ChatbotView
{
	/**
	 * Declaration section
	 */
	private Chatbot myChatbot;
/**
 * Creates a new chatbot object
 */
	public ChatbotView()
	{
		myChatbot = new Chatbot();

	}
	/**
	 * Starts the pop ups
	 */
	public void showApp()
	{
		String input = "Keep on mooooooviiin";

		while (input == null || !input.equals("no"))
		{
			input = getInput();
			useInput(input);
		}
		myChatbot.conversationPiece();
	}
	/**
	 * Provides a pop up to write in to respond
	 * @return input
	 */
	private String getInput()
	{
		String input = "";

		input = JOptionPane.showInputDialog("Would you like to talk with me?");

		return input;
	}
	/**
	 * Checks what the topic of conversation is
	 * @param userInput
	 */
	private void useInput(String userInput)
	{
		if (myChatbot.memeChecker(userInput))
			;
		{
			JOptionPane.showMessageDialog(null, "I knew that " + userInput
					+ " is a meme!!!!!");
		}
		JOptionPane.showMessageDialog(null,
				"Wow that is so interesting that you want to talk with me about "
						+ getInput());
	}
}
