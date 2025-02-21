import javax.swing.*;
import java.awt.*;

public class Menu {

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel text_field = new JLabel();


    Menu(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(new Color( 255, 245, 238));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(255, 245, 238));
        text_field.setForeground(new Color(194, 30, 86));
        text_field.setText("Tic-Tac-Toe");
        text_field.setFont(new Font("Ink Free", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setOpaque(true);

        frame.add(text_field);

        menu();
    }
    public void menu(){

        try{
            Thread.sleep(4000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
