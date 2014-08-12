package pxb.android.arsc.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import pxb.android.arsc.ArscDumper;
import pxb.android.arsc.ArscParser;
import pxb.android.arsc.ArscWriter;
import pxb.android.arsc.Pkg;
import pxb.android.axml.Util;

public class Test1 {
    @Test
    public void test() throws IOException {
        for (File file : new File("src/test/resources/").listFiles()) {
            if (file.getName().endsWith(".arsc")) {
                System.out.println("======= test " + file);
                byte[] arsc = Util.readFile(file);
                List<Pkg> pkgs = new ArscParser(arsc).parse();
                ArscDumper.dump(pkgs);
                ArscDumper.dump(new ArscParser(new ArscWriter(pkgs).toByteArray()).parse());
            }
        }
    }
}
