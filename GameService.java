package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME - COMPLETE: Add missing pieces to turn this class a singleton
	
	/*
	 * Singleton pattern is created to make it so that there can only be one
	 * instance of the GameService at a time. This is done by testing to see
	 * if the there is an open instance, and if there is, it returns that instance, 
	 * and if it's not, then it creates a new instance. 
	 */
	
	private static GameService instance;
	
	private GameService() {}
	
	public static GameService getInstance(){
        if(instance == null){
            instance = new GameService();
        }
        return instance;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// The purpose of this iterator is search the list of games to see
		// if the given game objects exists, and if it doesn't, then it 
		// creates a new game object. 
		for (Game search : games) {
			if (search.getName().equals(name)) {
				return search;
			}
			else {
				game = new Game(nextGameId++, name);
				games.add(game);
				}
				
		}
		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// This iterator simply searches the list of games by the game id		
		for (Game search : games ) {
			if (search.getId() == id) {
				game = search;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// This iterator searches the list of games by the game name;
		for (Game search : games) {
			if (search.getName().equals(name)) {
				game = search;
			}
		}
		
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
