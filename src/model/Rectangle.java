package model;

import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
    }

    public Rectangle(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public boolean contains(Point point) {
        int point_x = point.x;
        int point_y = point.y;

        return containsX(point_x) && containsY(point_y);
    }

    //EFFECTS: draws the shape
    public void draw(Graphics g) {
        Color save = g.getColor();
        if (selected) {
            g.setColor(PLAYING_COLOR);
        } else {
            g.setColor(Color.white);
        }

        fillGraphics(g);
        g.setColor(save);
        drawGraphics(g);

        if (playLineCoord > 0 && playLineCoord < width) {
            g.setColor(Color.red);
            g.drawLine(x + playLineCoord, y, x + playLineCoord, y + height);
            g.setColor(save);
        }


    }

    //EFFECTS: draws the shape
    private void drawGraphics(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    //EFFECTS: fills the shape
    private void fillGraphics(Graphics g) {
        g.fillRect(x, y, width, height);
    }

}