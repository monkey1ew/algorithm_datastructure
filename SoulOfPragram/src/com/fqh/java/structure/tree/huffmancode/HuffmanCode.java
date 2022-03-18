package com.fqh.java.structure.tree.huffmancode;

import java.io.*;
import java.util.*;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class HuffmanCode {

    public static void main(String[] args) {

        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
//        System.out.println(contentBytes.length); //40
        //分布过程
//        List<Node> nodes = getNodes(contentBytes);
//        System.out.println(nodes);
//
//        //创建哈夫曼树
//        System.out.println("赫夫曼树");
//        Node huffmanTreeRoot = createHuffmanTree(nodes);
//        System.out.println("前序遍历");
//        preOrder(huffmanTreeRoot);
//
//        //生成对应的哈夫曼编码
//        getCodes(huffmanTreeRoot);
//        System.out.println("生成的哈夫a曼编码表" + huffmanCodes);
//
//        //测试
//        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println("压缩后 :" + Arrays.toString(huffmanCodeBytes));
        //发送huffman编码后的字节数组
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println("原来的= " + new String(sourceBytes));


    }
    
    //将文件进行压缩
    /**
     * @param srcFile 源文件路径
     * @param destFile 目的地路径
     */
    public static void zipFile(String srcFile, String destFile) {
        //创建输入流
        FileInputStream is = null;
        ObjectOutputStream oos = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //压缩源文件
            byte[] huffmanBytes = huffmanZip(b);
            os = new FileOutputStream(destFile);
            //创建一个和文件输出流关联的对象输出流
            oos = new ObjectOutputStream(os);
            //使用对象流的方式写入, 方便恢复
            oos.writeObject(huffmanBytes);

            oos.writeObject(huffmanCodes);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //对压缩文件的解压
    public static void unZipFile(String zipFile, String destFile) {
        //定义文件的输入流
        InputStream is = null;
        //定义对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try {
            is = new FileInputStream(zipFile);
            //创建和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组, huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取保存的哈夫曼编码表
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(codes, huffmanBytes);
            File file;
            os = new FileOutputStream(destFile);
            //写数据到destFile
            os.write(bytes);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //完成数据的解压
    //1.将huffmanCodeBytes 数组-------->转成11000111000.....
    // 哈夫曼编码对应的二进制字符串
    //2.将哈夫曼编码对应的二进制字符串 =====>对照哈夫曼编码转成==>"i like like...."

    //完成对压缩数据的解码
    /**
     * @param huffmanCodes 哈夫曼编码表
     * @param huffmanBytes  哈夫曼编码得到的字符数组
     * @return  原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

        //1. 先得到huffmanBytes 对应的二进制的字符串 "1100101010010....."
        StringBuilder stringBuilder1 = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder1.append(byteToBitString(!flag, b));
        }
//        System.out.println("哈夫曼字节数组转成对应的二进制字符串=" + stringBuilder1.toString());
        //把字符串按照指定的哈夫曼编码进行解码
        //a->100
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建一个集合存放 byte
        List<Byte> list = new ArrayList<>();
        //i 就是一个索引,不停的扫描stringBuilder
        for (int i = 0; i < stringBuilder1.length();) {
            int count = 1; //
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //取出一个'1' '0' 1100101010010.....
                String key = stringBuilder1.substring(i, i+count); //不动让count移动
                b = map.get(key);
                if (b == null) {
                    count++;
                }else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //当for循环结束后list存放了所有的字符
        //把list中的数据放入到byte[]
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }


    /**
     * 将一个byte 转成一个二进制的字符串
     * @param b 传入的byte
     * @param flag 标识是否需要补高位, 如果是最后一个字节无需补高位
     * @return 是该b 对应的二进制对应的字符串, 补码
     */
    private static String byteToBitString(boolean flag, byte b) {
        //临时遍历保存b
        int temp = b; //b--->int
        //如果是整数，需要补高位
        if (flag) {
            temp |= 256; //按位与 256 1 0000 0000 | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码

        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    //使用一个方法将前面的方法封装
    /**
     * @param bytes 原始的字符串对应的字节数组
     * @return  返回的是经过哈夫曼编码处理后(压缩)的字节数组
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据nodes 创建哈夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //根据哈夫曼树--------> 生成对应的哈夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据 哈夫曼编码对原始的字节数组 压缩
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

        return huffmanCodeBytes;
    }

    //将字符串对应的byte数组[] ,通过哈夫曼编码表, 返回一个哈夫曼编码压缩后的byte[]
    /**
     * @param bytes 原始字符串对应的byte数组
     * @param huffmanCodes  哈夫曼编码
     * @return  返回哈夫曼编码处理后的byte数组
     * byte[] contentBytes = content.getBytes();
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        //1.利用哈夫曼编码表 将 bytes 转成 哈夫曼编码的字符串101010000010.....
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuilder.toString());
        //将"1010100101111100000.... 转成 byte[]"
        //统计返回byte[] huffmanCodeBytes 长度
//        int len = (stringBuilder.length() + 7) / 8;
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建存储压缩后的bytes数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0; //记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {//每8位一个字节byte
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                //不够8位 一个节点
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);

                //将strByte转成byte, 放入到huffmanCodeBytes
                huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);

            }
        }
        return huffmanCodeBytes;
    }

    //生成哈夫曼树对应的哈夫曼编码
    //1.将哈夫曼编码表放在 Map<Byte, String> 形式
    // 32-> 01, 97 -> 100, 100-->11000...[形式]
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2.在生成哈夫曼编码表时，需要拼接路径, StringBuilder 存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();
    /** 重载 getCodes */
    private static Map<Byte, String> getCodes(Node root){
        if (root == null) {
            return null;
        }
        //处理左子树
        getCodes(root.left, "0", stringBuilder);
        //处理右子树
        getCodes(root.right, "1", stringBuilder);

        return huffmanCodes;
    }
    /**
     * 将传入的node节点的所有叶子节点的哈夫曼编码存放到 map
     * @param node 根节点
     * @param code 路径: 左子节点-0  右子节点-1
     * @param stringBuilder 进行路径的拼接
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将Code加入到 stringBuilder2
        stringBuilder2.append(code);
        if (node != null){ //node == null 不处理
            //判断当前node 是叶子节点还是非叶子节点
            if(node.data == null){ //非叶子节点
                //递归处理
                //向左
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            }else { //是一个叶子节点
                //表示找到了整个叶子节点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /**
     * @param bytes 传入字节数组
     * @return 返回list
     */
    private static List<Node> getNodes(byte[] bytes) {
        //1.创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();

        //遍历bytes, 统计每个byte出现的次数 -> map
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes){
            Integer count = counts.get(b);
            if (count == null){ //map还没有这个字符数据
                counts.put(b, 1);
            }else {
                counts.put(b, count+1);
            }
        }
        //把每个键值对转成一个Node 对象, 加入到nodes集合
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //(4)通过List创建哈夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1){
            //排序, 小---->大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二颗最小的二叉树
            Node rightNode = nodes.get(1);
            //创建一个新的二叉树, 它的根节点没有data, 只有权值
            Node parent = new Node(leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //将处理过的从nodes移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }
        //nodes， 最后的节点就是huffman树的根节点
        return nodes.get(0);
    }

    //前序遍历
    public static void preOrder(Node root){
        if(root != null) {
            root.preOrder();
        }else {
            System.out.println("哈夫曼树为空//////");
        }
    }
}

//创建Node节点, 存数据和权值
class Node implements Comparable<Node>{
    Byte data; //存放数据本身, 'a' => 97 ' ' => 32
    int weight; //权值, 字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}