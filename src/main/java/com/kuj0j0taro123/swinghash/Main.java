package com.kuj0j0taro123.swinghash;

import com.kuj0j0taro123.swinghash.gui.*;
import com.kuj0j0taro123.swinghash.gui.menubar.ApplicationMenuBar;
import com.kuj0j0taro123.swinghash.gui.menubar.PreferencesFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static MainFrame mainFrame;
    public static ChecksumPanel checksumPanel;
    public static FilePickerPanel filePickerPanel;
    public static ChecksumControlPanel checksumControlPanel;
    public static ApplicationMenuBar applicationMenuBar;
    public static PreferencesFrame preferencesFrame;

    public static ThreadPoolExecutor executor;

    public static List<CheckSum> activeThreads;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch(Exception ex){
            ex.printStackTrace();
        }

        executor = new ExtendedExecutor(11, 11,
                100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        activeThreads = new ArrayList<>();
        mainFrame = new MainFrame();

        checksumPanel = mainFrame.getChecksumPanel();
        filePickerPanel = mainFrame.getFilePickerPanel();
        checksumControlPanel = mainFrame.getChecksumControlPanel();
        applicationMenuBar = mainFrame.getApplicationMenuBar();
        preferencesFrame = applicationMenuBar.getPreferencesFrame();
        preferencesFrame.checkboxStateChangedHandler();

        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }
    }
}