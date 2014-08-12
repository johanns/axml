package pxb.android.axml.test;

import java.io.File;

import org.junit.Test;

import pxb.android.axml.AxmlReader;
import pxb.android.axml.AxmlWriter;
import pxb.android.axml.DumpAdapter;
import pxb.android.axml.Util;

public class Test2 {
    @Test
    public void test() throws Exception {
        for (File file : new File("src/test/resources/").listFiles()) {
            if (file.getName().endsWith(".axml")) {
                System.out.println("======= test " + file);
                byte[] xml = Util.readFile(file);
                AxmlReader rd = new AxmlReader(xml);
                AxmlWriter wr = new AxmlWriter();
                System.out.println("=== A ");
                rd.accept((new DumpAdapter(wr)));
                System.out.println("=== B ");
                new AxmlReader(wr.toByteArray()).accept(new DumpAdapter(AxmlReader.EMPTY_VISITOR));
            }
        }
    }

}
