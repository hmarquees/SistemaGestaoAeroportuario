package ga.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class JPanelArredondado extends JPanel {

    private int raioArredondamento = 10;

    public JPanelArredondado() {
        setOpaque(false); // Torna o painel transparente para que seja possível ver os cantos arredondados
    }

    public void setRaioArredondamento(int raio) {
        this.raioArredondamento = raio;
        repaint(); // Redesenha o painel com o novo raio de arredondamento
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        int arc = raioArredondamento * 2;
        Shape forma = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc);
        g2.setColor(getBackground());
        g2.fill(forma);

        super.paintComponent(g2);
        g2.dispose();
    }

}