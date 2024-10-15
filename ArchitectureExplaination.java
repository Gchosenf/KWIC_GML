public class ArchitectureExplaination {
    public static String getProceduralExplanation() {
        return "主程序-子程序架构:\n" +
                "这种架构通过使用主程序来控制流程，并通过子程序来实现具体的功能。子程序可以重复调用。\n";
    }

    public static String getObjectOrientedExplanation() {
        return "面向对象架构:\n" +
                "这种架构通过类和对象来组织代码。每个类封装了数据和功能，通过对象之间的交互实现功能。\n";
    }

    public static String getEventSystemExplanation() {
        return "事件系统架构:\n" +
                "这种架构基于事件驱动编程，组件通过发布/订阅模式进行交互。\n";
    }

    public static String getPipeAndFilterExplanation() {
        return "管道-过滤架构:\n" +
                "这种架构通过将数据流分为多个阶段，每个阶段称为过滤器。过滤器通过管道连接。\n";
    }
}
