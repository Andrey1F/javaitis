
package tokenizer;

public interface TokenHandler {

    void handleToken(Token token);
    String getName();
    Class<?> getWorkClass();
}
