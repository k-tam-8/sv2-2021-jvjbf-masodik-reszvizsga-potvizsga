package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentences {

    private List<String> sentences = new ArrayList<>();

    public void addSentence(String sentence) {
        if (!checkFirstLetter(sentence)) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        } else if (!checkLastCharacter(sentence)) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        } else {
            sentences.add(sentence);
        }
    }

    private boolean checkFirstLetter(String sentence) {
        return (Character.toUpperCase(sentence.charAt(0)) == sentence.charAt(0));
    }

    private boolean checkLastCharacter(String sentence) {
        List<Character> puncts = Arrays.asList('!', '?', '.');
        return (puncts.contains(sentence.charAt(sentence.length() - 1)));
    }

    public String findLongestSentence() {
        checkListSize();
        String longestSent = sentences.get(0);
        for (String s : sentences) {
            if (s.length() > longestSent.length()) {
                longestSent = s;
            }
        }
        return longestSent;
    }

    private void checkListSize(){
        if (sentences.size() == 0) {
            throw new IllegalStateException("A lista üres!");
        }
    }

    public List<String> getSentences() {
        List<String> sentencesCopy = sentences;
        return sentencesCopy;
    }
}
