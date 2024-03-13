import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ToHuZhengPeng extends JFrame {
    public ToHuZhengPeng() {
        initUI();
    }

    private void initUI() {
        var icon = new ImageIcon("resources/image.jpg");
        setTitle("胡振鹏小程序");
        setIconImage(icon.getImage());
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        var image = new ImageIcon("resources/hzp_image.jpg");

        var label = new JLabel("");
        Dimension labelSize = label.getPreferredSize();
        label.setBounds((this.getWidth() - labelSize.width) / 2,(this.getHeight() - labelSize.height) / 2-30,labelSize.width, labelSize.height);

        var MainButton = getjButton(label, image);

        this.getContentPane().add(MainButton);
        this.getContentPane().add(label);
        this.setLayout(null);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension buttonSize = MainButton.getPreferredSize();
                int buttonX = (ToHuZhengPeng.this.getWidth() - buttonSize.width) / 2;
                int buttonY = (ToHuZhengPeng.this.getHeight() - buttonSize.height) / 2;
                MainButton.setBounds(buttonX, buttonY, buttonSize.width, buttonSize.height);

                Dimension imageLabelSize = label.getPreferredSize();
                int labelX = (ToHuZhengPeng.this.getWidth() - imageLabelSize.width) / 2;
                int labelY = (ToHuZhengPeng.this.getHeight() - imageLabelSize.height) / 2;
                label.setBounds(labelX, labelY, imageLabelSize.width, imageLabelSize.height);
            }
        });

    }

    private JButton getjButton(JLabel label, ImageIcon image) {
        var MainButton = new JButton("点击按钮显示胡振鹏最喜欢的图片");
        Dimension buttonSize = MainButton.getPreferredSize();
        MainButton.setBounds((this.getWidth() - buttonSize.width) / 2,(this.getHeight() - buttonSize.height) / 2,buttonSize.width, buttonSize.height);

        MainButton.addActionListener(actionEvent -> {
            MainButton.setVisible(false);
            label.setIcon(image);
            Dimension imageLabelSize = label.getPreferredSize();
            label.setBounds((this.getWidth() - imageLabelSize.width) / 2,(this.getHeight() - imageLabelSize.height) / 2-30,imageLabelSize.width, imageLabelSize.height);
        });

        return MainButton;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new ToHuZhengPeng();
            ex.setVisible(true);
        });
    }
}
