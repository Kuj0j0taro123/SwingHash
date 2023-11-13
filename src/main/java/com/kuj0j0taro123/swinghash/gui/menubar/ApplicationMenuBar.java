package com.kuj0j0taro123.swinghash.gui.menubar;// TODO: add changeFonts method
// MAKE THE APPEARANCE THING A SEPARATE MENU ENTRY WITH FONTS AND THEMES (LIKE DARK/LIGHT THEME)

import com.kuj0j0taro123.swinghash.Main;
import com.kuj0j0taro123.swinghash.gui.menubar.preferences.PreferencesFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class ApplicationMenuBar extends JMenuBar implements ActionListener, Serializable {
    // reference exists to open the file chooser dialogue from File -> Open File menu bar

    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;

    // file
    JMenuItem openFileItem;
    JMenuItem exitItem;
    //edit
    JMenuItem preferencesItem;
    //help
    JMenuItem aboutItem;

    //frames
    PreferencesFrame preferencesFrame;

    public ApplicationMenuBar(){
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        //file
        openFileItem = new JMenuItem("Open File");
        exitItem = new JMenuItem("Exit");
        fileMenu.add(openFileItem);
        fileMenu.add(exitItem);
        //edit
        preferencesItem = new JMenuItem("Preferences");
        editMenu.add(preferencesItem);
        //help
        aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        addActionListeners();


        preferencesFrame = new PreferencesFrame();

        this.add(fileMenu);
        this.add(editMenu);
        this.add(helpMenu);
    }

    private void addActionListeners(){
        openFileItem.addActionListener(this);
        exitItem.addActionListener(this);
        preferencesItem.addActionListener(this);
        aboutItem.addActionListener(this);
    }

    public PreferencesFrame getPreferencesFrame(){
        return this.preferencesFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openFileItem){
            Main.filePickerPanel.actionPerformed(e);
        }
        else if (e.getSource() == exitItem){
            System.exit(0);
        }
        else if (e.getSource() == preferencesItem){
            if (!preferencesFrame.isVisible()) {
                preferencesFrame.setVisible(true);
            }
        }
        else if(e.getSource() == aboutItem){
            System.out.println("Implement the frame with about");

        }
    }
}
