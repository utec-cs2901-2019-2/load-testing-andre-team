package calculator.business;

import calculator.entities.Language;

public class TranslatorImpl implements Translator {

    @Override
    public String translate(Language from, Language to, String text) {
        return "Hola Mundo";
    }
}
