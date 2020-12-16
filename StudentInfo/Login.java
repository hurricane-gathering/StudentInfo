// Login.java
package StudentInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {
    // 定义主窗口
    private final JFrame jf;
    // 定义输入用户名和密码的标签提示
    private final JLabel InputUserName;
    private final JLabel InputPassWord;
    // 定义输入用户名文本框
    private final JTextField UserName;
    // 定义输入密码框
    private final JPasswordField PassWord;
    // 定义登录和取消按钮
    private final JButton Login;
    private final JButton Cancel;

    Login() {
        // 各组件实例化过程
        jf = new JFrame("Login");
        InputUserName = new JLabel("        ID：    ");
        InputPassWord = new JLabel("password:");
        UserName = new JTextField();
        PassWord = new JPasswordField();
        Login = new JButton("登录");
        Cancel = new JButton("退出");
        // 设置主窗口大小、位置和布局
        jf.setSize(400, 150);
        jf.setLocation(600, 400);
        // 设置窗口流式布局
        jf.setLayout(new FlowLayout());
        // 设置用户名和密码框大小
        UserName.setPreferredSize(new Dimension(300, 30));
        PassWord.setPreferredSize(new Dimension(300, 30));
        // 依次向主窗口添加各组件
        jf.getContentPane().add(InputUserName);
        jf.getContentPane().add(UserName);
        jf.getContentPane().add(InputPassWord);
        jf.getContentPane().add(PassWord);
        jf.getContentPane().add(Login);
        jf.getContentPane().add(Cancel);
        // 设置主窗口不可调节大小
        jf.setResizable(false);
        // 设置主窗口默认关闭操作
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 给登录和取消按钮添加 Action 监听器
        Login.addActionListener(this);
        Cancel.addActionListener(this);
        // 设置主窗口可见
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 如果单击【退出】按钮则程序退出
        if (e.getSource().equals(Cancel)) {
            System.exit(0);
        }
        // 如果单击【登录】按钮则检查用户名和密码是否匹配
        else if (e.getSource().equals(Login)) {
            // 如果用户名和密码匹配，则打开具体操作面板
            if (UserName.getText().equals("admin") && String.valueOf(PassWord.getPassword()).equals("1234")) {
                MySQLGUI myS = new MySQLGUI();
                myS.initial();
                jf.setVisible(false);
                jf.dispose();
            }
            // 如果用户名和密码不匹配，则给出提示对话框
            else {
                JOptionPane.showOptionDialog(jf, "用户名或密码错误", "登陆失败",
                        JOptionPane.CLOSED_OPTION,
                        JOptionPane.ERROR_MESSAGE, null, null, null);
            }
        }
    }
}
