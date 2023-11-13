package com.kuj0j0taro123.swinghash.gui;// TO DO
// ADD A FILE SELECTOR IN A PANEL THAT IS LOCATED AT THE TOP OF THE BORDER LAYOUT
// ADD A CHECKBOX LABEL THAT APPEARS IF YOU PASTE A HASH IN A TEXT BOX AND THE HASHES MATCH
// ADD A COPY TO CLIPBOARD BUTTON
// ADD THEMES
// for the loading bar, you could put it at the bottom, and add all file input streams remaining bytes and then divide

// OPTIONAL : ADD A RESOURCE MONITOR ON THE RIGHT
import com.kuj0j0taro123.swinghash.gui.menubar.ApplicationMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
public class MainFrame extends JFrame implements ActionListener, Serializable {

    Font jetBrainsMono;

    private ChecksumPanel checksumPanel;
    private ChecksumControlPanel checksumControlPanel;
    private FilePickerPanel filePickerPanel;
    private ApplicationMenuBar applicationMenuBar;

    public MainFrame(){
        jetBrainsMono = new Font("Jetbrains Mono", Font.BOLD, 14);

        checksumPanel = new ChecksumPanel();
        checksumControlPanel = new ChecksumControlPanel();
        filePickerPanel = new FilePickerPanel();
        applicationMenuBar = new ApplicationMenuBar();

        setWidgetFont(jetBrainsMono);

        this.addWidgetsToMainFrame();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.DARK_GRAY);
        this.setTitle("SwingHash");
        this.setSize(800,350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void addWidgetsToMainFrame(){
        this.getContentPane().add(BorderLayout.CENTER, checksumPanel);
        this.getContentPane().add(BorderLayout.SOUTH, checksumControlPanel);
        this.getContentPane().add(BorderLayout.NORTH, filePickerPanel);
        this.setJMenuBar(applicationMenuBar);
    }
    private void setWidgetFont(Font font){
        // set fonts -- add a method for this later
        checksumPanel.changeFont(font);
        checksumControlPanel.changeFont(font);
        filePickerPanel.changeFont(font);
    }

    public ChecksumPanel getChecksumPanel(){
        return this.checksumPanel;
    }

    public ChecksumControlPanel getChecksumControlPanel(){
        return this.checksumControlPanel;
    }

    public FilePickerPanel getFilePickerPanel(){
        return this.filePickerPanel;
    }

    public ApplicationMenuBar getApplicationMenuBar(){
        return this.applicationMenuBar;
    }
}

