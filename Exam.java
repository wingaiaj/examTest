import org.junit.Test;

import javax.swing.*;
import javax.swing.text.html.parser.Parser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName Exam
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/27 8:20
 * @Version 1.0
 */
public class Exam {

    public static void main(String[] args) {
        oval oval = new oval();
        oval.init();
//        try {
//            new Exam().init();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    //统计骰子旋转500次后每个面出现的频率（起始面是随机的）
    public void init11() throws Exception {

        JTextArea jTextArea = new JTextArea(10, 12);
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        for (int i = 0; i < 500; i++) {
            int random = (int) (Math.random() * 6 + 1);
            switch (random) {
                case 1 -> one++;
                case 2 -> two++;
                case 3 -> three++;
                case 4 -> four++;
                case 5 -> five++;
                case 6 -> six++;
            }
            jTextArea.setText("面\t频率\n"
                             + 1 + "\t" + one+"\n"
                             + 2 + "\t" + two+"\n"
                             + 3 + "\t" + three+"\n"
                             + 4 + "\t" + four+"\n"
                             + 5 + "\t" + five+"\n"
                             + 6 + "\t" + six+"\n");


        }
        JOptionPane.showMessageDialog(null, jTextArea, "骰子旋转500次", JOptionPane.INFORMATION_MESSAGE);


    }


    //打印1，3，5，7的阶乘以及这些阶乘的和
    @Test
    public void init10() {
        int sum = 0;
        int y = 1;
        for (int i = 1; i <= 7; i++) {
            y = y * i;
            if (i % 2 == 0) {
                continue;
            }

            sum += y;
            System.out.println(i + "!=" + y);
        }
        System.out.println("sum=" + sum);
    }

    @Test
    public void testInit7() {
        //主窗口创建
        JFrame jFrame = new JFrame();
        //容器创建
        JPanel jPanel = new JPanel();
        //文本域创建
        JTextArea jTextArea = new JTextArea(5, 15);
        //按钮创建
        JButton jButton1 = new JButton(new AbstractAction("open file") {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(jFrame, null, FileDialog.LOAD);
                fileDialog.setVisible(true);
                String directory = fileDialog.getDirectory();
                jTextArea.setText(directory);
            }
        });
        JButton jButton2 = new JButton(new AbstractAction("save file") {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(jFrame, null, FileDialog.SAVE);
                fileDialog.setVisible(true);
                String directory = fileDialog.getDirectory();
                jTextArea.setText(directory);
            }
        });
        //组装
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jFrame.add(jPanel, BorderLayout.NORTH);
        jFrame.add(jTextArea);

        //设置窗口大小
        jFrame.pack();
        //设置窗口可见
        jFrame.setVisible(true);
    }


    //判断当前路径下是否有文件
    public void init5() {
        System.out.println("请输入文件路径:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        if (filePath != null) {
            File file = new File(filePath);
            boolean exists = file.exists();
            if (!exists) {
                System.out.println(filePath + "(系统找不到指定文件。)请确认文件路径及文件名是否正确!");
                return;
            }
            System.out.println("文件存在");
        }

    }

    //降序排列
    public String init6(Student... students) {
        Student[] studentArr = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
            studentArr[i] = students[i];
        }
        return Arrays.toString(studentArr);
    }

    @Test
    public void TestInit6() {
        Student student1 = new Student("zx1", 414);
        Student student2 = new Student("zx2", 92);
        Student student3 = new Student("zx3", 85);
        String init = init6(student1, student2, student3);
        System.out.print(init);

    }

    //通过否？小窗口程序
    public void init8() {
        String inputString = JOptionPane.showInputDialog(null, "输入结果(1=通过,2=不通过)", "输入", JOptionPane.QUESTION_MESSAGE);
        int pass = 0;
        int noPass = 0;
        if (inputString != null) {
            char[] chars = inputString.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ("1".equals(String.valueOf(chars[i]))) {
                    pass++;
                }
                if ("2".equals(String.valueOf(chars[i]))) {
                    noPass++;
                }
            }

            JOptionPane.showMessageDialog(null, "通过: " + pass + "\n" + "不通过: " + noPass, "对考试结果的分析示例", JOptionPane.INFORMATION_MESSAGE);
        }


    }


    //小窗口程序记录两角度之和的余弦
    public void init3() {
        JFrame jFrame = new JFrame("计算两角和余弦函数");
        JLabel label = new JLabel("角度1");
        JLabel label2 = new JLabel("角度2");
        JTextField jTextField = new JTextField(10);
        JTextField jTextField2 = new JTextField(10);
        JTextArea jTextArea = new JTextArea(10, 50);
        JButton jButton = new JButton(new AbstractAction("计算") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextField.getText();
                String text1 = jTextField2.getText();
                int v = Integer.parseInt(text);
                int v1 = Integer.parseInt(text1);
                int sum = v + v1;
                double cos = Math.cos(sum * Math.PI / 180);

                String str = new BigDecimal(cos + "").toString();

                jTextArea.setText("cos((" + v + "+" + v1 + ")*3.1415926/180)= " + str);
            }
        });
        JPanel jPanel = new JPanel();
        jPanel.add(label);
        jPanel.add(jTextField);
        jPanel.add(label2);
        jPanel.add(jTextField2);
        jPanel.add(jButton);

        jFrame.add(jPanel, BorderLayout.NORTH);
        jFrame.add(jTextArea);

        jFrame.pack();
        jFrame.setVisible(true);
    }


    //用户输入整数 打印其数相等长宽的矩阵
    public void init1(int n) {
        //创建指定大小的数组
        int[][] arr = new int[n][n];
        //随机赋值 填充数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int num = (int) (Math.random() * 100 + 1);
                arr[i][j] = num;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        System.out.println("主对角线的和为:" + sum);
    }

    //传入二维数组打印最大值 和其所在的位置
    public String init2(int[][] arr) {
        int Max = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                if (Max < arr[i][j]) {
                    Max = arr[i][j];
                }
            }
        }
        return "max=" + Max + "+row:+" + i + "column:" + j;
    }

    //保存或删除文件
    public void init9() {
        JFrame jFrame = new JFrame();
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Menu");
        JTextArea jTextArea = new JTextArea(10, 15);
        JMenuItem jMenuItem1 = new JMenuItem(new AbstractAction("SaveFile") {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(new File("D:\\ds.txt"));
                    fileOutputStream.write(jTextArea.getText().getBytes());

                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (fileOutputStream != null)
                            fileOutputStream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        JMenuItem jMenuItem2 = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenuBar.add(jMenu);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jTextArea);
        jFrame.pack();
        jFrame.setVisible(true);

    }
}