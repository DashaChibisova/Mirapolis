package mirapolis.ru.tests;

import org.apache.commons.lang3.RandomStringUtils;

public class Data {

    public final static String LOGIN_CORRECT = "fominaelena";
    public final static  String PASSWORD_CORRECT = "1P73BP4Z";

    public static String inValidData(String validData){
        return validData + RandomStringUtils.randomAlphabetic(2);
    }

}
