package com.kuj0j0taro123.swinghash.gui;

import com.kuj0j0taro123.swinghash.Main;
import com.kuj0j0taro123.swinghash.constants.Constants;

public class GUIUpdater {

    public static void startExecution(){
        Main.checksumControlPanel.getHashButton().setVisible(false);
        Main.filePickerPanel.getFileBrowseButton().setEnabled(false);
        Main.checksumControlPanel.getCancelButton().setVisible(true);
        Main.checksumControlPanel.getProgressBar().setVisible(true);
    }

    public static void endExecution(){
        Main.checksumControlPanel.getHashButton().setVisible(true);
        Main.filePickerPanel.getFileBrowseButton().setEnabled(true);
        Main.checksumControlPanel.getCancelButton().setVisible(false);
        Main.checksumControlPanel.getProgressBar().setVisible(false);
        Main.checksumControlPanel.getProgressBar().setValue(0);
    }

    public static void hashButtonUpdate(){
        if (Main.preferencesFrame.getAlgorithmsToRun().size() == 0 || Main.filePickerPanel.getFile() == null)
            Main.checksumControlPanel.getHashButton().setEnabled(false);
        else
            Main.checksumControlPanel.getHashButton().setEnabled(true);
    }

    public static void updateChecksumPanelVisibility(Constants.ChecksumAlgorithm checksumAlgorithm, boolean flag){
        switch (checksumAlgorithm) {
            case MD2 -> {
                Main.checksumPanel.getMd2Label().setVisible(flag);
                Main.checksumPanel.getMd2TextArea().setVisible(flag);
            }
            case MD5 -> {
                Main.checksumPanel.getMd5Label().setVisible(flag);
                Main.checksumPanel.getMd5TextArea().setVisible(flag);
            }
            case SHA1 -> {
                Main.checksumPanel.getSha1Label().setVisible(flag);
                Main.checksumPanel.getSha1TextArea().setVisible(flag);
            }
            case SHA224 -> {
                Main.checksumPanel.getSha224Label().setVisible(flag);
                Main.checksumPanel.getSha224TextArea().setVisible(flag);
            }
            case SHA256 -> {
                Main.checksumPanel.getSha256Label().setVisible(flag);
                Main.checksumPanel.getSha256TextArea().setVisible(flag);
            }
            case SHA384 -> {
                Main.checksumPanel.getSha384Label().setVisible(flag);
                Main.checksumPanel.getSha384TextArea().setVisible(flag);
            }
            case SHA512 -> {
                Main.checksumPanel.getSha512Label().setVisible(flag);
                Main.checksumPanel.getSha512TextArea().setVisible(flag);
            }
            case SHA3_224 -> {
                Main.checksumPanel.getSha3_224Label().setVisible(flag);
                Main.checksumPanel.getSha3_224TextArea().setVisible(flag);
            }
            case SHA3_256 -> {
                Main.checksumPanel.getSha3_256Label().setVisible(flag);
                Main.checksumPanel.getSha3_256TextArea().setVisible(flag);
            }
            case SHA3_384 -> {
                Main.checksumPanel.getSha3_384Label().setVisible(flag);
                Main.checksumPanel.getSha3_384TextArea().setVisible(flag);
            }
            case SHA3_512 -> {
                Main.checksumPanel.getSha3_512Label().setVisible(flag);
                Main.checksumPanel.getSha3_512TextArea().setVisible(flag);
            }
        }
    }
}
