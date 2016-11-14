package tokenizer;

public class TokenHandlerSeparatorImpl implements TokenHandler {
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(TokenSeparator.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm separator! " + token.getText());
        }
    }

//    public void handleToken(Token token) {
//        System.out.println("from: " + " " + getName() + " I'm separator! " + token);
//    }

    public String getName() {
        return "SeparatorHandler";
    }

    public Class<?> getWorkClass() {
        return TokenSeparator.class;
    }
}
