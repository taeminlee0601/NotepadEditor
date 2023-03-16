import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExitActionListener implements ActionListener {
    
    @Override

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
