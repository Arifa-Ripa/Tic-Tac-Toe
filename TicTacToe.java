import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel tittle_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    static boolean xWin = false;
    static boolean oWin = false;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(new Color( 255, 245, 238));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(255, 245, 238)); //Seashell
        text_field.setForeground(new Color(222, 49, 99));
        text_field.setFont(new Font("Ink Free", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setOpaque(true);

        //menu();

        tittle_panel.setLayout(new BorderLayout());
        tittle_panel.setBounds(0,0, 600, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(248, 200, 220));


        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setBackground(new Color(243, 207, 198)); //Millennial Pink
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        tittle_panel.add(text_field);
        frame.add(tittle_panel, BorderLayout.NORTH);
        frame.add(button_panel);


        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++){
            if(e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(170, 51, 106));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("0's Turn!");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(128, 0, 128));
                        buttons[i].setText("0");
                        player1_turn = true;
                        text_field.setText("X's Turn!");
                        check();
                    }
                }
            }
        }

    }



    public void firstTurn(){

//        try{
//            Thread.sleep(5000);
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }


        if(random.nextInt(2) == 0){
            player1_turn = true;
            text_field.setText("X's Turn!");
        }
        else{
            player1_turn = false;
            text_field.setText("0's Turn!");
        }
    }

    public void check(){

        if(buttons[0].getText() == "X" &&
                buttons[1].getText() == "X" &&
                buttons[2].getText() == "X"){
            xWins(0, 1, 2);
        }

        if(buttons[3].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[5].getText() == "X"){
            xWins(3, 4, 5);
        }

        if(buttons[6].getText() == "X" &&
                buttons[7].getText() == "X" &&
                buttons[8].getText() == "X"){
            xWins(6, 7, 8);
        }

        if(buttons[1].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[7].getText() == "X"){
            xWins(1, 4, 7);
        }

        if(buttons[0].getText() == "X" &&
                buttons[3].getText() == "X" &&
                buttons[6].getText() == "X"){
            xWins(0, 3, 6);
        }


        if(buttons[2].getText() == "X" &&
                buttons[5].getText() == "X" &&
                buttons[8].getText() == "X"){
            xWins(2, 5, 8);
        }


        if(buttons[0].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[8].getText() == "X"){
            xWins(0, 4, 8);
        }


        if(buttons[6].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[2].getText() == "X"){
            xWins(6, 4, 2);
        }



        if(buttons[0].getText() == "0" &&
                buttons[1].getText() == "0" &&
                buttons[2].getText() == "0"){
            oWins(0, 1, 2);
        }



        if(buttons[3].getText() == "0" &&
                buttons[4].getText() == "0" &&
                buttons[5].getText() == "0"){
            oWins(3, 4, 5);
        }



        if(buttons[6].getText() == "0" &&
                buttons[7].getText() == "0" &&
                buttons[8].getText() == "0"){
            oWins(6, 7, 8);
        }

        if(buttons[1].getText() == "0" &&
                buttons[4].getText() == "0" &&
                buttons[7].getText() == "0"){
            oWins(1, 4, 7);
        }



        if(buttons[0].getText() == "0" &&
                buttons[3].getText() == "0" &&
                buttons[6].getText() == "0"){
            oWins(0, 3, 6);
        }



        if(buttons[2].getText() == "0" &&
                buttons[5].getText() == "0" &&
                buttons[8].getText() == "0"){
            oWins(2, 5, 8);
        }



        if(buttons[0].getText() == "0" &&
                buttons[4].getText() == "0" &&
                buttons[8].getText() == "0"){
            oWins(0, 4, 8);
        }



        if(buttons[6].getText() == "0" &&
                buttons[4].getText() == "0" &&
                buttons[2].getText() == "0"){
            oWins(6, 4, 2);
        }

        gameTied();
            
    }  

    public void xWins(int a, int b, int c){
        xWin = true;
        text_field.setText("X Wins!");
        buttons[a].setBackground(new Color(255, 105, 180));
        buttons[b].setBackground(new Color(255, 105, 180));
        buttons[c].setBackground(new Color(255, 105, 180));

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }

    }

    public void oWins(int a, int b, int c){
        oWin = true;
        text_field.setText("0 Wins!");
        buttons[a].setBackground(new Color(255, 105, 180));
        buttons[b].setBackground(new Color(255, 105, 180));
        buttons[c].setBackground(new Color(255, 105, 180));

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
    }

    public  void gameTied(){
        boolean allFilled = true;
        for(int i = 0; i < 9; i++){
            if(buttons[i].getText().equals(""))
                allFilled = false;
        }
        if(allFilled && !xWin && !oWin) {
            text_field.setText("Game Tied");
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
        }
    }

}
