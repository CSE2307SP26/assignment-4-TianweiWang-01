package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {
//1
	@Test
	void testCurrentArray() {
	 Spellchecker checker = new Spellchecker();
	 int words = checker.getNumberOfWords();
	 assertEquals(0, words);
	}
//2
	@Test
	void testAddingNewWord() {
        checker.addWord("I");
        int words = checker.getNumberOfWords();
        assertEquals(1, words);
	}
//3
    @Test
    void testAddingDuplicateWord() {
        checker.addWord("I");
        int word1 = checker.getNumberOfWords();
        assertEquals(1, word1);

        checker.addWord("I"); 
        int word2 = checker.getNumberOfWords();
        assertEquals(1, word2);
    }

//4
    @Test
    void testIsSpelledCorrectlyValidWord() {
        checker.addWord("cat");
        boolean result = checker.isSpelledCorrectly("cat");
        assertTrue(result);
    }

 //5 
    @Test
    void testIsSpelledCorrectlyInvalidWord() {
        checker.addWord("cat");
        boolean result = checker.isSpelledCorrectly("cta");
        assertFalse(result);
    }

 //6
    @Test
    void testIsSpelledCorrectlyIgnoreCase() {
        checker.addWord("cat");
        boolean result = checker.isSpelledCorrectly("CaT");
        assertTrue(result);
    }

//7
    @Test
    void testGetSuggestedWord() {
        checker.addWord("bank");
        checker.addWord("back");
        checker.addWord("baby");      
        String suggestion = checker.getSuggestedWord("bamk");
        assertEquals("bank", suggestion);
    }
//8
    @Test
    void testGetSuggestedWordCorrectWord() {
        checker.addWord("cat");
        String suggestion = checker.getSuggestedWord("cat");
        assertEquals("cat", suggestion);
	}


//9
    @Test
    void testGetNumberOfWordsAfterAddingEmptyString() {
        checker.addWord("");
        int word1 = checker.getNumberOfWords();
        assertEquals(0, word1);

        checker.addWord("   ");
        int word2 = checker.getNumberOfWords();
        assertEquals(0, word2);

        checker.addWord("cat");
        int word3 = checker.getNumberOfWords();
        assertEquals(1, word3);
    }

//10
    @Test
    void testGetNumberOfWordsClearingAllWords() {
        checker.addWord("cat");
        checker.addWord("meow");
        int word1 = checker.getNumberOfWords();
        assertEquals(2, word1);

        checker.clearAllWords();
        int word2 = checker.getNumberOfWords();
        assertEquals(0, word2);
    }
}

    