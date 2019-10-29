package com.api.project.demo.utility;

public class ParamSelection {

    public static String getRequestData(String inputType) {
        inputType = (inputType.equals("empty")) ? "" : inputType;
        inputType = (inputType.equals("iexcel")) ? "¡" : inputType;
        inputType = (inputType.equals("tm")) ? "™" : inputType;
        inputType = (inputType.equals("euro")) ? "€" : inputType;
        inputType = (inputType.equals("cent")) ? "¢" : inputType;
        inputType = (inputType.equals("pound")) ? "£" : inputType;
        inputType = (inputType.equals("curren")) ? "¤" : inputType;
        inputType = (inputType.equals("yen")) ? "¥" : inputType;
        inputType = (inputType.equals("brvbar")) ? "¦" : inputType;
        inputType = (inputType.equals("sect")) ? "§" : inputType;
        inputType = (inputType.equals("uml")) ? "¨" : inputType;
        inputType = (inputType.equals("copy")) ? "©" : inputType;
        inputType = (inputType.equals("ordf")) ? "ª" : inputType;
        inputType = (inputType.equals("laquo")) ? "«" : inputType;
        inputType = (inputType.equals("not")) ? "¬" : inputType;
        inputType = (inputType.equals("reg")) ? "®" : inputType;
        inputType = (inputType.equals("macr")) ? "¯" : inputType;
        inputType = (inputType.equals("deg")) ? "°" : inputType;
        inputType = (inputType.equals("plusmn")) ? "±" : inputType;
        inputType = (inputType.equals("sup2")) ? "²" : inputType;
        inputType = (inputType.equals("sup3")) ? "³" : inputType;
        inputType = (inputType.equals("acute")) ? "´" : inputType;
        inputType = (inputType.equals("micro")) ? "µ" : inputType;
        inputType = (inputType.equals("para")) ? "¶" : inputType;
        inputType = (inputType.equals("middot")) ? "·" : inputType;
        inputType = (inputType.equals("cedil")) ? "¸" : inputType;
        inputType = (inputType.equals("sup1")) ? "¹" : inputType;
        inputType = (inputType.equals("ordm")) ? "º" : inputType;
        inputType = (inputType.equals("raquo")) ? "»" : inputType;
        inputType = (inputType.equals("frac14")) ? "¼" : inputType;
        inputType = (inputType.equals("frac34")) ? "¾" : inputType;
        inputType = (inputType.equals("blank")) ? " " : inputType;
        inputType = (inputType.equals("multibyte")) ? "中华人民共和国" : inputType;
        inputType = (inputType.equals("htmlTags")) ? "<p></p>" : inputType;
        inputType = (inputType.equals("bang")) ? "!" : inputType;

        inputType = (inputType.equals("hash")) ? "#" : inputType;
        inputType = (inputType.equals("dollar")) ? "$" : inputType;
        inputType = (inputType.equals("percent")) ? "%" : inputType;
        inputType = (inputType.equals("apostrophe")) ? "'" : inputType;
        inputType = (inputType.equals("amper")) ? "&" : inputType;

        inputType = (inputType.equals("parentheses")) ? "()" : inputType;
        inputType = (inputType.equals("star")) ? "*" : inputType;
        inputType = (inputType.equals("plus")) ? "+" : inputType;
        inputType = (inputType.equals("comma")) ? "," : inputType;
        inputType = (inputType.equals("dash")) ? "-" : inputType;
        inputType = (inputType.equals("dot")) ? "." : inputType;
        inputType = (inputType.equals("forwardslash")) ? "/" : inputType;
        inputType = (inputType.equals("colon")) ? ":" : inputType;
        inputType = (inputType.equals("semicolon")) ? ";" : inputType;
        inputType = (inputType.equals("lessthan")) ? "<" : inputType;
        inputType = (inputType.equals("equals")) ? "=" : inputType;
        inputType = (inputType.equals("morethan")) ? ">" : inputType;
        inputType = (inputType.equals("question")) ? "?" : inputType;
        inputType = (inputType.equals("at")) ? "@" : inputType;
        inputType = (inputType.equals("squarebrackets")) ? "[]" : inputType;
        inputType = (inputType.equals("hat")) ? "^" : inputType;
        inputType = (inputType.equals("skid")) ? "_" : inputType;
        inputType = (inputType.equals("grave")) ? "`" : inputType;
        inputType = (inputType.equals("curlybraces")) ? "{}" : inputType;
        inputType = (inputType.equals("bar")) ? "|" : inputType;
        inputType = (inputType.equals("tilde")) ? "~" : inputType;
        inputType = (inputType.equals("acute")) ? "´" : inputType;
        inputType = (inputType.equals("shbang")) ? "#!" : inputType;
        inputType = (inputType.equals("slashterix")) ? "/*" : inputType;
        inputType = (inputType.equals("asterslash")) ? "*/" : inputType;

        inputType = (inputType.equals("amperamp")) ? "&amp;" : inputType;
        inputType = (inputType.equals("lengthycharflagfixed"))
                ? "123we67ty0123we67ty0123we67ty0123we67ty0123we67ty0"
                : inputType;
        inputType = (inputType.equals("null")) ? "null" : inputType;
        inputType = (inputType.equals("decimal")) ? "3.56" : inputType;
        inputType = (inputType.equals("numericonly")) ? "356" : inputType;
        return inputType;
    }

}
