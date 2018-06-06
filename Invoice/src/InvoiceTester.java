import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InvoiceTester {
    public static void main(String[] args) {
        final Invoice invoice = new Invoice();
        final InvoiceFormatter formatter = new SimpleFormatterr();
        final JTextArea textArea = new JTextArea(20, 40);

        ChangeListener listener = new
            ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent event) {
                    textArea.setText(invoice.format(formatter));
                }
            };

        invoice.addChangeListener(listener);

        final JComboBox combo = new JComboBox();
        Product hammer = new Product("Hammer", 19.95);
        Product nails = new Product("Nails", 9.95);
        combo.addItem(hammer);
        Bundle bundle = new Bundle();
        bundle.add(hammer);
        bundle.add(nails);
        combo.addItem(new DiscountedItem(bundle, 10));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new
            ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    LineItem item = (LineItem) combo.getSelectedItem();
                    invoice.addItem(item);
                }
            });

        JPanel panel = new JPanel();
        panel.add(combo);
        panel.add(addButton);

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(textArea),
                BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
