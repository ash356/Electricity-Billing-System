package Images;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Image2 extends JPanel {

    private ImageIcon i;

    public Image2() {
        this.setLayout(null);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        i = new ImageIcon(getClass().getResource("..\\Images\\image1.jpg"));
        i.paintIcon(this, g, 0, 0);

    }

}
