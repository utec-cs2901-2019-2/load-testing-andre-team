package calculator;

import calculator.business.Translator;
import calculator.business.TranslatorImpl;
import calculator.entities.Language;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Locale;

public class TranslatorImplTest {
    Translator translator;
    Language en;
    Language es;
    Language it;
    Language fr;

    @BeforeMethod
    public void setUp() throws Exception {
        translator = new TranslatorImpl();
        en = new Language("EN", "English");
        es = new Language("ES", "Spanish");
        it = new Language("IT", "Italian");
        fr = new Language("FR", "French");
    }

    @Test(invocationCount = 100, threadPoolSize = 5)
    public void testTranslateDummy() throws Exception {
        String response = translator.translate(en, es, "hello world");
        Assert.assertEquals(response, "Hola Mundo");

        response = translator.translate(es, en, "hola mundo");
        Assert.assertEquals(response, "Hello World");

        response = translator.translate(it, fr, "ciao mondo");
        Assert.assertEquals(response, "bonjour le monde");
    }
}
