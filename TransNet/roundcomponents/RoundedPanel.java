package roundcomponents;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class RoundedPanel extends JPanel {

    // Method to create a rounded panel
    public static void createRoundedPanel(JPanel panel, int radius) {
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder());

        panel.setUI(new javax.swing.plaf.PanelUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(panel.getBackground());
                g2.fillRoundRect(0, 0, panel.getWidth(), panel.getHeight(), radius, radius);
                g2.dispose();
                super.paint(g, c);
            }
        });
    }

    // Method to create a rounded button
    public static void createRoundedButton(JButton button, int radius) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.setUI(new RoundedButtonUI(radius));
    }

    // Method to create a rounded text field
    public static void createRoundedTextField(JTextField textField, int radius) {
        textField.setBorder(new EmptyBorder(5, 10, 5, 10));

        textField.setUI(new javax.swing.plaf.basic.BasicTextFieldUI() {
            @Override
            public void paintBackground(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(textField.getBackground());
                g2.fillRoundRect(0, 0, textField.getWidth() - 1, textField.getHeight() - 1, radius, radius);
                g2.setColor(textField.getForeground().darker());
                g2.drawRoundRect(0, 0, textField.getWidth() - 1, textField.getHeight() - 1, radius, radius);
                g2.dispose();
            }
        });
    }

    // New method to create a rounded password field
    public static void createRoundedPasswordField(JPasswordField passwordField, int radius) {
        passwordField.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add padding

        passwordField.setUI(new javax.swing.plaf.basic.BasicPasswordFieldUI() {
            @Override
            public void paintBackground(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw background
                g2.setColor(passwordField.getBackground());
                g2.fillRoundRect(0, 0, passwordField.getWidth() - 1, passwordField.getHeight() - 1, radius, radius);

                // Draw border
                g2.setColor(passwordField.getForeground().darker());
                g2.drawRoundRect(0, 0, passwordField.getWidth() - 1, passwordField.getHeight() - 1, radius, radius);

                g2.dispose();
            }
        });
    }

    // Custom ButtonUI for rounded buttons
    private static class RoundedButtonUI extends BasicButtonUI {
        private int radius;

        public RoundedButtonUI(int radius) {
            this.radius = radius;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            JButton button = (JButton) c;
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            ButtonModel model = button.getModel();
            Color bgColor = button.getBackground();
            if (model.isPressed()) {
                bgColor = bgColor.darker();
            } else if (model.isRollover()) {
                bgColor = bgColor.brighter();
            }

            g2.setColor(bgColor);
            g2.fillRoundRect(0, 0, button.getWidth() - 1, button.getHeight() - 1, radius, radius);
            super.paint(g2, c);
            g2.dispose();
        }

        @Override
        protected void paintButtonPressed(Graphics g, AbstractButton b) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(b.getBackground().darker());
            g2.fillRoundRect(0, 0, b.getWidth() - 1, b.getHeight() - 1, radius, radius);
            g2.dispose();
            super.paintButtonPressed(g, b);
        }
    }

    // New method to create a rounded combo box
	public static void createRoundedComboBox(JComboBox<?> comboBox, int radius) {
		comboBox.setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				JButton button = new JButton() {
					@Override
					public void paint(Graphics g) {
						Graphics2D g2 = (Graphics2D) g.create();
						g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
						g2.setColor(getBackground());
						g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
						g2.setColor(getForeground());
						g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
						g2.dispose();

						// Draw the arrow icon
						super.paint(g);
					}
				};
				button.setBorder(new EmptyBorder(5, 10, 5, 10));
				button.setContentAreaFilled(false);
				button.setOpaque(false);
				return button;
			}

			@Override
			public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(comboBox.getBackground());
				g2.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, radius, radius);
				g2.setColor(comboBox.getForeground().darker());
				g2.drawRoundRect(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1, radius, radius);
				g2.dispose();
			}

			@Override
			public void paint(Graphics g, JComponent c) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(comboBox.getBackground());
				g2.fillRoundRect(0, 0, comboBox.getWidth(), comboBox.getHeight(), radius, radius);
				g2.setColor(comboBox.getForeground().darker());
				g2.drawRoundRect(0, 0, comboBox.getWidth() - 1, comboBox.getHeight() - 1, radius, radius);
				g2.dispose();

				super.paint(g, c);
			}
		});

		comboBox.setBorder(new EmptyBorder(5, 10, 5, 10));
		comboBox.setOpaque(false);
	}
}
