package calculator;

import calculator.business.TranslatorImpl;
import calculator.entities.Language;

public class Main {
    public static void main(String args[]){
        TranslatorImpl translator = new TranslatorImpl();
        Language es = new Language("ES", "Spanish");
        Language en = new Language("EN", "English");
        String text = "Hola Mundo";
        System.out.println(translator.translate(es, en, text));
    }
}
