/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.prj.prj301.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 *
 * @author LucasBV
 */
public class GenerateQrCode {

    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws UnsupportedEncodingException, WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.')+ 1) , new File(path));

//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, w, h);
//        Path paths = FileSystems.getDefault().getPath(path);
//        MatrixToImageWriter.writeToPath(matrix, "PNG", paths);

    }
}
