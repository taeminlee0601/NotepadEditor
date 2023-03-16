import javax.swing.*;
import java.awt.*;

public class Notepad {
    private JFrame notepadFrame = new JFrame();
    private JMenuBar toolbar = new JMenuBar();

    public Notepad() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenu = new JMenuItem("Open");
        JMenuItem saveMenu = new JMenuItem("Save");
        JMenuItem exitMenu = new JMenuItem("Exit");

        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(exitMenu);

        toolbar.add(fileMenu);

        // Create text area and set font
        JTextArea text = new JTextArea();
        Font font = new Font("Consolas", Font.PLAIN, 15);

        // Set font and margins for the text area
        text.setFont(font);
        text.setMargin(new Insets(10, 10, 10, 10));

        // Make the text area have scroll panes
        JScrollPane textScroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        OpenActionListener openAL = new OpenActionListener(textScroll, text);

        openMenu.addActionListener(openAL);
        exitMenu.addActionListener(new ExitActionListener());
        saveMenu.addActionListener(new SaveActionListener(notepadFrame, text));

        notepadFrame.add(toolbar, BorderLayout.NORTH);
        notepadFrame.add(textScroll);
    }

    public static void main(String[]args) {
        Notepad notepad = new Notepad();

        notepad.notepadFrame.setTitle("Notepad");
        notepad.notepadFrame.setSize(1000,700);
        notepad.notepadFrame.setLocationRelativeTo(null);
        notepad.notepadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        notepad.notepadFrame.setVisible(true);
    }
}

