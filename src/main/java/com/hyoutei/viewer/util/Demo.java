package com.hyoutei.viewer.util;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author hyoutei
 * @version 1.0
 * @date 2018/4/16 16:03
 */
public class Demo {

    public static int readFully(ReadableByteChannel channel, ByteBuffer b) throws IOException {
        int total = 0;

        do {
            int got = channel.read(b);
            if (got < 0) {
                return total == 0 ? -1 : total;
            }

            total += got;
        } while(total != b.capacity() && b.position() != b.capacity());

        return total;
    }

    public static void main(String[] args) {
        File file = new File("F:\\test\\demo.doc");
        try (PushbackInputStream inputStream = new PushbackInputStream(new FileInputStream(file), 6)) {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                int len;
                byte[] buffer = new byte[6];
                if ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                byte[] bytes = outputStream.toByteArray();
                inputStream.unread(bytes);
                ReadableByteChannel channel = Channels.newChannel(inputStream);
                ByteBuffer b = ByteBuffer.allocate(512);
                readFully(channel,b);
                System.out.println(b);
//                int total = 0;
//                do {
//                    int got = channel.read(b);
//                    if (got > 0) {
//                        total += got;
//                    }
//                } while (total != b.capacity() && b.position() != b.capacity());
//                System.out.println(total);

                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try (ZipInputStream inputStream = new ZipInputStream(new FileInputStream(file))) {
//            boolean run = true;
//            while (run) {
//                ZipEntry entry = inputStream.getNextEntry();
//                if (entry == null) {
//                    run = false;
//                } else {
//                    long size = entry.getSize();
//                    if (size > 0L && size < 2147483647L) {
//                        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream((int) size)) {
//                            int len;
//                            byte[] buffer = new byte[1024];
//                            while ((len = inputStream.read(buffer)) != -1) {
//                                outputStream.write(buffer, 0, len);
//                            }
//                            byte[] bytes = outputStream.toByteArray();
//                            System.out.println(new String(bytes, "utf-8"));
//                            outputStream.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                inputStream.closeEntry();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
