package edu.guilford;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AdventureGame {

    // attributes
    private JFrame window;
    private Container base;
    private JPanel authorScreen, titleScreen, startButtonPanel, narrativePanel, choicesPanel, healthPanel;
    private JLabel authorNameLabel, titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    private Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 40);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    private JButton startButton, choice1, choice2, choice3;
    private JTextArea narrativeArea;
    private int wolfHP, demiHP, goldRing;
    private String position;
    private Player player1;

    private titleScreenHandler tsHandler = new titleScreenHandler();
    private ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        // TODO code application logic here

        new AdventureGame();
    }

    public AdventureGame() {

        // Creating the window that will pop up whenever the program runs
        window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        base = window.getContentPane();

        // creating the starting title screen
        titleScreen = new JPanel();
        titleScreen.setBounds(100, 100, 600, 100);
        titleScreen.setBackground(Color.BLACK);

        // author note Panel
        authorScreen = new JPanel();
        authorScreen.setBounds(230, 230, 350, 700);
        authorScreen.setBackground(Color.black);

        // author note Label
        authorNameLabel = new JLabel("-Axel Sandoval");
        authorNameLabel.setForeground(Color.white);
        authorNameLabel.setFont(normalFont);

        // add the JLabel containing the title
        titleNameLabel = new JLabel("Choose Your Own Destiny");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        // create panel for start button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        // create start button
        startButton = new JButton("START");
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        // startButton.setFocusPainted(false);

        // add the title & start button to their respective JPanels
        titleScreen.add(titleNameLabel);
        startButtonPanel.add(startButton);
        authorScreen.add(authorNameLabel);

        // add panels to the JFRAME
        base.add(titleScreen);
        base.add(startButtonPanel);
        base.add(authorScreen);
        window.pack();
        window.setSize(800, 600);
        window.setVisible(true);

    }

    // class that runs when start button is pressed
    public void createGameScreen() {

        // remove the start screen and start button panels
        titleScreen.setVisible(false);
        startButtonPanel.setVisible(false);
        authorScreen.setVisible(false);

        // create the JPanel that will contain narration
        narrativePanel = new JPanel();
        narrativePanel.setBounds(100, 100, 600, 250);
        narrativePanel.setBackground(Color.black);
        base.add(narrativePanel);

        // add narration text
        narrativeArea = new JTextArea();
        narrativeArea.setBounds(100, 100, 600, 250);
        narrativeArea.setWrapStyleWord(true);
        narrativeArea.setBackground(Color.black);
        narrativeArea.setForeground(Color.white);
        narrativeArea.setFont(normalFont);
        // wraps text so it wont overlap
        narrativeArea.setLineWrap(true);
        narrativePanel.add(narrativeArea);

        // add a panel that will contain button choices
        choicesPanel = new JPanel();
        choicesPanel.setBounds(250, 350, 300, 150);
        choicesPanel.setBackground(Color.black);
        choicesPanel.setLayout(new GridLayout(3, 1));
        base.add(choicesPanel);

        // add choice 1
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setFont(normalFont);
        choicesPanel.add(choice1);
        // choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");

        // add choice 2
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.BLACK);
        choice2.setFont(normalFont);
        choicesPanel.add(choice2);
        // choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        // add choice 3
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.BLACK);
        choice3.setFont(normalFont);
        choicesPanel.add(choice3);
        // choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        // add a panel that will contain hp and weapon
        healthPanel = new JPanel();
        healthPanel.setBounds(100, 15, 600, 50);
        healthPanel.setBackground(Color.white);
        healthPanel.setLayout(new GridLayout(1, 4));
        base.add(healthPanel);

        // add a hp section
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.black);
        healthPanel.add(hpLabel);

        // appropriate hp will show up here
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.black);
        healthPanel.add(hpLabelNumber);

        // add a weapon section
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.black);
        healthPanel.add(weaponLabel);

        // appropiate weapon will show up
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.black);
        healthPanel.add(weaponLabelName);

        // runs method for hp and weapon
        playerSetup();
    }

    // method that sets the display for hp and weapon
    public void playerSetup() {
        player1 = new Player(20, "Fists");

        // playerHP = 20;
        wolfHP = 10;
        demiHP = 20;
        // weapon = "Fists";
        weaponLabelName.setText(player1.getWeapon());
        hpLabelNumber.setText("" + player1.getPlayerHP());
        hauntedStart();
    }

    // method that gives first scene
    public void hauntedStart() {
        position = "hauntedStart";
        narrativeArea.setText(
                "One day you wake up and decide that you NEED to explore the haunted forest located in the local town. \n \nYou think that you can become the town hero by defeating the fabled Demigorgon.");
        setButtonText2("Continue", "", "");
        // choice1.setText("Continue");
        // choice2.setText("");
        // choice3.setText("");

    }

    // method that gives what happens if you; talk to the sheriff
    public void sheriffStation() {
        position = "sheriffStation";
        narrativeArea.setText(
                "You decide to head into the sheriff's station to try and gather intel. \n \n Sheriff: ''I am the Sheriff of this town, you are a fool for trying to play hero.'' \n \n What next?");
        setButtonText("Keep talking", "Sheriff=Witch!", "Leave the station");
        // choice1.setText("Keep talking");
        // choice2.setText("Sheriff=Witch!");
        // choice3.setText("Leave the station");
    }

    public void talkSheriff() {
        position = "talkSheriff";
        narrativeArea.setText(
                "Sheriff: ''I'll tell you this... All I know is that that Demon has always been spotted deep in the woods, and I heard that it resides in a cabin.''\n \n You exit the sheriff's office.");
        setButtonText2("Interesting...", "", "");
        // choice1.setText("Enter Woods");
        // choice2.setText("Go to your car");
        // choice3.setText("Go across the St.");
    }

    // what happens when you; attack the sheriff
    public void attackSheriff() {
        position = "attackSheriff";
        narrativeArea.setText(
                "You attempt to attack the sheriff, believing that he is connected to the Demigorgon. He smacks you with his baton and after you gain consciousness, he assures you that he is on your team.  (-3 Damage)");
        player1.setPlayerHP(player1.getPlayerHP() - 3);
        updatePlayerLabel();
        // hpLabelNumber.setText("" + player1.getHP());
        setButtonText2("Take the L", "", "");
        // choice1.setText("< Take the L");
        // choice2.setText("");
        // choice3.setText("");
    }

    // what happens when you; leave
    public void nextLocation() {
        position = "nextLocation";
        narrativeArea.setText("You proceed to leave the station. \n \n So many options... Where to next?");
        setButtonText("Enter the Woods", "Go to your car", "Enter Gas Station");
        // choice1.setText("Go Left");
        // choice2.setText("Go Right");
        // choice3.setText("Cross the bridge");
    }

    // decide to enter the woods: rabid wolf encounter
    public void enterWoods() {
        position = "enterWoods";
        narrativeArea.setText(
                "You decide to enter the woods, and you begin to walk. \n After walking for a while, you notice a rabid wolf posted up between you and a cabin!  \nWhat do you choose to do next?");
        setButtonText3("Fight", "Retreat", "");
        // choice1.setText("Fight");
        // choice2.setText("RUN");
        // choice3.setText("");
    }

    // go across to the gas station: aquire health
    public void goAcross() {
        position = "across";
        narrativeArea.setText(
                "You choose to go across the street into the gas station, but all you see are hot cheetos and takis. You decide to eat some takis. \n \n (+2 hp)");
        player1.setPlayerHP(player1.getPlayerHP() + 2);
        updatePlayerLabel();
        setButtonText2("Go Back", "", "");
        // playerHP = playerHP + 2;
        // hpLabelNumber.setText("" + playerHP);
        // choice1.setText("go back");
        // choice2.setText("");
        // choice3.setText("");
    }

    // go to your car scene : aquire dagger
    public void goCar() {
        position = "goCar";
        narrativeArea.setText(
                "you decide to go back to your car, and aquire your trusted Dagger. \n \n(Dagger Damage: + 6)");
        player1.setWeapon("Dagger");
        updatePlayerLabel();
        setButtonText2("Continue", "", "");

        // weapon = "Dagger";
        // weaponLabelName.setText(weapon);
        // choice1.setText("< Continue");
        // choice2.setText("");
        // choice3.setText("");
    }

    // choose to fight the wolf : fight
    public void fight() {
        position = "fight";
        narrativeArea.setText("Wolf HP: " + wolfHP + "\n what do you do?");
        setButtonText3("Attack", "Retreat", "");
        // choice1.setText("Attack");
        // choice2.setText("Retreat");
        // choice3.setText("");

    }

    // attack damage on wolf; player attack
    public void playerAttack() {
        position = "playerAttack";

        int playerDamage = 0;
        setButtonText("Continue...", "", "");
        if (player1.getWeapon().equals("Fists")) {
            playerDamage = new java.util.Random().nextInt(4);
        } else if (player1.getWeapon().equals("Dagger")) {
            playerDamage = new java.util.Random().nextInt(7);
        }
        narrativeArea.setText("You attack the wolf and gave it " + playerDamage + " damage! " + "\n \n(-" + playerDamage
                + " damage)");

        wolfHP = wolfHP - playerDamage;
        setButtonText2("Continue...", "", "");

        // choice1.setText(">");
        // choice2.setText("");
        // choice3.setText("");
    }

    // wolf fights back; wolf attack
    public void wolfAttack() {
        position = "wolfAttack";
        int wolfDamage = 0;
        setButtonText("Continue...", "", "");
        wolfDamage = new java.util.Random().nextInt(8);
        narrativeArea.setText("The wolf doesn't like that, so it attacks you viciously, giving you " + wolfDamage
                + " damage! " + "\n \n(-" + wolfDamage + " damage)");
        player1.setPlayerHP(player1.getPlayerHP() - wolfDamage);
        updatePlayerLabel();
        setButtonText2("Continue...", "", "");

        // playerHP = playerHP - bossAttack;
        // hpLabelNumber.setText("" + playerHP);
        // choice1.setText(">");
        // choice2.setText("");
        // choice3.setText("");
    }

    // win against wolf
    public void win1() {
        position = "win1";
        narrativeArea.setText("You slay the wolf, and it drops dead, allowing you to pass and reach the cabin.");
        setButtonText2("Continue...", "", "");

        // choice1.setText("Continue >");
        // choice2.setText("");
        // choice3.setText("");
    }

    // entering cabin after defeating wolf
    public void enterCabin() {
        position = "enterCabin";
        narrativeArea.setText(
                "You enter the cabin, unsure about your life decisions. You see that you have two options now... Go upstairs into the scary dark room, or go downstairs into the dark scary room...");
        setButtonText3("Go Up", "Go Down", "");

        // choice1.setText("Go Up");
        // choice2.setText("Go Down");
        // choice3.setText("");
    }

    // go upstairs : fight demon
    public void goUp() {
        position = "goUp";
        narrativeArea.setText(
                "You decide to head upstairs. Oh man Oh man! You find yourself face to face with the Demigorgon. No choice left now but to fight!");
        setButtonText2("Boss Fight!", "", "");

        // choice1.setText("Boss Fight!");
        // choice2.setText("");
        // choice3.setText("");
    }

    // go downstairs: gain health + new weapon
    public void goDown() {
        position = "goDown";
        narrativeArea.setText(
                "You decide to head downstairs, to the more intimidating area. (questionable decision) But you see a Machete on a table just laying there, waiting for you to aquire it. (Machete Damage: +12)"
                        + "You also see a can of beans in the corner and decide to eat it. (+ 6 hp)");
        player1.setWeapon("Machete");
        player1.setPlayerHP(player1.getPlayerHP() + 6);
        updatePlayerLabel();
        setButtonText2("Go Upstairs...", "", "");

        // choice1.setText("Boss Fight!");
        // choice2.setText("");
        // choice3.setText("");
    }

    // final fight scene
    public void bossFight() {
        position = "bossFight";
        narrativeArea
                .setText("Demigorgon HP: " + demiHP + "\n what's your next move? You only have one move left hahaha");
        setButtonText2("Attack", "", "");

        // choice1.setText("Attack");
        // choice2.setText("");
        // choice3.setText("");
    }

    // boss attack +12 damage random
    public void bossAttack() {
        position = "bossAttack";
        int bossAttack = 0;
        bossAttack = new java.util.Random().nextInt(12);
        narrativeArea.setText(
                "The Demigorgon snaps back, and attacks you with an extraterrestrial out of this world light beam, giving you "
                        + bossAttack + " damage! " + "(-" + bossAttack + " damage)");
        player1.setPlayerHP(player1.getPlayerHP() - bossAttack);
        updatePlayerLabel();
        // playerHP = playerHP - bossAttack;
        // hpLabelNumber.setText("" + playerHP);
        setButtonText2("Continue...", "", "");

        // choice1.setText(">");
        // choice2.setText("");
        // choice3.setText("");
    }

    // player final attack : based on weapon
    public void finalAttack() {
        position = "finalAttack";

        int playerDamage = 0;

        if (player1.getWeapon().equals("Fists")) {
            playerDamage = new java.util.Random().nextInt(4);
        } else if (player1.getWeapon().equals("Dagger")) {
            playerDamage = new java.util.Random().nextInt(7);
        } else if (player1.getWeapon().equals("Machete")) {
            playerDamage = new java.util.Random().nextInt(10);
        }
        narrativeArea.setText(
                "FACE TO FACE WITH THE DEMIGORGON! \n You decide that there's really no other option here, and you attack the Demigorgon. You do "
                        + playerDamage + " damage! " + "(-" + playerDamage + " damage)");
        demiHP = demiHP - playerDamage;
        setButtonText2("Continue...", "", "");

        // choice1.setText(">");
        // choice2.setText("");
        // choice3.setText("");
    }

    // lose screen
    public void lose() {
        position = "lose";
        narrativeArea.setText("You are dead. GAME OVER.");
        setButtonText2("Restart", "", "");

        // choice1.setText("Restart");
        // choice2.setText("");
        // choice2.setVisible(false);
        // choice3.setText("");
        // choice3.setVisible(false);
    }

    // final win: defeat demon
    public void win2() {
        position = "win2";
        narrativeArea.setText(
                "Oh wow... You actually defeated the Demigorgon. \n It drops dead and from within its evaporating corpse, it drops a golden ring. (ring +1)");
        goldRing = 1;
        setButtonText2("Continue", "", "");

        // choice1.setText("Continue >");
        // choice2.setText("");
        // choice3.setText("");
    }

    // ending scene
    public void ending() {
        position = "ending";
        narrativeArea.setText(
                "Congratulations. You defeated the Demigorgon and became the town hero. No one believed in you but you. Go on and be a hero somewhere else now.\n \n \n  THE END ");
        choice1.setText("");
        choice1.setVisible(false);
        choice2.setText("");
        choice2.setVisible(false);
        choice3.setText("");
        choice3.setVisible(false);

    }

    // make a method updating labels.
    public void updatePlayerLabel() {
        weaponLabelName.setText(player1.getWeapon());
        hpLabelNumber.setText("" + player1.getPlayerHP());

    }

    // set buttons to show all 3 buttons
    public void setButtonText(String c1, String c2, String c3) {
        choice1.setText(c1);
        choice2.setText(c2);
        choice2.setVisible(true);
        choice3.setText(c3);
        choice3.setVisible(true);

    }

    // set buttons so only first button is visible
    public void setButtonText2(String c1, String c2, String c3) {
        choice1.setText(c1);
        choice2.setText("");
        choice2.setVisible(false);
        choice3.setText("");
        choice3.setVisible(false);

    }

    // set buttons so only first two buttons are visible
    public void setButtonText3(String c1, String c2, String c3) {
        choice1.setText(c1);
        choice2.setText(c2);
        choice2.setVisible(true);
        choice3.setText("");
        choice3.setVisible(false);

    }

    // action performed once the start button is clicked.
    public class titleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    // class that registers what choice is selected
    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            // opening scene
            switch (position) {
                case "hauntedStart":
                    switch (yourChoice) {
                        case "c1":
                            sheriffStation();
                            break;
                    }

                    // Sheriff Station scene
                    break;
                case "sheriffStation":
                    switch (yourChoice) {
                        case "c1":
                            talkSheriff();
                            break;
                        case "c2":
                            attackSheriff();
                            break;
                        case "c3":
                            nextLocation();
                            break;
                    }

                    // talk to the sheriff
                    break;
                case "talkSheriff":
                    switch (yourChoice) {
                        case "c1":
                            sheriffStation();
                            break;
                        case "c2":
                            sheriffStation();
                            break;
                        case "c3":
                            nextLocation();
                            break;
                    }

                    // attack the sheriff scene
                    break;
                case "attackSheriff":
                    switch (yourChoice) {
                        case "c1":
                            if (player1.getPlayerHP() < 1) {
                                lose();
                            } else {
                                sheriffStation();

                            }
                            break;
                    }

                    // next location scene
                    break;
                case "nextLocation":
                    switch (yourChoice) {
                        case "c1":
                            enterWoods();
                            break;
                        case "c2":
                            goCar();
                            break;
                        case "c3":
                            goAcross();
                            break;
                    }

                    // enter woods
                    break;
                case "enterWoods":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            nextLocation();
                            break;
                    }

                    // choose to fight the wolf
                    break;
                case "fight":
                    switch (yourChoice) {
                        case "c1":
                            playerAttack();
                            break;
                        case "c2":
                            nextLocation();
                            break;
                    }

                    // attack the wolf
                    break;
                case "playerAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (wolfHP < 1) {
                                win1();
                            } else {
                                wolfAttack();
                            }
                            break;
                    }

                    // wolf attack
                    break;
                case "wolfAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (player1.getPlayerHP() < 1) {
                                lose();
                            } else {
                                fight();
                            }
                            break;
                    }

                    // go to the car scene
                    break;
                case "goCar":
                    switch (yourChoice) {
                        case "c1":
                            nextLocation();
                            break;
                    }

                    // clown moment: regain health w takis
                    break;
                case "across":
                    switch (yourChoice) {
                        case "c1":
                            nextLocation();
                            break;
                    }

                    // enter cabin scene
                    break;
                case "enterCabin":
                    switch (yourChoice) {
                        case "c1":
                            goUp();
                            break;
                        case "c2":
                            goDown();
                            break;
                    }

                    // go upstairs in the cabin
                    break;
                case "goUp":
                    switch (yourChoice) {
                        case "c1":
                            bossFight();
                            break;
                    }

                    // go downstairs in the cabin
                    break;
                case "goDown":
                    switch (yourChoice) {
                        case "c1":
                            sheriffStation();
                            break;
                    }

                    // boss fight scene
                case "bossFight":
                    switch (yourChoice) {
                        case "c1":
                            finalAttack();
                            break;
                    }

                    // final player attack scene
                    break;
                case "finalAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (demiHP < 1) {
                                win2();
                            } else {
                                bossAttack();
                            }
                            break;
                    }

                    // final boss attack scene
                    break;
                case "bossAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (player1.getPlayerHP() < 1) {
                                lose();
                            } else {
                                bossFight();
                            }
                            break;
                    }

                    // lose scene
                    break;
                case "lose":
                    switch (yourChoice) {
                        case "c1":
                            hauntedStart();
                            player1.setPlayerHP(20);
                            player1.setWeapon("Fists");
                            updatePlayerLabel();
                            // playerHP = 20;
                            // hpLabelNumber.setText("" + playerHP);
                            wolfHP = 10;
                            // weapon = "Fists";
                            // weaponLabelName.setText(weapon);
                            break;
                    }

                    // win against wolf scene
                    break;
                case "win1":
                    switch (yourChoice) {
                        case "c1":
                            enterCabin();
                            break;
                    }

                    // final win; defeat demon
                    break;
                case "win2":
                    switch (yourChoice) {
                        case "c1":
                            if (goldRing == 1) {
                                ending();
                            }
                            ;
                            break;
                    }

            }
        }
    }
}
