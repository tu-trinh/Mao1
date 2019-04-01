import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Mao extends JFrame{
    private JPanel rootPanel;
    private JButton Draw;
    private JTextField typeInYourMoveTextField;
    private JComboBox<String> PenaltyDropDown;
    private JTextField PlayerNames;
    private JLabel player1;
    private JLabel player2;
    private JLabel player3;
    private JLabel player4;
    public String namesString;
    GridLayout layout = new GridLayout(3, 1, 0, 150);

    public Mao(){
        setTitle("Welcome to Mao!");
        setSize(6000,6000);
        rootPanel = new JPanel();
        rootPanel.setLayout(layout);
        add(rootPanel);
        String[] Penalties = { "Failure to say Cambia", "Failure to not say Cambia", "Failure to say Have A Nice Day", "Failure to not say Have a Nice Day" };
        typeInYourMoveTextField.setPreferredSize(new Dimension(1500, 200));
        Draw.setPreferredSize(new Dimension(1500, 200));
        PenaltyDropDown = new JComboBox<String>(Penalties);
        PenaltyDropDown.setPreferredSize(new Dimension(1500, 200));
        Draw.setFont(new Font("Arial", Font.PLAIN, 40));
        PenaltyDropDown.setFont(new Font("Arial", Font.PLAIN, 40));
        typeInYourMoveTextField.setFont(new Font("Arial", Font.PLAIN, 40));

        PlayerNames.setPreferredSize(new Dimension(1500, 200));
        PlayerNames.setFont(new Font("Arial", Font.PLAIN, 40));


            PlayerNames.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (PlayerNames.getText().length() > 0) {
                        namesString = PlayerNames.getText();
                    }
                }
            });
        String[] names = namesString.split(",");
        player1.setText(names[0]);
        player2.setText(names[1]);
        player3.setText(names[2]);
        player4.setText(names[3]);

//        for (int i = 0; i < namesString.length(); i++){
//            if (','){
//                String playerName = namesString.substring(0, i);
//                "player"+String.valueOf(counter) = new JLabel(playerName);
//            }
//            counter++;
//        }
        rootPanel.add(typeInYourMoveTextField);
        rootPanel.add(PlayerNames);
        rootPanel.add(PenaltyDropDown);
        rootPanel.add(Draw);
    }
    public String getFieldText() {
        return PlayerNames.getText();
    }
    public String getTextFieldInput(JTextField typed){
        return typed.getText();
    }

    public void readImage(String fileName) {
        try {
            File file = new File("../" + fileName);
            Image image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
