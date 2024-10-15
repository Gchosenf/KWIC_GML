import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("经典软件体系结构教学工具");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(9, 1)); // 行数调整为9

            JLabel inputLabel = new JLabel("输入文本:");
            JTextArea inputTextArea = new JTextArea(10, 40);
            JScrollPane inputScrollPane = new JScrollPane(inputTextArea);

            JLabel outputLabel = new JLabel("输出文本:");
            JTextArea outputTextArea = new JTextArea(10, 40);
            outputTextArea.setEditable(false);
            JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

            String[] architectures = {"主程序-子程序", "面向对象", "事件系统", "管道-过滤"};
            JComboBox<String> architectureSelector = new JComboBox<>(architectures);

            JButton processButton = new JButton("处理");
            JButton showDescriptionButton = new JButton("显示架构说明");
            JButton showDiagramButton = new JButton("显示原理图");
            JButton showCodeStructureButton = new JButton("显示代码结构");

            panel.add(inputLabel);
            panel.add(inputScrollPane);
            panel.add(outputLabel);
            panel.add(outputScrollPane);
            panel.add(new JLabel("选择体系结构:"));
            panel.add(architectureSelector);
            panel.add(processButton);
            panel.add(showDescriptionButton);
            panel.add(showDiagramButton); // 添加显示原理图按钮
            panel.add(showCodeStructureButton); // 添加显示代码结构按钮

            frame.add(panel, BorderLayout.CENTER);
            frame.setVisible(true);

            // 处理按钮的动作
            processButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputText = inputTextArea.getText();
                    String[] lines = inputText.split("\n");
                    Input input = new Input();
                    input.setLines(lines);

                    String result = "";
                    switch (architectureSelector.getSelectedIndex()) {
                        case 0:
                            result = processWithProcedural(input);
                            break;
                        case 1:
                            result = processWithObjectOriented(input);
                            break;
                        case 2:
                            result = processWithEventSystem(input);
                            break;
                        case 3:
                            result = processWithPipeAndFilter(input);
                            break;
                    }

                    // 仅返回处理结果，不包括架构说明
                    outputTextArea.setText(result);
                }
            });

            // 显示架构说明按钮的动作
            showDescriptionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String description = getArchitectureExplanation(architectureSelector.getSelectedIndex());
                    JOptionPane.showMessageDialog(frame, description, "架构说明", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            // 显示原理图按钮的动作
            showDiagramButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showImage(getDiagramPath(architectureSelector.getSelectedIndex()));
                }
            });

            // 显示代码结构按钮的动作
            showCodeStructureButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String codeStructure = getCodeStructure(architectureSelector.getSelectedIndex());
                    JOptionPane.showMessageDialog(frame, codeStructure, "代码结构", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        });
    }

    private static String processWithProcedural(Input input) {
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();

        return String.join("\n", alphabetizer.getKwicList()); // 仅返回处理结果
    }

    private static String processWithObjectOriented(Input input) {
        ObjectOrientedKWIC kwic = new ObjectOrientedKWIC(input.getLineTxt());
        kwic.process();

        return String.join("\n", kwic.getResults()); // 仅返回处理结果
    }

    private static String processWithEventSystem(Input input) {
        EventSystem eventSystem = new EventSystem(input.getLineTxt());
        eventSystem.process();

        return String.join("\n", eventSystem.getResults()); // 仅返回处理结果
    }

    private static String processWithPipeAndFilter(Input input) {
        PipeAndFilter pipeAndFilter = new PipeAndFilter(input.getLineTxt());
        pipeAndFilter.process();

        return String.join("\n", pipeAndFilter.getResults()); // 仅返回处理结果
    }

    // 获取架构说明的文本
    private static String getArchitectureExplanation(int index) {
        switch (index) {
            case 0: return ArchitectureExplaination.getProceduralExplanation();
            case 1: return ArchitectureExplaination.getObjectOrientedExplanation();
            case 2: return ArchitectureExplaination.getEventSystemExplanation();
            case 3: return ArchitectureExplaination.getPipeAndFilterExplanation();
            default: return "";
        }
    }

    // 获取原理图的文件路径
    private static String getDiagramPath(int index) {
        return "D:\\软件质量测试体系结构设计模式\\pictures\\" + (index + 1) + ".png"; // 根据索引返回对应图片路径
    }

    // 显示图片
    private static void showImage(String path) {
        try {
            Image img = ImageIO.read(new File(path));
            JLabel label = new JLabel(new ImageIcon(img));
            JOptionPane.showMessageDialog(null, label, "原理图", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "无法加载图片: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 获取代码结构的文本
    private static String getCodeStructure(int index) {
        switch (index) {
            case 0:
                return "主程序-子程序代码结构:\n"
                        + "1. 主程序类\n"
                        + "   - 入口方法\n"
                        + "   - 调用子程序\n"
                        + "2. 子程序类\n"
                        + "   - 功能实现\n"
                        + "   - 输出结果\n";
            case 1:
                return "面向对象代码结构:\n"
                        + "1. 类定义\n"
                        + "   - 属性\n"
                        + "   - 方法\n"
                        + "2. 关系\n"
                        + "   - 继承\n"
                        + "   - 组合\n";
            case 2:
                return "事件系统代码结构:\n"
                        + "1. 事件源\n"
                        + "   - 触发事件\n"
                        + "2. 事件监听器\n"
                        + "   - 处理事件\n";
            case 3:
                return "管道-过滤代码结构:\n"
                        + "1. 数据流管道\n"
                        + "   - 输入数据\n"
                        + "2. 过滤器\n"
                        + "   - 处理数据\n"
                        + "3. 输出结果\n";
            default: return "";
        }
    }
}
