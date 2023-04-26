package com.etc.test.util.LogisticsRegression;

import lombok.Data;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

import java.util.Arrays;

//逻辑回归算法
@Data
public class LogisticRegression {
    private double threshold = 0.5; // 阈值，默认为0.5
    private double learningRate = 0.1; // 学习率，默认为0.1
    private int maxIter = 1000; // 最大迭代次数，默认为1000

    private double intercept; // 截距
    private RealVector coefficients; // 系数

    public void fit(double[][] X, double[] y) {
        int m = X.length; // 样本数
        int n = X[0].length; // 特征数

        // 初始化系数
        coefficients = new ArrayRealVector(n);
        for (int i = 0; i < n; i++) {
            coefficients.setEntry(i, 0.0);
        }
        intercept = 0.0;

        // 梯度下降算法
        for (int iter = 0; iter < maxIter; iter++) {
            double[] h = new double[m]; // 预测值
            double[] errors = new double[m]; // 误差

            // 计算预测值和误差
            for (int i = 0; i < m; i++) {
                double z = intercept;
                for (int j = 0; j < n; j++) {
                    z += coefficients.getEntry(j) * X[i][j];
                }
                h[i] = sigmoid(z);
                errors[i] = h[i] - y[i];
            }

            // 更新参数
            double[] gradient = new double[n]; // 梯度
            for (int j = 0; j < n; j++) {
                double sum = 0.0;
                for (int i = 0; i < m; i++) {
                    sum += errors[i] * X[i][j];
                }
                gradient[j] = sum / m;
            }
            intercept -= learningRate * Arrays.stream(errors).sum() / m;
            coefficients = coefficients.subtract(new ArrayRealVector(gradient).mapMultiply(learningRate));
        }
    }

    public double predict(double[] X) {
        double z = intercept;
        for (int j = 0; j < coefficients.getDimension(); j++) {
            z += coefficients.getEntry(j) * X[j];
        }
        double h = sigmoid(z);
        return (h >= threshold) ? 1.0 : 0.0;
    }

    private double sigmoid(double z) {
        return 1.0 / (1.0 + Math.exp(-z));
    }

}
