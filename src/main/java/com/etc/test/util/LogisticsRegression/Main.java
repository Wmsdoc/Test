package com.etc.test.util.LogisticsRegression;
public class Main {

    public static void main(String[] args) {
        // 训练数据
        double[][] X = {
                {1.0, 2.0, 3.0, 100.0},
                {4.0, 5.0, 6.0, 99.0},
                {7.0, 8.0, 9.0, 120.0},
                {10.0, 11.0, 12.0, 80.0},
                {13.0, 14.0, 15.0, 70.0},
                {16.0, 17.0, 18.0, 90.0}
        };
        double[] y = {1.0, 0.0, 0.0, 0.0, 0.0, 0.0};

        // 创建LogisticRegression对象
        LogisticRegression lr = new LogisticRegression();

        // 训练模型
        lr.fit(X, y);

        // 打印模型参数
        System.out.println("截距: " + lr.getIntercept());
        System.out.println("系数: " + lr.getCoefficients());

        // 预测新数据
        double[] X_new = {19.0, 20.0, 21.0,90.0};
        double y_new = lr.predict(X_new);
        System.out.println("预测标签: " + y_new);
    }
}
