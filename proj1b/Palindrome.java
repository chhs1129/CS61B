public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> ad = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            ad.addLast(word.charAt(i));
        }
        return ad;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> ad = wordToDeque(word);
        while (!ad.isEmpty()) {
            if(ad.size() == 1)
                break;
            if( ad.removeFirst() != ad.removeLast())
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> ad = wordToDeque(word);
        while (!ad.isEmpty()) {
            if(ad.size() == 1)
                break;
            if( !cc.equalChars(ad.removeFirst(), ad.removeLast()))
                return false;
        }
        return true;
    }
}
