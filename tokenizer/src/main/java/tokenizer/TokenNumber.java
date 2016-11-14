package tokenizer;


public class TokenNumber extends Token {

    private int value;

    public TokenNumber(int begin, int end, String text, int value) {
        super(begin, end, text);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
