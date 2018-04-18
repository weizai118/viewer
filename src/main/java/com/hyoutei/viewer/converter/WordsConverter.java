package com.hyoutei.viewer.converter;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Word转换器
 *
 * @author hyoutei
 * @version 1.0
 * @date 2018年4月17日11:26:20
 */
public class WordsConverter {

    public WordsConverter() {
        try (InputStream open = WordsConverter.class.getResource("license.xml").openStream()) {
            License license = new License();
            license.setLicense(open);
            open.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getConverter(File file, String newPath) {
        try {
            Document doc = new Document(new FileInputStream(file));
            doc.save(newPath, SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
