package simbirsoft;

import java.io.*;

/**
 * Created by User on 04.08.2015.
 */
public class FileExtensionsFilter implements FilenameFilter {
    String endWith;

    public FileExtensionsFilter(String str) {
        endWith = str;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(endWith);
    }
}
