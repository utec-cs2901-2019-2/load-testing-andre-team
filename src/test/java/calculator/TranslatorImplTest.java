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
		response.toLowerCase();
        Assert.assertEquals(response, "hola mundo");

        response = translator.translate(es, en, "hola mundo");
		response.toLowerCase();
        Assert.assertEquals(response, "hello word");

        response = translator.translate(es, it, "hola mundo");
		response.toLowerCase();
        Assert.assertEquals(response, "ciao mondo");

        response = translator.translate(it, fr, "ciao mondo");
		response.toLowerCase();
        Assert.assertEquals(response, "bonjour tout le monde");
    }
}
