package de.krage.rockpaperscissors.choices;

public interface Choice {

	boolean beats(Choice pOpponentsChoice);

	String getName();
}
