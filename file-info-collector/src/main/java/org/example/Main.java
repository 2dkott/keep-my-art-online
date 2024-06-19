package org.example;

public class Main {
    public static void main(String[] args) {
        String dfdf = "<aaaaa>" +
                "<bbbb>21323</bbbb>" +
                "<cccc>343434</cccc>" +
                "</aaaaa>";
        String ree = "(<aaaaa>.*<cccc>)\\d+(</cccc>)";
        dfdf = dfdf.replaceAll(ree, "$1333333$2");
        System.out.println(dfdf);
    }
}