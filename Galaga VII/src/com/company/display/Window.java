package com.company.display;

import com.company.Game;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Window extends JFrame implements ActionListener
{   // Attributes
    HomePanel homep;
    GamePanel gamep;
    CreditPanel creditp;
    InstructPanel instructp;

    Game game;

    ImageIcon himg = new ImageIcon("src/com/company/images/GalagaIco copy.png");
    JLabel hmg = new JLabel(himg);

    JLabel homeTitle;
    JButton start;
    JMenuBar homemenu = new JMenuBar();
    JMenu home, instructions, extras;
    JMenuItem instruct, credits, back;

    // Constructor
    public Window(String title, int width, int height)
    {   this.setSize(width, height);
        this.setTitle(title);
        createUI();
    }

    //  Methods (User Interface)
    public void createUI(){
        JPanel panel = new JPanel();
        LayerUI<JComponent> layerUI = new WindowWallpaper();
        JLayer<JComponent> jlayer = new JLayer<JComponent>(panel, layerUI);

        addHomeMenu();
        addHomePanel();
        addHomeImage();
        addStartButton();
        addHomeTitle();
        addGamePanel();
        addCreditPanel();
        addInstructPanel();
        addGame();
        this.add(jlayer);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void addHomePanel(){
        homep = new HomePanel(760, 670);
        homep.setLocation(70, 40);
        this.add(homep);
    }
    public void addHomeImage(){
        hmg.setVisible(true);
        hmg.setBounds(110, 30, 530, 540);
        homep.add(hmg);
    }
    public void addStartButton(){
        start = new JButton();
        start.addActionListener(this);
        start.setText("Start".toUpperCase(Locale.ROOT));
        start.setSize(180, 40);
        start.setLocation(295, 600);
        start.setVisible(true);
        start.setBorder(BorderFactory.createLineBorder(Color.white));
        start.setForeground(Color.white);
        start.setBackground(new Color(40,10,29));
        homep.add(start);
    }
    public void addHomeTitle(){
        homeTitle = new JLabel("Galaga V  '1.6.0 BreakOut Edition'");
        homeTitle.setVisible(true);
        homeTitle.setBounds(215, 20, 390, 30);
        homeTitle.setFont(new Font(null, Font.BOLD, 22));
        homeTitle.setForeground(Color.white);
        homep.add(homeTitle);
    }
    public void addHomeMenu(){
        homemenu.setBackground(Color.black);
        this.setJMenuBar(homemenu);

        home = new JMenu("HOME");
        home.setForeground(Color.gray);
        back = new JMenuItem();
        back.setText("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.darkGray);
        back.addActionListener(this);
        back.setVisible(false);
        home.add(back);
        //home.add(newgame);
        //home.add(shipselect);

        instructions = new JMenu("HOW TO PLAY");
        instruct = new JMenuItem();
        instruct.setText("INSTRUCTIONS");
        instruct.setForeground(Color.darkGray);
        instruct.setBackground(Color.black);
        instruct.addActionListener(this);
        instructions.add(instruct);

        extras = new JMenu("EXTRAS");
        credits = new JMenuItem();
        credits.setText("CREDITS");
        credits.setForeground(Color.darkGray);
        credits.setBackground(Color.black);
        credits.addActionListener(this);
        extras.add(credits);
        //extras.add(credits);
        //extras.add(instruct);

        homemenu.add(home);
        homemenu.add(instructions);
        homemenu.add(extras);
    }
    public void addGame(){
        game = new Game();
        game.setLocation(68, 40);
        game.setVisible(true);
        gamep.add(game);
    }
    public void addGamePanel(){
        gamep = new GamePanel(865, 680);
        gamep.setVisible(false);
        gamep.setLocation(10, 40);
        this.add(gamep);
    }
    public void addCreditPanel() // Adds Credit Panel to Home Screen
    {   creditp = new CreditPanel(760, 670);
        creditp.setVisible(false);
        creditp.setLocation(70, 40);
        this.add(creditp);
    }
    public void addInstructPanel() // Adds Instruction Panel to Home Screen
    {   instructp = new InstructPanel(760, 670);
        instructp.setVisible(false);
        instructp.setLocation(70, 40);
        this.add(instructp);
    }


    // Methods (Actions)
    @Override
    public void actionPerformed(ActionEvent e)
    {   if (start == e.getSource())
        {   homep.setVisible(false);
            gamep.setVisible(true);
            extras.setVisible(false);
            instructions.setVisible(false);
            game.start();
        }
        if (instruct == e.getSource())
        {   homep.setVisible(false);
            gamep.setVisible(false);
            creditp.setVisible(false);
            instructp.setVisible(true);
            back.setVisible(true);

            instructions.setForeground(Color.gray);
            home.setForeground(Color.darkGray);
            extras.setForeground(Color.darkGray);
        }
        if (credits == e.getSource())
        {   homep.setVisible(false);
            gamep.setVisible(false);
            instructp.setVisible(false);
            creditp.setVisible(true);
            back.setVisible(true);

            extras.setForeground(Color.gray);
            home.setForeground(Color.darkGray);
            instructions.setForeground(Color.darkGray);

        }
        if (back == e.getSource())
        {   gamep.setVisible(false);
            instructp.setVisible(false);
            creditp.setVisible(true);
            back.setVisible(false);
            homep.setVisible(true);

            extras.setForeground(Color.darkGray);
            instructions.setForeground(Color.darkGray);
            home.setForeground(Color.gray);
        }
    }
}
