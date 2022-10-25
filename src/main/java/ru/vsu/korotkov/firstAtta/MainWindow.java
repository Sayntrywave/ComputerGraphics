package ru.vsu.korotkov.firstAtta;

import ru.vsu.korotkov.firstAtta.task2.DrawPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel panel;

    public MainWindow() throws HeadlessException {
        panel = new DrawPanel(getWidth(), getHeight(), 10);

        this.add(panel);
    }
}