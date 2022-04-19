/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.prj.prj301.qrcodes;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author LucasBV
 */
public class ReadQrCode {

    public static String readQRcode(String path, String charset, Map map) throws FileNotFoundException, IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, NotFoundException {
        // Where QR code stored
//        String path = "C:\\Users\\Acer\\Desktop\\qrcode.png";
        String path = "E:\\FPT\\SEM4_PRJ301\\prj301-take-attendance\\src\\main\\webapp\\qrcode\\2022-02-23PRJ301SE16156.png";
        // Encoding charset
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
        // Generate QR code with Low level(L) error correction capability
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        System.out.println("Content of this OR code: \n" + readQRcode(path, charset, hintMap));

    }
}
