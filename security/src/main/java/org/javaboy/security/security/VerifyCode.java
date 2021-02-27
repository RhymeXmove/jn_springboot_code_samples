package org.javaboy.security.security;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerifyCode {
    private int width = 100;
    private int height = 50;
    private String[] fontNames = {"宋体", "楷体", "隶书", "微软雅黑"};
    private Color bgColor = new Color(255,255,255);
    private Random random = new Random();
    private String codes =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String text;
    private Color randomColor() {
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red, green, blue);
    }

    private Font randomFont() {
        String name = fontNames[random.nextInt(fontNames.length)];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(name, style, size);
    }

    // 得到codes的长度内的随机数 并使用charAt 取得随机数位置上的codes中的字符
    private char randomChar() {
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }


    // 创建一张验证码的图片
    public BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(bgColor);
        g2.fillRect(0,0,width,height);


        // 返回图片
        return image;

    }

    public BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuffer sb = new StringBuffer();
        // 向图中画四个字符
        for (int i = 0; i < 4; i++) {
            String s = randomChar() + "";
            sb.append(s);
            float x = i * 1.0F * width / 4;
            g2.setFont(randomFont());
            g2.setColor(randomColor());
            g2.drawString(s, x, height - 5);

        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }


    // 画干扰线
    private void drawLine(BufferedImage image) {
        int num = 3;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2.setStroke(new BasicStroke(1.5F));// 不知道
            g2.setColor(Color.blue);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    // 得到验证码的文本 后面是用来和用户输入的验证码 检测用
    public String getText() {
        return text;
    }

    // 定义输出的对象和输出的方向
    public static void output(BufferedImage bi, OutputStream fos)
            throws FileNotFoundException, IOException {
        ImageIO.write(bi, "JPEG", fos);
    }


}
