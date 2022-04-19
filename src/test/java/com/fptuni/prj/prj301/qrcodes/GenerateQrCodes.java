/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.prj.prj301.qrcodes;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LucasBV
 */
public class GenerateQrCodes {

    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws UnsupportedEncodingException, WriterException, IOException {
        // BitMatrix class --> 2D matrix of bits
        // MultiFormatWriter find Writer subclass for BarcodeFormat requested
        // and encodes the bar code with the supplies content
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));


//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, w, h);
//        Path paths = FileSystems.getDefault().getPath(path);
//        MatrixToImageWriter.writeToPath(matrix, "PNG", paths);
    }

    public static void main(String[] args) throws WriterException, IOException {
//         Data stored in QR code

        String data = "https://www.facebook.com/LucasBinhVien";
        // Where to get QR code 
        String path = "E:\\FPT\\SEM4_PRJ301\\prj301-take-attendance\\src\\main\\webapp\\qrcode\\2.png";
        //Encoding charset
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();
        // Generate QR code with Low level(L) error correction capability
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // Create QR method
        generateQRcode(data, path, charset, hashMap, 200, 200);

        System.out.println("QR code is generated successfully");
    }
    
}
