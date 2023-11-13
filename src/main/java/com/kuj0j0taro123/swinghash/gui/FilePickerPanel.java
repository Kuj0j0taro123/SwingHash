package com.kuj0j0taro123.swinghash.gui;

import com.kuj0j0taro123.swinghash.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;

public class FilePickerPanel extends JPanel implements ActionListener, Serializable {
    File file;
    private FileDialog fileDialog;
    private JLabel fileLabel;
    private JTextArea filePathTextArea;
    private JScrollPane filePathScrollBar;
    private JButton fileBrowseButton;

    FilePickerPanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        fileLabel = new JLabel("File:");

        fileDialog = new FileDialog(new Frame(), "Select file", FileDialog.LOAD);

        filePathTextArea = new JTextArea();
        filePathTextArea.setCaretColor(filePathTextArea.getBackground());
        filePathTextArea.setEditable(false);

        filePathScrollBar = new JScrollPane(filePathTextArea);
        filePathScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);


        fileBrowseButton = new JButton("Browse");
        fileBrowseButton.addActionListener(this);
        fileBrowseButton.setFocusable(false);


        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(fileLabel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(filePathScrollBar, gbc);
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 2;
        this.add(fileBrowseButton);
    }

    public void changeFont(Font font){
        fileLabel.setFont(font);
        filePathTextArea.setFont(font);
        fileBrowseButton.setFont(font);
    }



    public File getFile(){
        return this.file;
    }

    public JButton getFileBrowseButton(){
        return this.fileBrowseButton;
    }

    // this action listener will display the system's file picker dialog window
    @Override
    public void actionPerformed(ActionEvent e) {
        // thread will stop here until an action happens inside the file dialog
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null){
            String filePathString = fileDialog.getDirectory() + fileDialog.getFile();
            file = Path.of(filePathString).toFile();
            filePathTextArea.setText(filePathString);
            Main.checksumPanel.clearTextAreas();
            GUIUpdater.hashButtonUpdate();
        }
    }

}
