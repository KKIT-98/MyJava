package JavaGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StrChange {
    public static void main(String[] args) {

        //按钮字体
        Font buttonFont = new Font("宋体", Font.BOLD, 16);

        //文本标签字体
        Font TexFont = new Font("黑体", Font.BOLD, 18);


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
        jPanelTex1.setBorder(new LineBorder(Color.magenta));
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
        jPanelTex2.setBorder(new LineBorder(Color.magenta));
        jPanelTex2.setBounds(350,10,100,30);

        //文本标签 待转换文本
        JLabel jLabelTex2 = new JLabel("转换后文本");
        //设置文本标签字体
        jLabelTex2.setFont(TexFont);
        //将文本标签添加到文本标签面板
        jPanelTex2.add(jLabelTex2);


        //设置空布局 随意摆放组件
        jFrame.getContentPane().setLayout(null);


        //将Panel面板添加到JFrame容器中
        jFrame.getContentPane().add(jPanelTex1); //文本标签面板 待转换文本
        jFrame.getContentPane().add(jPanelTex2); //文本标签面板 转换后文本

        //设置窗口是否可见
        jFrame.setVisible(true);

    }
}
