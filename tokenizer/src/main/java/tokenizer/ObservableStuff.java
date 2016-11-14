package tokenizer;

public interface ObservableStuff {

    void addTokenHandler (TokenHandler handler);
    //void removeTokenHandler (TokenHandler handler);
    void notifyHandlers (Token token);
    void tokenize(String text);


}
