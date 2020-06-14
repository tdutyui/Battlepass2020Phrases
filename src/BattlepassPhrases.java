import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BattlepassPhrases implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private String filepath = "C:/Users/evgen/Battlepass2020Phrases/phrases/";
    private HashMap<String, String> actionAndPhrases = new HashMap<String, String>();

    public BattlepassPhrases() {

        ArrayList<JButton> buttons = new ArrayList<JButton>();

        JButton nishi = new JButton("你行你行，你上你上");
        nishi.addActionListener(this);
        nishi.setActionCommand("nishi");
        actionAndPhrases.put("nishi", filepath + "Misc_soundboard_ni_xing_ni.mp3");
        nishi.setBounds(25, 50, 200, 20);
        buttons.add(nishi);

        JButton farm = new JButton("\n" +
                " 我是一个没有感情的刷钱机器");
        farm.addActionListener(this);
        farm.setActionCommand("farm");
        actionAndPhrases.put("farm", filepath + "Misc_soundboard_wo_shi_yi.mp3");
        farm.setBounds(260, 50, 200, 20);
        buttons.add(farm);

        JButton hitme = new JButton("来，你打我呀！");
        hitme.addActionListener(this);
        hitme.setActionCommand("hit");
        actionAndPhrases.put("hit", filepath + "Misc_soundboard_lai_ni_da.mp3");
        hitme.setBounds(25, 100, 200, 20);
        buttons.add(hitme);

        JButton teammates = new JButton("啊，队友呢？队友呢？队友呢？！队友呢？！？！");
        teammates.addActionListener(this);
        teammates.setActionCommand("help");
        actionAndPhrases.put("help", filepath + "Misc_soundboard_duiyou_ne.mp3");
        teammates.setBounds(260, 100, 200, 20);
        buttons.add(teammates);

        JButton wp = new JButton("这波不亏, 666");
        wp.addActionListener(this);
        wp.setActionCommand("666");
        actionAndPhrases.put("666", filepath + "Misc_soundboard_liu_liu_liu.mp3");
        wp.setBounds(25, 150, 200, 20);
        buttons.add(wp);

        JButton baby = new JButton("再见了宝贝儿！");
        baby.addActionListener(this);
        baby.setActionCommand("baby");
        actionAndPhrases.put("baby", filepath + "Misc_soundboard_zai_jian_le_bao_bei.mp3");
        baby.setBounds(260, 150, 200, 20);
        buttons.add(baby);

        JButton angry = new JButton("你气不气?");
        angry.addActionListener(this);
        angry.setActionCommand("?");
        actionAndPhrases.put("?", filepath + "Misc_soundboard_ni_qi_bu_qi.mp3");
        angry.setBounds(25, 200, 200, 20);
        buttons.add(angry);

        JButton bro = new JButton("干嘛呢兄弟");
        bro.addActionListener(this);
        bro.setActionCommand("bro");
        actionAndPhrases.put("bro", filepath + "Misc_soundboard_gan_ma_ne_xiong_di.mp3");
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

    public static void playPhrase(String path) throws JavaLayerException, FileNotFoundException {
        FileInputStream phrase = new FileInputStream(path);
        Player audio = new Player(phrase);
        audio.play();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        for (String key: actionAndPhrases.keySet()) {
            if (key.equals(action)) {
                try {
                    playPhrase(actionAndPhrases.get(key));
                } catch (JavaLayerException | FileNotFoundException javaLayerException) {
                    javaLayerException.printStackTrace();
                }
            }
        }
    }
}

