package tokenizer;



public class TokenSeparator extends Token {

    private char type;


    public TokenSeparator(int begin, int end, String text, char type) {
        super(begin, end, text);
        this.type = type;
    }
}