package projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class rockPaperScissor extends JFrame implements ActionListener {
    JLabel computerChoice, result;
    JLabel computerScore, playerScore;
    int player_score = 0;
    int computer_score = 0;
    ImageIcon image_rock, image_paper, image_scissor;
    JButton exit;
    rockPaperScissor(){

//        exit button
        exit = new JButton("EXIT");
        exit.setBounds(200,500,80,30);
        exit.setFont(new Font("Arial",Font.PLAIN,20));
        exit.setBackground(Color.pink);
        exit.setFocusable(true);
        exit.setBorder(BorderFactory.createEtchedBorder());
        exit.addActionListener(this);

//        create computer vs you
        JLabel label_computer = new JLabel("Computer");
        label_computer.setBounds(200,150,200,100);
        label_computer.setFont(new Font("Serif",Font.BOLD,25));
        label_computer.setForeground(Color.BLUE);

        JLabel label_vs = new JLabel("VS");
        label_vs.setBounds(230,190,100,100);
        label_vs.setFont(new Font("Serif",Font.ITALIC,25));
        label_vs.setForeground(Color.MAGENTA);

        JLabel label_player = new JLabel("You");
        label_player.setBounds(215,230,100,100);
        label_player.setFont(new Font("Serif",Font.BOLD,25));
        label_player.setForeground(Color.BLUE);

//        Create Scorecard
        JPanel panel = new JPanel();
        panel.setBounds(350,50,120,100);
        panel.setBackground(new Color(255,235,205));

        JLabel score = new JLabel("SCORE");
        score.setBounds(380,20,100,100);
        score.setFont(new Font("Times New Roman",Font.BOLD,20));
        score.setForeground(Color.red);

        computerScore = new JLabel("Computer : 0");
        computerScore.setBounds(360,50,100,100);
        computerScore.setFont(new Font("Arial",Font.PLAIN,15));

        playerScore = new JLabel("You : 0");
        playerScore.setBounds(360,75,100,100);
        playerScore.setFont(new Font("Arial",Font.PLAIN,15));

//        create computer choice
        computerChoice= new JLabel();
        computerChoice.setHorizontalTextPosition(JLabel.CENTER);
        computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
        computerChoice.setBounds(200,50,125,125);
        computerChoice.setFont(new Font("Arial",Font.BOLD,20));

//        result
        result = new JLabel();
        result.setFont(new Font("Serif",Font.BOLD,20));
        result.setBounds(210,425,100,100);
        result.setForeground(Color.red);

//        create imageIcon rock, paper, scissor
        image_rock = new ImageIcon("E:\\Study\\Java\\src\\GUI\\Images\\rock 3.png");
        JLabel label_rock = new JLabel("Rock");
        label_rock.setIcon(image_rock);
        label_rock.setBounds(75,310,125,125);
        label_rock.setHorizontalTextPosition(JLabel.CENTER);
        label_rock.setVerticalTextPosition(JLabel.BOTTOM);
        label_rock.setFont(new Font("Arial",Font.BOLD,20));

        image_paper = new ImageIcon("E:\\Study\\Java\\src\\GUI\\Images\\paper 3.png");
        JLabel label_paper = new JLabel("Paper");
        label_paper.setIcon(image_paper);
        label_paper.setBounds(200,310,125,125);
        label_paper.setHorizontalTextPosition(JLabel.CENTER);
        label_paper.setVerticalTextPosition(JLabel.BOTTOM);
        label_paper.setFont(new Font("Arial",Font.BOLD,20));

        image_scissor = new ImageIcon("E:\\Study\\Java\\src\\GUI\\Images\\scissor 3.png");
        JLabel label_scissor = new JLabel("Scissor");
        label_scissor.setIcon(image_scissor);
        label_scissor.setBounds(325,310,125,125);
        label_scissor.setHorizontalTextPosition(JLabel.CENTER);
        label_scissor.setVerticalTextPosition(JLabel.BOTTOM);
        label_scissor.setFont(new Font("Arial",Font.BOLD,20));

        label_rock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculate(label_rock.getText());
            }
        });
        label_paper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculate(label_paper.getText());
            }
        });
        label_scissor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculate(label_scissor.getText());
            }
        });

//        create title
        JLabel label_title = new JLabel("ROCK PAPER SCISSOR");
        label_title.setBounds(100,0,400,50);
        label_title.setFont(new Font("Showcard Gothic",Font.BOLD,30));
        label_title.setForeground(new Color(255, 128, 0));
        label_title.setVerticalTextPosition(JLabel.TOP);
        label_title.setHorizontalTextPosition(JLabel.CENTER);

//      background image
        ImageIcon back = new ImageIcon("E:\\Study\\Java\\src\\GUI\\Images\\background_image.jpeg");
        JLabel label = new JLabel();
        label.setIcon(back);
        label.setBounds(0,0,500,600);

        add(label_title);
        add(label_rock);
        add(label_paper);
        add(label_scissor);
        add(computerChoice);
        add(result);
        add(computerScore);
        add(score);
        add(playerScore);
        add(label_computer);
        add(label_player);
        add(label_vs);
        add(exit);
        add(panel);
        add(label);
    }
    public void calculate(String player){
        String[] list = {"Rock", "Paper", "Scissor"};
        int random_choice = (int)((Math.random()*10)%3);
        String computer = list[random_choice];

//        display computer choice
        computerChoice.setText(computer);
        if (random_choice == 0) {
            computerChoice.setIcon(image_rock);
        } else if(random_choice==1){
            computerChoice.setIcon(image_paper);
        }else {
            computerChoice.setIcon(image_scissor);
        }

//        logic
        String res = "";
        if (player.equals(computer)){
            res = " Draw";
        } else if (player.equals("Rock")) {
            if (computer.equals("paper")){
                res = "You lose!";
                computer_score++;
            }
            else {
                res = "You win!";
                player_score++;
            }
        } else if (player.equals("Paper")) {
            if (computer.equals("Scissor")){
                res = "You lose!";
                computer_score++;
            }
            else{
                res = "You win!";
                player_score++;
            }
        }
        else{
            if (computer.equals("Rock")){
                res = "You lose!";
                computer_score++;
            }
            else {
                res = "You win!";
                player_score++;
            }
        }
        result.setText(res);
        playerScore.setText("You : "+player_score);
        computerScore.setText("Computer : "+computer_score);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        rockPaperScissor rps = new rockPaperScissor();

        ImageIcon rps_icon = new ImageIcon("E:\\Study\\Java\\src\\GUI\\Images\\icon.png");
        rps.setTitle("ROCK PAPER SCISSOR");
        rps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rps.setSize(500,600);
        rps.setLayout(null);
        rps.getContentPane().setBackground(Color.BLACK);
        rps.setIconImage(rps_icon.getImage());
        rps.setResizable(false);
        rps.setVisible(true);

    }
}
