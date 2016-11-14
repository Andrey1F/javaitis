package tokenizer;

public class TokenHandlerNumbersImpl implements TokenHandler {
    public void handleToken(Token token) {
        // token instanceof Number.class
        if (token.getClass().getName().equals(TokenNumber.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm on number! " + token.getText());
        }
    }

//    public void handleToken(Token token) {
//        // token instanceof Number.class
//        System.out.println("from: " + " " + getName() + " I'm on number! " + token);
//    }

    public String getName() {
        return "NumberHandler";
    }

    public Class<?> getWorkClass() {
        return Number.class;
    }

}
