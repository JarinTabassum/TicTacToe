import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel(); //panel which will hold the title
    JPanel button_panel = new JPanel(); //panel which will hold all the buttons
    JLabel text_field = new JLabel();
    JButton button[] = new JButton[9];
    boolean player1_turn; //if it's not player1's turn then it will be false

    TicTacToe() {
        //creating the JFrame first
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50)); //to add buttons,labels,text fields etc. in JFrame we need to use getContentPane
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);

        //creating the text-field
        text_field.setText("Tic-Tac-Toe"); //title of the label
        text_field.setBackground(new Color(25, 25, 25));
        text_field.setForeground(new Color(25, 255, 0)); //color of the text
        text_field.setFont(new Font("Arial", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER); //by adjusting the horizontal alignments like labels,you can control the horizontal position of the components
        text_field.setOpaque(true); //whether a component should paint its background or remain transparent. As true so it be will paint

        //creating the title_panel(which will hold the title)
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100); //here x and y represent where the component's top left corner should be placed

        //creating the button panel(which will hold the buttons)
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.WHITE);

        //creating the buttons
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button[i].setBackground(Color.darkGray);
            button[i].setFont(new Font("Arial", Font.BOLD, 120));
            button[i].setFocusable(false); //it will not respond to keyboard input events
            button[i].addActionListener(this);
            button_panel.add(button[i]);
        }

        //add
        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        //calling the first turn method to start the game
        firstTurn();
    }

    public void firstTurn() {
        //to make the title change 2 sec later after the introduction
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //we are setting which player should get to play
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            text_field.setText("X turn");
        } else {
            player1_turn = false;
            text_field.setText("O turn");
        }
    }

    public void check() {
        //winning combination for player1
        if(
                (button[0].getText()=="X") &&
                        (button[1].getText()=="X") &&
                        (button[2].getText()=="X")) {
            xWins(0, 1, 2);
        }
        else if(
                        (button[3].getText()=="X") &&
                        (button[4].getText()=="X") &&
                        (button[5].getText()=="X")){
            xWins(3,4,5);
        }
    else if(
                        (button[6].getText()=="X") &&
                        (button[7].getText()=="X") &&
                        (button[8].getText()=="X")){
            xWins(6,7,8);
        }
    else if(
                        (button[0].getText()=="X") &&
                        (button[4].getText()=="X") &&
                        (button[8].getText()=="X")){
            xWins(0,4,8);
        }
    else if(
                        (button[2].getText()=="X") &&
                        (button[4].getText()=="X") &&
                        (button[6].getText()=="X")){
            xWins(2,4,6);
        }
    else if(
                        (button[0].getText()=="X") &&
                        (button[3].getText()=="X") &&
                        (button[6].getText()=="X")){
            xWins(0,3,6);
        }
    else if(
                        (button[1].getText()=="X") &&
                        (button[4].getText()=="X") &&
                        (button[7].getText()=="X")){
            xWins(1,4,7);
        }
    else if(
                        (button[2].getText()=="X") &&
                        (button[5].getText()=="X") &&
                        (button[8].getText()=="X")){
            xWins(2,5,8);
        }


    //combination for O to win

        if(
                (button[0].getText()=="O") &&
                        (button[1].getText()=="O") &&
                        (button[2].getText()=="O")) {
            oWins(0, 1, 2);
        }
        else if(
                (button[3].getText()=="O") &&
                        (button[4].getText()=="O") &&
                        (button[5].getText()=="O")){
            oWins(3,4,5);
        }
        else if(
                (button[6].getText()=="O") &&
                        (button[7].getText()=="O") &&
                        (button[8].getText()=="O")){
            oWins(6,7,8);
        }
        else if(
                (button[0].getText()=="O") &&
                        (button[4].getText()=="O") &&
                        (button[8].getText()=="O")){
            oWins(0,4,8);
        }
        else if(
                (button[2].getText()=="O") &&
                        (button[4].getText()=="O") &&
                        (button[6].getText()=="O")){
            oWins(2,4,6);
        }
        else if(
                (button[0].getText()=="O") &&
                        (button[3].getText()=="O") &&
                        (button[6].getText()=="O")){
            oWins(0,3,6);
        }
        else if(
                (button[1].getText()=="O") &&
                        (button[4].getText()=="O") &&
                        (button[7].getText()=="O")){
            oWins(1,4,7);
        }
        else if(
                (button[2].getText()=="O") &&
                        (button[5].getText()=="O") &&
                        (button[8].getText()=="O")){
            oWins(2,5,8);
        }

    }

    public void xWins(int a, int b, int c) { //for which three buttons have to match for x to win
        button[a].setBackground(Color.blue);
        button[b].setBackground(Color.blue);
        button[c].setBackground(Color.blue);

        for(int i=0;i<9;i++){
            button[i].setEnabled(false); //now all buttons will be disabled so that the game may not continue as winner has already been found
        }

        text_field.setText("X won");
    }
    public void oWins(int a, int b, int c) {
        button[a].setBackground(Color.red);
        button[b].setBackground(Color.red);
        button[c].setBackground(Color.red);

        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }

        text_field.setText("O won");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //action for all the buttons
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (player1_turn) { //if it is player1's turn
                    if (button[i].getText() == "") { //the button has to be empty first to assign anything in it,so checking that
                        button[i].setForeground(new Color(0, 0, 255)); //color of X,which will be blue as b=255 and the other is 0
                        button[i].setText("X");
                        player1_turn = false; //so that may player2 play now
                        text_field.setText("O turn");
                        check(); //to know if player1 won or not
                    }
                }
                else{
                    if(button[i].getText()==""){
                        button[i].setForeground(new Color(255,0,0));
                        button[i].setText("O");
                        player1_turn=true;
                        text_field.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
}
