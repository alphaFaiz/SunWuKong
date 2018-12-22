package base.game;

import base.events.KeyEventPress;
import base.events.MouseEventMotion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        this.setTitle("Wukong");
        this.setResizable(false);
//        this.addMouseInput();
        this.addKeyEvent();
        this.addMouseEvent();
    }

    private void addMouseEvent() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KeyEventPress.isClicked = true;
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Insets windowInsets = getInsets();
                int mouseX = e.getX() - windowInsets.left;
                int mouseY = e.getY() - windowInsets.top;
                MouseEventMotion.mousePosition.set(mouseX, mouseY);
            }
        });
    }

//    private void addMouseInput(){
//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                KeyEventPress.isClicked = true;
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                KeyEventPress.isClicked = false;
//            }
//        });
//    }

    private void addKeyEvent() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = true;
                if (e.getKeyCode() == Settings.UP_BUTTON) {
                    KeyEventPress.isUpPress = true;
                    KeyEventPress.isLeftPress = false;
                    KeyEventPress.isDownPress = false;
                    KeyEventPress.isRightPress = false;
                }
                if (e.getKeyCode() == Settings.LEFT_BUTTON) {
                    KeyEventPress.isLeftPress = true;
                }
                if (e.getKeyCode() == Settings.DOWN_BUTTON) {
                    KeyEventPress.isDownPress = true;
                }
                if (e.getKeyCode() == Settings.RIGHT_BUTTON) {
                    KeyEventPress.isRightPress = true;
                }
                if (e.getKeyCode() == Settings.FIRE_BUTTON) {
                    KeyEventPress.isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = false;
                if (e.getKeyCode() == Settings.UP_BUTTON) {
                    KeyEventPress.isUpPress = false;
                }
                if (e.getKeyCode() == Settings.LEFT_BUTTON) {
                    KeyEventPress.isLeftPress = false;
                }
                if (e.getKeyCode() == Settings.DOWN_BUTTON) {
                    KeyEventPress.isDownPress = false;
                }
                if (e.getKeyCode() == Settings.RIGHT_BUTTON) {
                    KeyEventPress.isRightPress = false;
                }
                if (e.getKeyCode() == Settings.FIRE_BUTTON) {
                    KeyEventPress.isFirePress = false;
                }
            }
        });
    }
}
