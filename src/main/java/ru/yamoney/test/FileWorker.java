package ru.yamoney.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by def on 31.07.14.
 */
public class FileWorker {
    public void editFile(String file) {

    }

    public String viewFile(String file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s;
            StringBuffer sb = new StringBuffer();
            while((s = br.readLine()) != null) {
                sb.append(s + "\n");
            }
            fr.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            return "File not found. To create add go ?file=filename&edit=1";
        }
        catch (IOException e){
            return "Reading error";
        }
    }
}
