package calculator.business;

import calculator.entities.Language;

import java.io.*;
import java.net.*;


public interface Translator {

    public String translate(Language from, Language to, String text);
}
