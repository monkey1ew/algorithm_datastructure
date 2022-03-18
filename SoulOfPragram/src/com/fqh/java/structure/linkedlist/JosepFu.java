package com.fqh.java.structure.linkedlist;

/**
 * @author 比奇堡海滩
 * @version 1.0
 */
public class JosepFu {
    public static void main(String[] args) {
        //测
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.list();

//        circleSingleLinkedList.countBoy(1, 2, 5);
        circleSingleLinkedList.outBoy(1, 2, 5);
    }
}


//创建环形的单向链表
class CircleSingleLinkedList{

    //创建一个first节点, 当前没有编号
    private Boy first = new Boy(-1);

    /**
     *
     * @param k 从第k个人开始数
     * @param m 数 m 次
     * @param nums 一共多少小孩
     */
    public void outBoy(int k, int m, int nums){
        if (first == null || k < 0 || k > nums){
            System.out.println("数据不合法.......");
            return;
        }
        //定义辅助变量[保持在first的后面]
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
//        helper.setNext(first);
        }
            //从第k个开始, 默认first为1号小孩
        for (int i = 0; i < k - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //数几次 ,死哪个?
        while (true){
            if (first == helper){
                break; //说明只剩下一个了
            }
            for (int i = 0; i < m - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("第 %d 个小孩死掉\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留着圈的的小孩编号%d \n", first.getNo());

    }
    //添加小孩节点, 构建环形链表
    public void addBoy(int nums){
        //nums数据校验b
        if (nums < 1){
            System.out.println("nums的值不合法............");
            return;
        }
        Boy curBoy = null; //辅助指针,构建环形链表
        //使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个boy
            if (i == 1){
                first = boy;
                first.setNext(first); //构成一个环
                curBoy = first; //让curBoy 指向第一个小孩
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy; //将curBoy后移
            }
        }
        System.out.printf("剩下第 %d个小孩\n", first.getNo());
    }

    //遍历当前的环形链表
    public void list(){
        //判断链表是否null
        if (first == null){
            System.out.println("链表为空..........");
            return;
        }
        //first不能动; 使用辅助指针
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext(); //指针后移
        }
    }

    //根据用户的输入计算出小孩出圈的顺序
    /**
     *
     * @param startNo 从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums){
        //先对数据校验
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("数据不合法.............");
            return;
        }
        //创建辅助指针, 完成小孩出圈
        Boy helper = first;
        //先让helper 指向最后的节点
        while (true){
            if (helper.getNext() == first){ //说明helper指向最后了
                break;
            }
            helper = helper.getNext();
        }
        //先让first 和 helper 移动startNo - 1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时, 让first 和 helper指针同时移动 m-1次
        //循环操作,
        while (true){
            if (helper == first){ //说明圈中只有一个节点
                break;
            }
            //让first helper同时移动 countNum - 1次 报数
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向的节点就是要 出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //让first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
    }

}

//创建boy节点
class Boy{
    private int no;
    private Boy next; //指向下一个boy

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
