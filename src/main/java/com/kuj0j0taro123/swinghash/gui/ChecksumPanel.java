package com.kuj0j0taro123.swinghash.gui;

import com.kuj0j0taro123.swinghash.constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChecksumPanel extends JPanel implements Serializable {
    private JLabel md2Label;
    private JLabel md5Label;
    private JLabel sha1Label;
    private JLabel sha224Label;



    private JLabel sha256Label;
    private JLabel sha384Label;
    private JLabel sha512Label;
    private JLabel sha3_224Label;
    private JLabel sha3_256Label;
    private JLabel sha3_384Label;
    private JLabel sha3_512Label;

    private JTextArea md2TextArea;
    private JTextArea md5TextArea;
    private JTextArea sha1TextArea;
    private JTextArea sha224TextArea;
    private JTextArea sha256TextArea;
    private JTextArea sha384TextArea;
    private JTextArea sha512TextArea;
    private JTextArea sha3_224TextArea;
    private JTextArea sha3_256TextArea;
    private JTextArea sha3_384TextArea;
    private JTextArea sha3_512TextArea;


    private List<JLabel> algorithmLabels;
    public List<JTextArea> checksumTextAreas;

    ChecksumPanel(){
        this.setLayout(new GridBagLayout());
        // checksumTextAreas.forEach(algoTextArea -> algoTextArea.setEditable(false));
        init();
    }

    private List<JLabel> createAlgorithmLabels(){
        List<JLabel> ret = new ArrayList<>();

        md2Label = new JLabel("MD2:");
        md5Label = new JLabel("MD5:");
        sha1Label = new JLabel("SHA1:");
        sha224Label = new JLabel("SHA224:");
        sha256Label = new JLabel("SHA256:");
        sha384Label = new JLabel("SHA384:");
        sha512Label = new JLabel("SHA512:");
        sha3_224Label = new JLabel("SHA3-224:");
        sha3_256Label = new JLabel("SHA3-256:");
        sha3_384Label = new JLabel("SHA3-384:");
        sha3_512Label = new JLabel("SHA3-512:");

        ret.add(md2Label);
        ret.add(md5Label);
        ret.add(sha1Label);
        ret.add(sha224Label);
        ret.add(sha256Label);
        ret.add(sha384Label);
        ret.add(sha512Label);
        ret.add(sha3_224Label);
        ret.add(sha3_256Label);
        ret.add(sha3_384Label);
        ret.add(sha3_512Label);

        return ret;
    }

    private List<JTextArea> createChecksumTextAreas(){
        List<JTextArea> ret = new ArrayList<>();

        md2TextArea = new JTextArea();
        md5TextArea = new JTextArea();
        sha1TextArea = new JTextArea();
        sha224TextArea = new JTextArea();
        sha256TextArea = new JTextArea();
        sha384TextArea = new JTextArea();
        sha512TextArea = new JTextArea();
        sha3_224TextArea = new JTextArea();
        sha3_256TextArea = new JTextArea();
        sha3_384TextArea = new JTextArea();
        sha3_512TextArea = new JTextArea();

        ret.add(md2TextArea);
        ret.add(md5TextArea);
        ret.add(sha1TextArea);
        ret.add(sha224TextArea);
        ret.add(sha256TextArea);
        ret.add(sha384TextArea);
        ret.add(sha512TextArea);
        ret.add(sha3_224TextArea);
        ret.add(sha3_256TextArea);
        ret.add(sha3_384TextArea);
        ret.add(sha3_512TextArea);

        return ret;
    }

    private void init(){
        algorithmLabels = createAlgorithmLabels();
        checksumTextAreas = createChecksumTextAreas();

        // makes the caret invisible
        checksumTextAreas.forEach(algoTextArea -> algoTextArea.setCaretColor(algoTextArea.getBackground()));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1,1,1,1);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        for (int i = 0; i < Constants.ChecksumAlgorithm.values().length; i++){
            gbc.weightx = 0;
            gbc.gridy = i;
            gbc.gridx = 0;
            this.add(algorithmLabels.get(i), gbc);
            gbc.weightx = 1.0d;
            gbc.gridx = 1;
            this.add(checksumTextAreas.get(i), gbc);
        }
    }

    public void changeFont(Font font){
        algorithmLabels.forEach(label -> label.setFont(font));
        checksumTextAreas.forEach(textArea -> textArea.setFont(font));
    }



    public void clearTextAreas(){
        checksumTextAreas.forEach(textArea -> textArea.setText(""));
    }

    public JTextArea getMd2TextArea() {
        return md2TextArea;
    }

    public JTextArea getMd5TextArea() {
        return md5TextArea;
    }

    public JTextArea getSha1TextArea() {
        return sha1TextArea;
    }

    public JTextArea getSha224TextArea() {
        return sha224TextArea;
    }

    public JTextArea getSha256TextArea() {
        return sha256TextArea;
    }

    public JTextArea getSha384TextArea() {
        return sha384TextArea;
    }

    public JTextArea getSha512TextArea() {
        return sha512TextArea;
    }

    public JTextArea getSha3_224TextArea() {
        return sha3_224TextArea;
    }

    public JTextArea getSha3_256TextArea() {
        return sha3_256TextArea;
    }

    public JTextArea getSha3_384TextArea() {
        return sha3_384TextArea;
    }

    public JTextArea getSha3_512TextArea() {
        return sha3_512TextArea;
    }

    public JLabel getMd2Label() {
        return md2Label;
    }

    public JLabel getMd5Label() {
        return md5Label;
    }

    public JLabel getSha1Label() {
        return sha1Label;
    }

    public JLabel getSha224Label() {
        return sha224Label;
    }

    public JLabel getSha256Label() {
        return sha256Label;
    }

    public JLabel getSha384Label() {
        return sha384Label;
    }

    public JLabel getSha512Label() {
        return sha512Label;
    }

    public JLabel getSha3_224Label() {
        return sha3_224Label;
    }

    public JLabel getSha3_256Label() {
        return sha3_256Label;
    }

    public JLabel getSha3_384Label() {
        return sha3_384Label;
    }

    public JLabel getSha3_512Label() {
        return sha3_512Label;
    }

}


