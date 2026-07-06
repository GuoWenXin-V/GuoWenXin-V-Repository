package day1;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class LabelTextField3_6_OrderInsert {
    public static void main(String[] args) {
        // ������ ��������� ������ (������ ������ ���)
        // ��������������� (������������������)
        JFrame frame = new JFrame("������ ������");

        // ������ ������ - GridLayout ������ (11��� 2���)
        // ������������ - ������ GridLayout (11��� 2���)
        // 10��� ������ + ������ 1��� = 11���
        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 5));
        // GridLayout(rows, cols, hgap, vgap)
        // rows=11 (������+��������� 10��� + ������ 1���)
        // cols=2 (������ ���, ��������� ���)
        // hgap=10 (������ ������), vgap=5 (������ ������)

        // ----- 1. ������������ ������ (������ ������ ������) -----
        // ----- 1. ������������������ (������������������) -----
        panel.add(new JLabel("������������:"));                   // ������������ ������
        // ������ ��������� ������ ������ ������������ ������ ������ ������
        // ���������������������������������������������������������
        String orderId = "ORD-" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-" + System.currentTimeMillis() % 10000;
        JTextField orderIdField = new JTextField(orderId, 15); // ������������ ��������� (������ ������ ������)
        orderIdField.setToolTipText("������ ��������� ���������������������. ������ ���������������.");
        panel.add(orderIdField);

        // ----- 2. ������ ID / ��������� ������ -----
        // ----- 2. ������ID / ������������������ -----
        panel.add(new JLabel("������ ID / ���������:"));           // ������ ID ������
        JTextField customerField = new JTextField(15);       // ������ ID ���������
        customerField.setToolTipText("������ ID ������ ������������ ���������������.");
        panel.add(customerField);

        // ----- 3. ��������� ������ -----
        // ----- 3. ������������������ -----
        panel.add(new JLabel("���������:"));                     // ��������� ������
        JTextField productNameField = new JTextField(15);    // ��������� ���������
        panel.add(productNameField);

        // ----- 4. ������ ������ ������ -----
        // ----- 4. ������������������ -----
        panel.add(new JLabel("������ ������:"));                  // ������ ������ ������
        JTextField productCodeField = new JTextField(15);    // ������ ������ ���������
        productCodeField.setToolTipText("���: P-2026-0001");
        panel.add(productCodeField);

        // ----- 5. ������ ������ ������ -----
        // ----- 5. ������������������ -----
        panel.add(new JLabel("������ ������:"));                  // ������ ������ ������
        JTextField quantityField = new JTextField(15);       // ������ ������ ���������
        quantityField.setToolTipText("���: 2");
        panel.add(quantityField);

        // ----- 6. ������ ������ -----
        // ----- 6. ������������ -----
        panel.add(new JLabel("������ (���):"));                  // ������ ������
        JTextField unitPriceField = new JTextField(15);      // ������ ���������
        unitPriceField.setToolTipText("���: 50000");
        panel.add(unitPriceField);

        // ----- 7. ��� ������ (������ ������ - ������ ������) -----
        // ----- 7. ��������� (������������ - ������) -----
        panel.add(new JLabel("��� ������ (���):"));               // ��� ������ ������
        JTextField totalField = new JTextField("0", 15);     // ��� ������ ��������� (������ ������)
        totalField.setEditable(false);                       // ������ ��������� (������ ������)
        totalField.setBackground(new Color(240, 240, 240)); // ��������� ������������ ������
        totalField.setHorizontalAlignment(JTextField.RIGHT); // ��������� ������
        panel.add(totalField);

        // ----- 8. ��������� ������ ������ -----
        // ----- 8. ������������������ -----
        panel.add(new JLabel("��������� ������:"));                // ��������� ������ ������
        JTextField addressField = new JTextField(15);        // ��������� ������ ���������
        panel.add(addressField);

        // ----- 9. ��������� ������ -----
        // ----- 9. ������������������ -----
        panel.add(new JLabel("���������:"));                     // ��������� ������
        JTextField phoneField = new JTextField(15);          // ��������� ���������
        phoneField.setToolTipText("���: 010-1234-5678");
        panel.add(phoneField);

        // ----- 10. ������������ (������ ������ - ������ ������) -----
        // ----- 10. ������������ (������������ - ������) -----
        panel.add(new JLabel("������������:"));                   // ������������ ������

        // ������ ������ ������ ������ (YYYY-MM-DD HH:mm:ss ������)
        // ������������������������ (YYYY-MM-DD HH:mm:ss ������)
        String now = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " " +
                java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        JTextField dateField = new JTextField(now, 15);      // ������������ ��������� (������ ������)
        dateField.setEditable(false);                        // ������ ��������� (������ ������)
        dateField.setBackground(new Color(240, 240, 240));  // ��������� ������������ ������
        panel.add(dateField);

        // ----- 11. ������ ������ ������ (2��� ������) -----
        JButton btn = new JButton("������ ������");

        // ������ ������ ��������� ������ (��������� ������)
        // ������������������������ (������ Lambda ���������)
        btn.addActionListener(e -> {
            // ��������� ������������
            // ���������������
            String orderIdVal = orderIdField.getText().trim();
            String customer = customerField.getText().trim();
            String productName = productNameField.getText().trim();
            String productCode = productCodeField.getText().trim();
            String quantity = quantityField.getText().trim();
            String unitPrice = unitPriceField.getText().trim();
            // ��������� ������: ������ ������ ��� ������ ���������
            // ��������� ������: ��������������������� ���������
            String total = totalField.getText().trim().replaceAll(",", "");
            String address = addressField.getText().trim();
            String phone = phoneField.getText().trim();
            String orderDate = dateField.getText().trim();

            // ----- ��������� ������ (Validation) -----
            // ----- ��������������� -----

            // 1) ������������ ������
            // 1) ������������������
            if (orderIdVal.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "��������������� ������������������!",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                orderIdField.requestFocus();
                return;
            }

            // 2) ������ ID / ��������� ������
            // 2) ������ID / ������������������
            if (customer.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "������ ID ������ ������������ ������������������!",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                customerField.requestFocus();
                return;
            }

            // 3) ��������� ������
            // 3) ������������������
            if (productName.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "������������ ������������������!",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                productNameField.requestFocus();
                return;
            }

            // 4) ������ ������ ������
            // 4) ������������������
            if (productCode.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "������ ��������� ������������������!",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                productCodeField.requestFocus();
                return;
            }

            // 5) ������ ������ ������ (��������� ������ ������, 1 ������)
            // 5) ������������������ (������������������, 1������)
            if (quantity.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "������ ��������� ������������������!",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                quantityField.requestFocus();
                return;
            }
            try {
                int qty = Integer.parseInt(quantity);
                if (qty <= 0) {
                    JOptionPane.showMessageDialog(frame,
                            "������ ��������� 1��� ��������������� ���������!",
                            "������ ������",
                            JOptionPane.WARNING_MESSAGE);
                    quantityField.requestFocus();
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "��������� ��������� ������������������! (��������� ������)",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                quantityField.requestFocus();
                return;
            }

            // 6) ������ ������ (��������� ������ ������, 0 ������)
            // 6) ������������ (������������������, 0������)
            if (unitPrice.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "��������� ������������������!",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                unitPriceField.requestFocus();
                return;
            }
            try {
                int price = Integer.parseInt(unitPrice);
                if (price < 0) {
                    JOptionPane.showMessageDialog(frame,
                            "��������� 0 ��������������� ���������!",
                            "������ ������",
                            JOptionPane.WARNING_MESSAGE);
                    unitPriceField.requestFocus();
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "��������� ��������� ������������������! (��������� ������)",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                unitPriceField.requestFocus();
                return;
            }

            // 7) ��� ��������� ������ ������������������ ������
            // 7) ���������������������������������
            // ��������� ������: total ��������� ������ ��������� ��������� ������ ���������
            // ��������� ������: total ��������������������� ���������
            if (total.equals("0") || total.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "��������� ��������� ������������ ��� ��������� ������ ���������������.\n��������� ��������� ������ ������������������!",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                quantityField.requestFocus();
                return;
            }

            // 8) ��������� ������ ������
            // 8) ������������������
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "��������� ��������� ������������������!",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                addressField.requestFocus();
                return;
            }

            // 9) ��������� ������ (��������� ������ ������)
            // 9) ������������������ (������������������)
            if (phone.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "������������ ������������������! (���: 010-1234-5678)",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                phoneField.requestFocus();
                return;
            }
            // ������, ���������(-), ��������� ������ (��������� ������)
            if (!phone.matches("[0-9\\-\\s]+")) {
                JOptionPane.showMessageDialog(frame,
                        "��������� ��������� ��������� ������������! (���: 010-1234-5678)",
                        "������ ������",
                        JOptionPane.WARNING_MESSAGE);
                phoneField.requestFocus();
                return;
            }

            // ----- ������ ��������� ��������� ������ ������ ������ ������ -----
            // ----- ��������������������������������������� -----

            // ��������� ������: total��� ��������� ��������� ��� ������ ��������� ��� ������ ���������
            // ��������� ������: ���total��������������������������������������������� ���������
            int totalAmount = Integer.parseInt(total);

            // ������ ��������� ��������� ��������� ������
            // ���������������������������������
            String message = "���� ������ ������ ������! ����\n\n"
                    + "������������������������������������������������������������������������������������������������\n"
                    + "���� ������ ������\n"
                    + "������������������������������������������������������������������������������������������������\n"
                    + "������������    : " + orderIdVal + "\n"
                    + "������ ID     : " + customer + "\n"
                    + "���������      : " + productName + "\n"
                    + "������ ������   : " + productCode + "\n"
                    + "������ ������   : " + String.format("%,d", Integer.parseInt(quantity)) + "���\n"
                    + "������        : " + String.format("%,d", Integer.parseInt(unitPrice)) + "���\n"
                    + "��� ������     : " + String.format("%,d", totalAmount) + "���\n"
                    + "��������� ������ : " + address + "\n"
                    + "���������      : " + phone + "\n"
                    + "������������    : " + orderDate + "\n"
                    + "������������������������������������������������������������������������������������������������\n"
                    + "���� ��������� ��������������� ���������������������!";

            // ��������� ������������������ ������ ������ ������
            // ������������������������������������
            JOptionPane.showMessageDialog(frame,
                    message,
                    "������ ������ ������",
                    JOptionPane.INFORMATION_MESSAGE);

            // (������������) ������ ������ ���������
            // (������) ������������������
            // orderIdField.setText("ORD-" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-" + System.currentTimeMillis() % 10000);
            // customerField.setText("");
            // productNameField.setText("");
            // productCodeField.setText("");
            // quantityField.setText("");
            // unitPriceField.setText("");
            // totalField.setText("0");
            // addressField.setText("");
            // phoneField.setText("");
        });

        // ----- ������ ������ ������ ������ ��� ��� ������ ������ ������ (��������� ������) -----
        // ----- ��������������������������������������������� (������������) -----

        // ������ ������ ��� ��� ������ ���������
        // ������������������������������������
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateTotal(quantityField, unitPriceField, totalField);
            }
        });

        // ������ ������ ��� ��� ������ ���������
        // ������������������������������������
        unitPriceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateTotal(quantityField, unitPriceField, totalField);
            }
        });

        // ��������� ��������� ������ (��������� ������ 2��� ������)
        // ������������������������ (������������������2���)
        panel.add(btn);

        // ��� ������ ��������� (��������� 2������ ���������������)
        // ������������ (���������������2���)
        // GridLayout��� 11��� 2������������ 22��� ������ ���������
        // ������������: 10��� ������(������+���������) = 20��� + ������ 1��� = ��� 21���
        // ��������� ��� ��� 1������ ������������ 22���(11�����2���)��� ������
        panel.add(new JLabel(""));  // ��� ��������� ������ ������

        // ������ ������������ ������ ������
        // ���������������������������
        frame.add(panel);

        // ������ ��������� ������ ������
        // ���������������������
        frame.setSize(500, 550);

        // ������������ ������ ��������� ������
        // ���������������������������
        frame.setLocationRelativeTo(null);

        // ������ ��������� ������ ������ ������ ������ (������������ ������)
        // ��������������������������������� (������������)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ������ ��������� ������
        // ���������������
        frame.setVisible(true);
    }

    // ----- ��� ������ ������ ������ ��������� -----
    // ----- ��������������������������� -----
    private static void calculateTotal(JTextField quantityField, JTextField unitPriceField, JTextField totalField) {
        try {
            String qtyText = quantityField.getText().trim();
            String priceText = unitPriceField.getText().trim();

            if (!qtyText.isEmpty() && !priceText.isEmpty()) {
                int qty = Integer.parseInt(qtyText);
                int price = Integer.parseInt(priceText);
                int total = qty * price;

                // ��� ������ ������ ������
                // ���������������������
                totalField.setText(String.format("%,d", total));
            } else {
                totalField.setText("0");
            }
        } catch (NumberFormatException ex) {
            // ��������� ������ ������ ������������ ��� ��������� 0������ ������
            // ������������������������������������������������0
            totalField.setText("0");
        }
    }
}
