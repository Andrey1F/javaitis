package tokenizer;

public class Main {

    public static void main(String[] args) {

        String text = "Get token 112 ";

        ObservableStuff tokenizer = new Tokenizer();
        tokenizer.addTokenHandler(new TokenHandlerNumbersImpl());
        tokenizer.addTokenHandler(new TokenHandlerLettersImpl());
        tokenizer.addTokenHandler(new TokenHandlerSeparatorImpl());
        tokenizer.addTokenHandler(new TokensCollectionHandler());

        tokenizer.tokenize(text);

    }
}
