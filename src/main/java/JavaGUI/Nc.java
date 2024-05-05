package JavaGUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Nc extends WindowAdapter implements ActionListener {
    //循环标志
    boolean flag = false;
    //Socket定义
    Socket client;
    //多行文本框
    JTextArea jTextArea;
    //单行文本框
    JTextField jTextField;
    //窗体
    JFrame jFrame;
    PrintWriter printWriter;
    ServerSocket serverSocket;
    //默认监听端口
    static int port = 5555;
    //当前时间
    SimpleDateFormat current_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        if(args.length == 1){
            port = Integer.parseInt(args[0]);
        }else {
            String help = "1> 默认监听端口<5555> \n       java nc \n2> 自定监听端口 \n      java nc <port> ";
            System.out.println(help);
        }
        new Nc();
    }

    public Nc() {
        try {
            serverSocket = new ServerSocket(port);
            this.ServerFrame("监听端口" + serverSocket.getLocalPort());
            this.serve();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public void serve(){
        flag = true;
        while (flag){
            try {
                client = serverSocket.accept();
                System.out.println("[" + current_date.format(new Date()) + "]" + client.getInetAddress() + "已建立连接!");
                // 输入流
                InputStream clientInputStream = client.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientInputStream));
                //输出流
                OutputStream clientOutputStream = client.getOutputStream();
                // 参数true表示每写一行 printWriter缓存就自动溢出 把数据写到目的地
                printWriter = new PrintWriter(clientOutputStream, true);
                String str;
                while ((str = bufferedReader.readLine()) != null){
                    jTextArea.append(str + "\n");
                   // if(str.equals("bye")){
                   //     flag = false;
                   //     break;
                   // }
                }
                //关闭流
                clientInputStream.close();
                bufferedReader.close();
                clientOutputStream.close();
                printWriter.close();
            } catch (IOException e) {
                System.out.println("[" + current_date.format(new Date()) + "]" + client.getInetAddress() + "连接断开!");

            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        jTextArea.append(jTextField.getText() + "\n");
        printWriter.println(jTextField.getText());
        jTextField.setText("");
    }
    //关闭窗口退出程序

    @Override
    public void windowClosing(WindowEvent e) {
        //printWriter.println("bye");
        System.exit(0);
    }
    public void ServerFrame(String port){
        //构建窗体设置标题
        jFrame = new JFrame(port);
        //设置布局方式
        jFrame.setLayout(new BorderLayout());
        //设置窗口大小
        jFrame.setSize(400,300);
        //窗口居中
        jFrame.setLocationRelativeTo(null);
        //设置窗口禁止缩放
        jFrame.setResizable(false);

        //多行文本框
        jTextArea = new JTextArea();
        //不可编辑
        jTextArea.setEditable(false);
        //字体设置
        jTextArea.setFont(new Font("Consolas",Font.PLAIN,16));
        //边框
        jTextArea.setBorder(new BevelBorder(1));

        //单行文本框
        jTextField = new JTextField(20);
        jTextField.setFont(new Font("Consolas",Font.PLAIN,16));

        //发送按钮
        JButton jButton = new JButton("发送");
        jButton.addActionListener(this);
        jTextField.addActionListener(this);
        Container container = jFrame.getContentPane();
        container.add(jTextArea,BorderLayout.CENTER);

        //创建一个面板
        JPanel jPanel = new JPanel();
        jPanel.add(jTextField);
        jPanel.add(jButton);
        //将面板放入窗口中
        container.add(jPanel,BorderLayout.SOUTH);
        jFrame.addWindowListener(this);
        //设置窗口可见
        jFrame.setVisible(true);
    }
}
