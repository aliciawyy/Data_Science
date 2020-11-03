package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsDemo extends Frame {

    private final Button mYesButton = new Button("Yes");
    private final Button mNoButton = new Button("No");
    private String mMessage;

    GraphicsDemo() {
        setLayout(new FlowLayout());
        add(new Label("One"));
        add(new Label("Two"));
        add(new Label("Three"));
        add(new Label("Four"));

        add(mYesButton);
        mYesButton.addActionListener(p -> {
            mMessage = "Yes is pressed.";
            repaint();
        });
        mNoButton.addActionListener(p -> {
            mMessage = "No is pressed.";
            repaint();
        });
        add(mNoButton);

        mMessage = "Nothing is pressed.";

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawLine(20, 40, 100, 90);
        g.drawLine(20, 90, 100, 40);

        g.drawRect(20, 120, 80, 30);
        g.fillRect(120, 120, 80, 30);
        g.setColor(Color.RED);
        g.drawRoundRect(220, 120, 80, 30, 15, 15);
        g.fillRoundRect(320, 120, 80, 30, 15, 15);

        g.setColor(Color.CYAN);
        g.drawOval(20, 170, 30, 30);
        g.fillOval(120, 170, 80, 30);

        g.setColor(Color.GRAY);
        g.drawString(mMessage, 40, 240);
    }

    public static void main(String[] args) {
        var demo = new GraphicsDemo();
        demo.setTitle("Graphics Demo");
        demo.setSize(new Dimension(420, 600));
        demo.setVisible(true);
    }
}
