package tokenizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Tokenizer implements ObservableStuff {

    private Map<Class, TokenHandler> handlers;

    private static final String PUNCT = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n\t ";

    public Tokenizer() {
        handlers = new HashMap<Class, TokenHandler>();
    }

    public void addTokenHandler(TokenHandler handler) {
        handlers.put(handler.getWorkClass(), handler);
    }

    public void removeHandlerByWorkClass(Class tokenClass) {
        handlers.remove(tokenClass);
    }

    public void notifyHandlers(Token token) {
        // получаем множество ключей-значений из мапа
        Set<Map.Entry<Class, TokenHandler>> entries =
                handlers.entrySet();

//         на каждой итерации цикла мы в entity кладем значение из entries
        for (Map.Entry<Class, TokenHandler> entity : entries) {
            // из текущего entity забираем значение - обработчик
            TokenHandler currentHandler = entity.getValue();
            // оповещаем обработчик
            currentHandler.handleToken(token);

        }
//        TokenHandler currentHandler = handlers.get(token.getClass());
//        currentHandler.handleToken(token);
//
//        handlers.get(Token.class).handleToken(token);

    }


    public void tokenize (String text) {

        char[] textAsCharArray = text.toCharArray();

        boolean onNumber = false;
        boolean onWord = false;

        StringBuilder currentToken = new StringBuilder();

        int begin = 0;

        for (int i = 0; i < textAsCharArray.length; i++) {

            char c = textAsCharArray[i];

            if (Character.isLetter(c)) {

                if (!onWord) {
                    begin = i;
                }

                currentToken.append(c);

                onWord = true;

                if (textAsCharArray.length-1 == i)
                    notifyHandlers(new TokenWord(begin, i, currentToken.toString(),Character.isUpperCase(currentToken.charAt(0))));
            }

            else if (onWord) {

                onWord = false;
                i -= 1;

                notifyHandlers(new TokenWord(begin, i, currentToken.toString(),Character.isUpperCase(currentToken.charAt(0))));

                currentToken.delete(0,currentToken.length());
                continue;

            }
            if (Character.isDigit(c)) {
                begin = !onNumber ? i : begin;
                currentToken.append(c);
                onNumber = true;
                if (textAsCharArray.length-1==i)
                    notifyHandlers(new TokenNumber(begin, i, currentToken.toString(), Integer.valueOf(currentToken.toString())));
            } else if (onNumber) {
                onNumber = false;
                i -= 1;
                notifyHandlers(new TokenNumber(begin, i, currentToken.toString(), Integer.valueOf(currentToken.toString())));
                currentToken.delete(0,currentToken.length());
                continue;
            }
            if (PUNCT.contains(String.valueOf(c))) {
                notifyHandlers(new TokenSeparator(i, i, String.valueOf(c), c));
            }
        }
    }


}
