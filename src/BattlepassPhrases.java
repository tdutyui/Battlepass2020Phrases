import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class BattlepassPhrases implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private String filepath = "C:/Users/evgen/Battlepass2020Phrases/phrases/";
    private ArrayList<String> buttonActions = new ArrayList<String>();
    private String[] phrases = {filepath + "Misc_soundboard_ni_xing_ni.mp3",
            filepath + "Misc_soundboard_wo_shi_yi.mp3",
            filepath + "Misc_soundboard_lai_ni_da.mp3",
            filepath + "Misc_soundboard_duiyou_ne.mp3",
            filepath + "Misc_soundboard_liu_liu_liu.mp3",
            filepath + "Misc_soundboard_zai_jian_le_bao_bei.mp3",
            filepath + "Misc_soundboard_ni_qi_bu_qi.mp3",
            filepath + "Misc_soundboard_gan_ma_ne_xiong_di.mp3"};

    public BattlepassPhrases() {

        ArrayList<JButton> buttons = new ArrayList<JButton>();

        JButton nishi = new JButton("你行你行，你上你上");
        nishi.addActionListener(this);
        nishi.setActionCommand("nishi");
        buttonActions.add("nishi");
        nishi.setBounds(25, 50, 200, 20);
        buttons.add(nishi);

        JButton farm = new JButton("\n" +
                " 我是一个没有感情的刷钱机器");
        farm.addActionListener(this);
        farm.setActionCommand("farm");
        buttonActions.add("farm");
        farm.setBounds(260, 50, 200, 20);
        buttons.add(farm);

        JButton hitme = new JButton("来，你打我呀！");
        hitme.addActionListener(this);
        hitme.setActionCommand("hit");
        buttonActions.add("hit");
        hitme.setBounds(25, 100, 200, 20);
        buttons.add(hitme);

        JButton teammates = new JButton("啊，队友呢？队友呢？队友呢？！队友呢？！？！");
        teammates.addActionListener(this);
        teammates.setActionCommand("help");
        buttonActions.add("help");
        teammates.setBounds(260, 100, 200, 20);
        buttons.add(teammates);

        JButton wp = new JButton("这波不亏, 666");
        wp.addActionListener(this);
        wp.setActionCommand("666");
        buttonActions.add("666");
        wp.setBounds(25, 150, 200, 20);
        buttons.add(wp);

        JButton baby = new JButton("再见了宝贝儿！");
        baby.addActionListener(this);
        baby.setActionCommand("baby");
        buttonActions.add("baby");
        baby.setBounds(260, 150, 200, 20);
        buttons.add(baby);

        JButton angry = new JButton("你气不气?");
        angry.addActionListener(this);
        angry.setActionCommand("?");
        buttonActions.add("?");
        angry.setBounds(25, 200, 200, 20);
        buttons.add(angry);

        JButton bro = new JButton("干嘛呢兄弟");
        bro.addActionListener(this);
        bro.setActionCommand("bro");
        buttonActions.add("bro");
        bro.setBounds(260, 200, 200, 20);
        buttons.add(bro);

        panel = new JPanel();
        panel.setLayout(null);
        for (JButton button : buttons) {
            panel.add(button);
        }

        frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Battlepass 2020 Phrases");
        frame.setSize(500, 350);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BattlepassPhrases();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        for (int i = 0; i<buttonActions.size(); i++) {
            if (action.equals(buttonActions.get(i))) {
                try {
                    playPhrase(phrases[i]);
                } catch (JavaLayerException | FileNotFoundException javaLayerException) {
                    javaLayerException.printStackTrace();
                }
            }
        }
    }

    public static void playPhrase(String path) throws JavaLayerException, FileNotFoundException {
        FileInputStream phrase = new FileInputStream(path);
        Player audio = new Player(phrase);
        audio.play();
    }
}

