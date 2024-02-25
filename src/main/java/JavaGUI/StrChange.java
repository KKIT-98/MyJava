package JavaGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrChange {
    public static void main(String[] args) {

        /*通用字体设置
         * */
        //按钮字体
        Font buttonFont = new Font("宋体", Font.BOLD, 16);
        //文本标签字体
        Font TexFont = new Font("黑体", Font.BOLD, 18);
        //文本域字体
        Font TextAreaFont = new Font("TimesNewRoman",Font.PLAIN,14);

        //创建Frame窗口
        JFrame jFrame = new JFrame("文本转换");
        jFrame.setBounds(20,110,530,750);
        ImageIcon icon = new ImageIcon("1.png");
        jFrame.setIconImage(icon.getImage());
        //设置窗口是否可以缩放
        jFrame.setResizable(false);
        //窗口生成在屏幕中央
        jFrame.setLocationRelativeTo(null);
        //点击退出按钮接受进程
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //创建一个JPanel对象存放文本标签 --> 待转换文本
        JPanel jPanelTex1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //显示面板边框及颜色
        //jPanelTex1.setBorder(new LineBorder(Color.magenta));
        jPanelTex1.setBounds(50,10,100,30);

        //文本标签 待转换文本
        JLabel jLabelTex1 = new JLabel("待转换文本");
        //设置文本标签字体
        jLabelTex1.setFont(TexFont);
        //将文本标签添加到文本标签面板
        jPanelTex1.add(jLabelTex1);


        //创建一个JPanel对象存放文本标签 --> 转换后文本
        JPanel jPanelTex2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //显示面板边框及颜色
        //jPanelTex2.setBorder(new LineBorder(Color.magenta));
        jPanelTex2.setBounds(350,10,100,30);

        //文本标签 转换后文本
        JLabel jLabelTex2 = new JLabel("转换后文本");
        //设置文本标签字体
        jLabelTex2.setFont(TexFont);
        //将文本标签添加到文本标签面板
        jPanelTex2.add(jLabelTex2);

        //创建一个JPanel对象存放【文本域待转换文本】
        JPanel jPanelTexArea1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //显示面板边框及颜色
        //jPanelTexArea1.setBorder(new LineBorder(Color.GREEN));
        jPanelTexArea1.setBounds(20,50,200,600);
        //让JTextArea平铺整个JPanel
        jPanelTexArea1.setLayout(new BorderLayout());

        //创建一个30行20列的【文本域待转换文本】
        JTextArea jTextArea1 = new JTextArea(30, 20);
        //将【文本域待转换文本】放入滚动窗口
        JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);

        //设置文本域自动换行
        jTextArea1.setLineWrap(true);
        //设置文本域组件背景颜色
        //jTextArea1.setBackground(Color.MAGENTA);
        //设置文本域字体样式
        jTextArea1.setFont(TextAreaFont);
        jPanelTexArea1.add(jTextArea1);

        //设置滚动条面板位置和大小
        jScrollPane1.setBounds(20,50,200,600);
        //设置滚动速度
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(30);
        //设置水平滚动条从不显示
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);




        //创建一个JPanel对象存放【文本域转换完文本】
        JPanel jPanelTexArea2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //显示面板边框及颜色
        //jPanelTexArea2.setBorder(new LineBorder(Color.GREEN));
        //设置组件位置
        jPanelTexArea2.setBounds(300,50,200,600);
        //让JTextArea平铺整个JPanel
        jPanelTexArea2.setLayout(new BorderLayout());

        //创建一个30行20列的【文本域转换完文本】
        JTextArea jTextArea2 = new JTextArea(30, 20);
        //将【文本域转换完文本】放入滚动窗口
        JScrollPane jScrollPane2 = new JScrollPane(jTextArea2);

        //设置文本域自动换行
        jTextArea2.setLineWrap(true);
        //设置文本域组件背景颜色
        //jTextArea2.setBackground(Color.MAGENTA);
        //设置文本域字体样式
        jTextArea2.setFont(TextAreaFont);
        jPanelTexArea2.add(jTextArea2);

        //设置滚动条面板位置和大小
        jScrollPane2.setBounds(300,50,200,600);
        //设置滚动速度
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(30);
        //设置水平滚动条从不显示
        jScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);



        //创建一个JPanel对象存放【转换按钮】
        JPanel jPanelButton1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //显示面板边框及颜色
        //jPanelButton1.setBorder(new LineBorder(Color.YELLOW));
        //设置组件位置
        jPanelButton1.setBounds(20,660,200,50);

        //创建转换按钮组件
        JButton ChangeButton = new JButton();
        //设置转换按钮文本
        ChangeButton.setText("转 换");
        //设置转换按钮字体
        ChangeButton.setFont(buttonFont);
        //设置转换按钮大小
        ChangeButton.setPreferredSize(new Dimension(120,40));
        //将转换按钮加载到转换按钮面板上
        jPanelButton1.add(ChangeButton);




        //创建一个JPanel对象存放【复制按钮】
        JPanel jPanelButton2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //显示面板边框及颜色
        //jPanelButton2.setBorder(new LineBorder(Color.YELLOW));
        //设置组件位置
        jPanelButton2.setBounds(300,660,200,50);

        //创建复制按钮组件
        JButton CopyButton = new JButton();
        //设置复制按钮文本
        CopyButton.setText("复 制");
        //设置复制按钮字体
        CopyButton.setFont(buttonFont);
        //设置复制按钮大小
        CopyButton.setPreferredSize(new Dimension(120,40));
        //将复制按钮加载到转换按钮面板上
        jPanelButton2.add(CopyButton);


        //设置空布局 随意摆放组件
        jFrame.getContentPane().setLayout(null);


        //将Panel面板添加到JFrame容器中
        jFrame.getContentPane().add(jPanelTex1); //文本标签面板 待转换文本
        jFrame.getContentPane().add(jPanelTex2); //文本标签面板 转换后文本

        //添加文本域面板【待转换文本】
        jFrame.getContentPane().add(jPanelTexArea1); //文本域待转换文本
        jScrollPane1.getViewport().add(jPanelTexArea1); //将普通面板添加到滚动条面板【文本域待转换文本】
        jFrame.getContentPane().add(jScrollPane1); //文本域待转换文本滚动条


        //添加文本域面板【转换完文本】
        jFrame.getContentPane().add(jPanelTexArea2); //文本域转换完文本
        jScrollPane2.getViewport().add(jPanelTexArea2); //将普通面板添加到滚动条面板【文本域转换完文本】
        jFrame.getContentPane().add(jScrollPane2); //文本域转换完文本滚动条


        //将按钮面板添加到JFrame容器中
        jFrame.getContentPane().add(jPanelButton1); //转换按钮
        jFrame.getContentPane().add(jPanelButton2); //复制按钮

        //设置窗口是否可见
        jFrame.setVisible(true);


        //监听器将实现了ActionListener的类创建对象绑定给按钮对象
        //转换按钮
        ChangeListener changeListener = new ChangeListener();
        ChangeButton.addActionListener(changeListener);
        //复制按钮
        CopyListener copyListener = new CopyListener();
        CopyButton.addActionListener(copyListener);

        //获取待转换文本域文本
        String textArea1Text = jTextArea1.getText();
        //先赋一个空值保证输入框显示能够获取，在输入后调用getText()方法覆盖空值
        System.out.println("初始化文本" + textArea1Text);
        //将输入待转换文本域对象传给监听器
        changeListener.text = jTextArea1;
        changeListener.text2 = jTextArea2;
        System.out.println(changeListener.text2.getText());
        copyListener.text = jTextArea2;


    }

    //转换按钮监听器
    public static class ChangeListener implements ActionListener{
        JTextArea text;
        JTextArea text2;
        @Override
        public void actionPerformed(ActionEvent e) {
            //获取按钮上的字符串
            String buttonStr = e.getActionCommand();
            //验证监听器，监听点击按钮的动作事件
            System.out.println(buttonStr);
            System.out.println("转换按钮被点击");
            //获取文本域的文字
            String getTex = text.getText().trim();
            if(getTex.isEmpty()){
                JOptionPane.showMessageDialog(null,"请输入待转换文本！","警告",JOptionPane.WARNING_MESSAGE);
            }else {
                String processStr = getTex + "\n";
                String replaceStr = "(" + processStr.replaceAll("\\n","','") + ")";
                text2.setText(replaceStr);
                System.out.println(replaceStr);
            }
        }
    }

    //复制按钮监听器
    public static class CopyListener implements ActionListener{
        JTextArea text;
        @Override
        public void actionPerformed(ActionEvent e) {
            //获取按钮上的字符串
            String buttonStr = e.getActionCommand();
            //验证监听器，监听点击按钮的动作事件
            System.out.println(buttonStr);
            System.out.println("复制按钮被点击");
            //获取文本域的文字
            String getTex = text.getText().trim();
            //验证是否获取到了转换的文本域文字
            System.out.println(getTex);
            //创建焦点
            text.requestFocus();
            //选择全部
            text.selectAll();
            //复制到剪切板
            text.copy();

        }
    }

}
