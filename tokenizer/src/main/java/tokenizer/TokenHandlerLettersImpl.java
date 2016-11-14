package tokenizer;

public class TokenHandlerLettersImpl implements TokenHandler{

    public void handleToken(Token token) {
        if (token.getClass().getName().equals(TokenWord.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm word! " + token.getText());
        }
    }

//    public void handleToken(Token token) {
//        System.out.println("from: " + " " + getName() + " I'm word! " + token);
//    }

    public String getName() {
        return "LettersHandler";
    }

    public Class<?> getWorkClass() {
        return TokenWord.class;
    }
}
