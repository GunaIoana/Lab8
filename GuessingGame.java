import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton, playAgainButton;
  JLabel enterGuessLabel, highLowLabel, lastGuessLabel;
  Random r = new Random();
  int randomNum = r.nextInt(100)+1;

  GuessingGame() {

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    enterGuessLabel = new JLabel("Enter your guess: ");
    highLowLabel = new JLabel("");
    lastGuessLabel = new JLabel("");

    frame.add(enterGuessLabel);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(highLowLabel);
    frame.add(lastGuessLabel);
    frame.add(playAgainButton);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(userGuess.getText());

      if(guess == randomNum) {
        highLowLabel.setText("You got it! ");
      }
      else if(guess < randomNum) {
        highLowLabel.setText("Too low! ");
      }
      else {
        highLowLabel.setText("Too high! ");
      }
      lastGuessLabel.setText("Last guess was: " + guess);
    }

    else if (ae.getActionCommand().equals("Play Again")) {
      int randomNum = r.nextInt(100) + 1;

      userGuess.setText("");
      highLowLabel.setText("");
      lastGuessLabel.setText("");
    }
    else {
      highLowLabel.setText("You pressed Enter. Please press the Guess Button.");
    }
  }

}