package com.ericsson.communication;

public class Information {

    private static String name = "ServiceCommand";
    private static String version = "1.3.0";

    private static String cvsTag = "$Name:  $";

    public static String getName() {
        return name;
    }

    public static String getVersion() {
        int dashIndex = cvsTag.indexOf("-");
        if (dashIndex < 0) {
            return version;
        }

        int vstart = (dashIndex+1);
        String tagVersion = cvsTag.substring(vstart, cvsTag.length()-2);
        String vers = tagVersion.replaceAll("_", ".");
        return vers;
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(getName()+" "+getVersion());
            return;
        }

        System.out.println(getName()+" "+getVersion());
        System.out.println();

    }

}
