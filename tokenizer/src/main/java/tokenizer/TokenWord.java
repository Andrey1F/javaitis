package tokenizer;


public class TokenWord extends Token {

    private boolean isUpperFirst;

    public TokenWord(int begin, int end, String text, boolean isUpperFirst) {
        super(begin, end, text);
        this.isUpperFirst = isUpperFirst;
    }




}
