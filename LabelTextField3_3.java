package day1;
import javax.swing.*;
import java.awt.*;
public class LabelTextField3_3 {
    public static void main(String[] args) {
        // 创建主窗口（注册窗口）
        JFrame frame = new JFrame("注册");
        // 创建面板 - 使用 GridLayout（4行2列）
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        // GridLayout(行数, 列数, 水平间距, 垂直间距)
        // rows=4（标签+输入框 3 对 + 按钮 1 个）
        // cols=2（标签列、输入框列）
        // hgap=10（水平间距），vgap=10（垂直间距）

        // ----- 1. 姓名输入 -----
        panel.add(new JLabel("姓名："));                    // 姓名标签
        JTextField nameField = new JTextField(15);        // 姓名输入框
        panel.add(nameField);

        // ----- 2. 密码输入 -----
        panel.add(new JLabel("密码:"));               // 密码标签
        JPasswordField passwordField = new JPasswordField(15); // 密码输入框（输入内容显示为 ●）
        panel.add(passwordField);
        // JPasswordField 在输入时不会显示字符，而是显示为 ● 或 *（出于安全考虑）
        // JPasswordField 输入时字符不显示，显示为 ● 或 *（用于安全）

        // ----- 3. 邮箱输入 -----
        panel.add(new JLabel("电子邮箱："));                 // 电子邮箱标签
        JTextField emailField = new JTextField(15);       // 邮箱输入框
        panel.add(emailField);
        // ----- 4. 注册按钮（合并为两列） -----

        JButton btn = new JButton("注册");
        // 为了将按钮合并为两列，不直接添加到面板中，而是单独处理
        // 为了合并2列，不直接添加到面板，而是单独处理
        // 处理按钮点击事件（使用 Lambda 表达式）
        // 处理按钮点击事件（使用 Lambda 表达式）

        btn.addActionListener(e -> {
            // 获取输入值
            String name = nameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String email = emailField.getText().trim();

            // ----- 有效性验证 (Validation) -----

            // 1) 姓名验证
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "请输入姓名！",
                        "输入错误",
                        JOptionPane.WARNING_MESSAGE);
                nameField.requestFocus(); // 将光标移至姓名输入框
                return;
            }

            // 2) 密码验证（至少4位）
            // 2) 密码验证（至少4位）
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "请输入密码！",
                        "输入错误",
                        JOptionPane.WARNING_MESSAGE);
                passwordField.requestFocus();
                return;

            }
            if (password.length() < 4) {
                JOptionPane.showMessageDialog(frame,
                        "密码必须至少为4个字符！",
                        "输入错误",
                        JOptionPane.WARNING_MESSAGE);
                passwordField.requestFocus();
                return;
            }
            // 3) 邮箱验证（简单检查邮箱格式——是否包含 @）
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "请输入邮箱！",
                        "输入错误",
                        JOptionPane.WARNING_MESSAGE);
                emailField.requestFocus();
                return;
            }
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(frame,
                        "电子邮件格式不正确！（例如：user@email.com）",
                        "输入错误",
                        JOptionPane.WARNING_MESSAGE);
                emailField.requestFocus();
                return;
            }

            // ----- 所有输入均正常时显示会员信息 -----
            // 生成显示会员信息的提示框
            // 创建显示会员信息的消息

            String message = "🎉 注册成功！ 🎉\n\n"
                    + "━━━━━━━━━━━━━━━━━━━━\n"
                    + "📝 会员信息\n"
                    + "━━━━━━━━━━━━━━━━━━━━\n"
                    + "姓名   : " + name + "\n"
                    + "密码：" + "*".repeat(password.length()) + "\n"  // 出于安全考虑，用●代替
                    + "电子邮箱  : " + email + "\n"
                    + "━━━━━━━━━━━━━━━━━━━━\n"
                    + "欢迎！😊";
            // 通过消息对话框显示会员信息
            // 使用消息对话框显示会员信息

            JOptionPane.showMessageDialog(frame,
                    message,
                    "注册成功",
                    JOptionPane.INFORMATION_MESSAGE);

            // (可选) 初始化输入字段
            // (可选) 清空输入字段
            // nameField.setText("");
            // passwordField.setText("");
            // emailField.setText("");
        });

        // 将按钮添加到面板中（在4行2列的最后一行合并2列）
        // 将按钮添加到面板（在第4行第2列的最后一行合并2列）
        panel.add(btn);

        // 填充空白（使按钮占据2列）
        // 填充空白（使按钮占据2列）
        // GridLayout 为 4 行 2 列，因此需要 8 个单元格
        // 目前：姓名（标签+字段）2个 + 密码（标签+字段）2个 + 邮箱（标签+字段）2个 + 按钮 1个 = 总计 7个
        // 因此，需添加1个空单元格，以凑足8个（4行×2列）
        // GridLayout 为 4 行 2 列，需要 8 个单元格

        // 目前：姓名（标签+字段）2个 + 密码（标签+字段）2个 + 邮箱（标签+字段）2个 + 按钮1个 = 共7个
        // 因此添加1个空单元格以匹配8个（4行×2列）

        panel.add(new JLabel(""));  // 用空标签填充位置
        // 将面板添加到主框架中

        frame.add(panel);
        // 设置主框架大小

        frame.setSize(400, 200);
        // 将框架置于屏幕中央
        // 将窗口置于屏幕中央

        frame.setLocationRelativeTo(null);

        // 设置主框架关闭按钮的行为（程序退出）
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示主框架
        frame.setVisible(true);

    }
}
