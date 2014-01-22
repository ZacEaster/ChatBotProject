package chat.model;

import java.util.ArrayList;

// I learned how to repeat a program running until a variable is met.

public class Chatbot
{
	/**
	 * Declaration Section
	 */
	private ArrayList<String> myMemes;
	private ArrayList<String> myGames;
	private ArrayList<String> myTopic;
	private ArrayList<String> myQuestion;
	private ArrayList<String> mySecondQuestion;
	private ArrayList<String> myRandomList;
	private ArrayList<String> conversationList;
	/**
	 * Constructor that initializes values through creating arrays
	 */	
	public Chatbot()
	{
		myMemes = new ArrayList<String>();
		myGames = new ArrayList<String>();
		myTopic = new ArrayList<String>();
		myQuestion = new ArrayList<String>();
		mySecondQuestion = new ArrayList<String>();
		myRandomList = new ArrayList<String>();
		conversationList = new ArrayList<String>();
		fillTheMemeList();
		fillTheGameList();
		fillTheRandom();
		fillTheConversationList();
	}
/**
 * adds game values for the bot to recognize
 */
	private void fillTheGameList()
	{
		myGames.add("League of Legends");
		myGames.add("Starcraft");
		myGames.add("Call of duty");
	}
/**
 * adds meme values for the bot to recognize
 */
	private void fillTheMemeList()
	{
		myMemes.add("my jammies are rustled");
		myMemes.add("Cats");
		myMemes.add("What does the fox say");
		myMemes.add("philosoraptor");
		myMemes.add("iamdisappoint");
	}
	/**
	 * adds random values for the bot to recognize and print out.
	 */
	private void fillTheRandom()
	{
		myRandomList.add("cat");
		myRandomList.add("I have to say something random?");
		myRandomList.add("penguins are cool");
		
	}
	/**
	 * Prints out the random topic values that have already been created
	 * @return myRandomTopic
	 */
	public String getRandomTopic()
	{
		String myRandomTopic = "";
		
		double myRandomNumber = Math.random();
		
		int myRandomListPosition = (int) (myRandomNumber * myRandomList.size());
		myRandomTopic = myRandomList.get(myRandomListPosition);
		
		return myRandomTopic;
	}
/**
 * Checks to see if what you are talking about is a meme value
 * @param currentPhrase
 * @return isMeme
 */
	public boolean memeChecker(String currentPhrase)
	{
		boolean isMeme = false;

		if (currentPhrase != null)
		{
			for (String currentMeme : myMemes)
			{
				if (currentPhrase.equalsIgnoreCase(currentMeme))
				{
					isMeme = true;
				}

			}
		}

		return isMeme;
	}
/**
 * Checks to see if what you are talking about is a game value
 * @param currentPhrase
 * @return isGame
 */
	public boolean gameChecker(String currentPhrase)
	{
		boolean isGame = false;
		if (currentPhrase != null)
		{
			for (String currentGame : myGames)
			{
				if (currentPhrase.equalsIgnoreCase(currentGame))
					;
				{
					isGame = true;
				}
			}
		}
		return isGame;
	}
/**
 * Checks to see the topic you are talking about
 * @param currentPhrase
 * @return isTopic
 */
	public boolean topicChecker(String currentPhrase)
	{
		boolean isTopic = false;
		if (currentPhrase != null)
		{
			for (String currentTopic : myTopic)
			{
				if (currentPhrase.equalsIgnoreCase(currentTopic))
					;
				{
					isTopic = true;
				}
			}
		}
		return isTopic;
	}
	/**
	 * Halloween edit that is not being used at the current moment
	 * @param current
	 * @return processedString
	 */
	public String usesContent(String current)
	{
		String processedString = "";
		if(current.contains("boo"))
		{
			processedString = "wooooooooooo scary";
		}
		else
		{
			processedString = "boooring";
		}
		return processedString;
	}
	/**
	 * puts the first middle and last names in alphabetical order
	 * @param first
	 * @param middle
	 * @param last
	 * @return sortedName
	 */
	public String putNameInAlphabeticOrder(String first, String middle, String last)
	{
		String sortedName = "";
		if(first.compareTo(middle) < 0)
		{
			if(first.compareTo(last) < 0)
			{
				if(middle.compareTo(last) < 0)
				{
					sortedName = first + ", " + middle + ", " + last;
				}
				else
				{
					sortedName = first + ", " + last + ", " + middle;
				}
			}
			else
			{
				sortedName = last + ", " + first + ", " + middle;
			}
		}
		else
		{
			if(middle.compareTo(last) < 0)
			{
				if(last.compareTo(first) < 0)
				{
					sortedName = middle + ", " + last + ", " + first;
				}
				else
				{
					sortedName = middle + ", " + first + ", " + last;
				}
			}
			else
			{
				sortedName = last + ", " + middle + ", " + first;
			}
		}
		
		return sortedName;
	}
	/**
	 * provides values to be called upon on the 7th click
	 */
	private void fillTheConversationList()
	{
		conversationList.add("Monkeys. ");
		conversationList.add("Explain them. ");
		conversationList.add("But how? ");
	}
	/**
	 * Getter for the conversation piece
	 * @return conversationList
	 */
	public ArrayList<String> conversationPiece()
	{
		
		return conversationList;
	}

}
