package pack3;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.net.URLEncoder;

public class Encode {

    public static void main(String[] args) {
        String example =
                "";
        String result = URLEncoder.encode(example);
        result = result.replaceAll("%3D", "=");
        StringSelection stringSelection = new StringSelection(result);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
        System.out.println("It already has been copied to clipboard!");
        System.out.println(result);
    }
}
