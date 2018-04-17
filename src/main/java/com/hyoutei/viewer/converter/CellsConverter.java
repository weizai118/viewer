package com.hyoutei.viewer.converter;

import com.aspose.cells.License;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Excel转换器
 *
 * @author lideguang
 * @version 1.0
 * @date 2018年4月17日11:26:20
 */
public class CellsConverter {

    public CellsConverter() {
        try (InputStream open = CellsConverter.class.getResource("license.xml").openStream()) {
            License license = new License();
            license.setLicense(open);
            open.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getConverter(File file, String newPath) {
        try {
            Workbook book = new Workbook(new FileInputStream(file));
            book.save(newPath, SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
