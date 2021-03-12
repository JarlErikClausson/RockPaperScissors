package de.krage.rockpaperscissors.choices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceTest {

	// Rock
	@Test
	public void testRockBeatsRockFalse(){
		assertFalse((new Rock()).beats(new Rock()));
	}

	@Test
	public void testRockBeatsPaperFalse(){
		assertFalse((new Rock()).beats(new Paper()));
	}

	@Test
	public void testRockBeatsScissorsTrue(){
		assertTrue((new Rock()).beats(new Scissors()));
	}

	// Paper
	@Test
	public void testPaperBeatsRockTrue(){
		assertTrue((new Paper()).beats(new Rock()));
	}

	@Test
	public void testPaperBeatsPaperFalse(){
		assertFalse((new Paper()).beats(new Paper()));
	}

	@Test
	public void testPaperBeatsScissorsFalse(){
		assertFalse((new Paper()).beats(new Scissors()));
	}

	// Scissors
	@Test
	public void testScissorsBeatsRockFalse(){
		assertFalse((new Scissors()).beats(new Rock()));
	}

	@Test
	public void testScissorsBeatsPaperTrue(){
		assertTrue((new Scissors()).beats(new Paper()));
	}

	@Test
	public void testScissorsBeatsScissorsFalse(){
		assertFalse((new Scissors()).beats(new Scissors()));
	}
}