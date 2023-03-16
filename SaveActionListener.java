import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;

public class SaveActionListener implements ActionListener {
    private JFrame notepadFrame;
    private JTextArea text;

    public SaveActionListener(JFrame notepadFrame, JTextArea text) {
        this.notepadFrame = notepadFrame;
        this.text = text;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        String fileName = JOptionPane.showInputDialog(notepadFrame, "Please Enter File Name: ", JOptionPane.WARNING_MESSAGE);

        String filePath = System.getProperty("user.dir") + "\\" + "NotepadFiles" + "\\" + fileName + ".txt";

        String content = text.getText();

        try {
            File newFile = new File(filePath);

            if (newFile.createNewFile()) {
                FileWriter fw = new FileWriter(newFile);
                fw.write(content);
                fw.close();
            }
        } catch (Exception exp){ 
            exp.printStackTrace();
        }
    }
}
