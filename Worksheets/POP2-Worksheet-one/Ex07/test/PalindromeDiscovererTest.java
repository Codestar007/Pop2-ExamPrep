import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeDiscovererTest {
    @Test
    public void is_a_palindrome_single_char() {
        Assert.assertTrue(PalindromeDiscoverer.isPalindrome("A"));
    }

    @Test
    public void is_a_palindrome() {
        Assert.assertTrue(PalindromeDiscoverer.isPalindrome("bob"));
    }

    @Test
    public void is_a_palindrome_mixed_case() {
        Assert.assertTrue(PalindromeDiscoverer.isPalindrome("A but tuba"));
    }

    @Test
    public void is_a_palindrome_longer_phrase() {
        Assert.assertTrue(PalindromeDiscoverer.isPalindrome("Able was I ere I saw Elba"));
    }

    @Test
    public void is_not_a_palindrome() {
        Assert.assertFalse(PalindromeDiscoverer.isPalindrome("Free beer, I am there..."));
    }
}