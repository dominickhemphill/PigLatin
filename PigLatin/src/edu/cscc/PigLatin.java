package edu.cscc;

import java.util.Scanner;

/**
 * Pig Latin Translator
 * 
 * @author Dominick Hemphill
 * Lab 2
 * 09/07/2020
 * CSCI - 2469 b02
 *
 */
public class PigLatin {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		PigLatin translator = new PigLatin();
		System.out.println("*** Pig Latin Translator ***");
		System.out.print("Enter text to translate: ");
		String text = input.nextLine();
		System.out.println("Translation: " + translator.translate(text));
	}

	/**
	 * Translate an entire sentence to Pig Latin
	 * 
	 * @param text the text to translate
	 * @return translated text
	 */
	public String translate(String text) {
		StringBuilder output = new StringBuilder();
		text = text.toLowerCase();
		String[] words = text.split(" ");
		if (words.length > 0) {
			for (String word : words) {
				output.append(translateWord(word));
				output.append(" ");
			}
		}

		return output.toString().strip();
	}

	/**
	 * Translate a word to Pig Latin
	 * 
	 * @param word the word to translate
	 * @return translated word
	 */
	private String translateWord(String word) {
		String translated = "";
		String delims = "\\s+";
		String[] words = word.split(delims);
		int index = indexOfVowel(word);

		for (int i = 0; i < words.length; i++) {
			if (isVowel(words[i].toLowerCase().charAt(0))) {
				translated += words[i] + "way";
			} else if (indexOfVowel(word) == word.length()) {
				translated = word;
			} else {
				translated += words[i].substring(index) + words[i].substring(0, index) + "ay";
			}
		}
		return translated;
	}

	/**
	 * Return the index of the first vowel in the word. Returns the word length if
	 * no vowels are present
	 * 
	 * @param word the word to examine for a vowel
	 * @return the index of the first vowel
	 */
	private int indexOfVowel(String word) {
		int index = word.length();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (isVowel(c)) {
				index = word.indexOf(c);
				break;
			}
		}
		return index;
	}

	/**
	 * Determine if a character is a vowel (a,e,i,o,u)
	 * 
	 * @param ch character to test
	 * @return true if the character is a vowel, false otherwise
	 */
	private boolean isVowel(char ch) {
		boolean vowel = false;
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			vowel = true;
		}
		return vowel;
	}
}
