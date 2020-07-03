import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator obo = new OffByOne();
    static CharacterComparator ob5 = new OffByN(5);

    @Test
    public void testWordToDeque() {
        String test = "persiflage";
        Deque d = palindrome.wordToDeque(test);
        String actual = "";
        for (int i = 0; i < test.length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals(test, actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("aaaaab"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        assertFalse(palindrome.isPalindrome("aba",obo));
    }
}