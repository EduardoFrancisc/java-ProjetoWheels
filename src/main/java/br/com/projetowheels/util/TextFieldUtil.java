package br.com.projetowheels.util;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class TextFieldUtil extends AbstractBorder {
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x, y + height - 1, x + width - 1, y + height - 1); // Desenha uma linha horizontal na parte inferior do componente.

        g2d.dispose();
    }
}

//Class para personalização da boradas dos JText Field
