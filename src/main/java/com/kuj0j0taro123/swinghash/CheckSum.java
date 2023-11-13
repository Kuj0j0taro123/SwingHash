package com.kuj0j0taro123.swinghash;

import com.kuj0j0taro123.swinghash.constants.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CheckSum implements Runnable{


    private final int bufferSize = 32 * 1024 * 1024;

    //needed for JProgressBar because if the file is too large, it can't process it in bytes, so it does it in KiB
    private final int bufferSizeInKib = bufferSize / 1024;


    private final String algorithm;
    private final File file;
    public boolean stop = false;
    private byte[] checkSumByteArray;



    public CheckSum(Constants.ChecksumAlgorithm checksumAlgorithm, File file){
        switch (checksumAlgorithm) {
            case MD2 -> this.algorithm = "MD2";
            case MD5 -> this.algorithm = "MD5";
            case SHA1 -> this.algorithm = "SHA1";
            case SHA224 -> this.algorithm = "SHA224";
            case SHA256 -> this.algorithm = "SHA256";
            case SHA384 -> this.algorithm = "SHA384";
            case SHA512 -> this.algorithm = "SHA512";
            case SHA3_224 -> this.algorithm = "SHA3-224";
            case SHA3_256 -> this.algorithm = "SHA3-256";
            case SHA3_384 -> this.algorithm = "SHA3-384";
            case SHA3_512 -> this.algorithm = "SHA3-512";
            default -> this.algorithm = null;
        }
        this.file = file;
    }

    @Override
    public void run() {
        Main.activeThreads.add(this);
        System.out.println("MiB: " + bufferSize);
        System.out.println("KiB: " + bufferSizeInKib);

        String output = calculateChecksum(algorithm, file);
        switch (algorithm) {
            case "MD2" -> Main.checksumPanel.getMd2TextArea().setText(output);
            case "MD5" -> Main.checksumPanel.getMd5TextArea().setText(output);
            case "SHA1" -> Main.checksumPanel.getSha1TextArea().setText(output);
            case "SHA224" -> Main.checksumPanel.getSha224TextArea().setText(output);
            case "SHA256" -> Main.checksumPanel.getSha256TextArea().setText(output);
            case "SHA384" -> Main.checksumPanel.getSha384TextArea().setText(output);
            case "SHA512" -> Main.checksumPanel.getSha512TextArea().setText(output);
            case "SHA3-224" -> Main.checksumPanel.getSha3_224TextArea().setText(output);
            case "SHA3-256" -> Main.checksumPanel.getSha3_256TextArea().setText(output);
            case "SHA3-384" -> Main.checksumPanel.getSha3_384TextArea().setText(output);
            case "SHA3-512" -> Main.checksumPanel.getSha3_512TextArea().setText(output);
        }
        Main.activeThreads.remove(this);
    }

    private String calculateChecksum(String algorithm, File file){

        byte [] buffer = new byte[bufferSize];
        int bytesRead;
        try (FileInputStream fis = new FileInputStream(file)){
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            while ((bytesRead = fis.read(buffer)) != -1){
                System.out.println(bytesRead);
                digest.update(buffer, 0, bytesRead);
                Main.checksumControlPanel.getProgressBar().setValue(
                        Main.checksumControlPanel.getProgressBar().getValue() + bufferSizeInKib);
                if (stop) {
                    fis.close();
                    digest.reset();
                    return "";
                }
            }
            checkSumByteArray = digest.digest();
        } catch (IOException | NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }

        return buildChecksumString();
    }

    private String buildChecksumString(){
        StringBuilder ret = new StringBuilder();
        for (byte b : checkSumByteArray) {
            ret.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return ret.toString();
    }
}
