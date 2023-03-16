import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;

public class OpenActionListener implements ActionListener {
    private File file;
    private JScrollPane textScroll;
    private JTextArea text;

    public OpenActionListener(JScrollPane textScroll, JTextArea text) {
        this.textScroll = textScroll;
        this.text = text;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();

        String dir = System.getProperty("user.dir") + "\\" + "NotepadFiles";

        fc.setCurrentDirectory(new File(dir));

        int option = fc.showOpenDialog(textScroll);

        if (option == fc.APPROVE_OPTION) {
            file = fc.getSelectedFile();

            String s = "";
            try {
                FileReader fr = new FileReader(file);
                int i;

                while ((i = fr.read()) != -1)
                    s += (char)i;
                
                fr.close();

                text.setText(s);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public File getFile() {
        return file;
    }
}