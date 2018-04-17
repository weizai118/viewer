package com.hyoutei.viewer.converter;

import com.aspose.imaging.Image;
import com.aspose.imaging.License;

import java.io.*;

/**
 * Img转换器
 *
 * @author lideguang
 * @version 1.0
 * @date 2018年4月17日11:26:20
 */
public class ImgConverter {

    public ImgConverter() {
        try (InputStream open = ImgConverter.class.getResource("license.xml").openStream()) {
            License license = new License();
            license.setLicense(open);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getConverter(File file, String newPath) {
        try {
            Image image = Image.load(new FileInputStream(file));
            image.save(newPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
