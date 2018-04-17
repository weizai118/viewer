package com.hyoutei.viewer.converter;

import com.aspose.slides.License;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;

import java.io.*;

/**
 * PPT转换器
 *
 * @author lideguang
 * @version 1.0
 * @date 2018年4月17日11:26:20
 */
public class SlidesConverter {

    public SlidesConverter() {
        try (InputStream open = SlidesConverter.class.getResource("license.xml").openStream()) {
            License license = new License();
            license.setLicense(open);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getConverter(File file, String newPath) {
        try {
            Presentation pres = new Presentation(new FileInputStream(file));
            pres.save(newPath, SaveFormat.Pdf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
