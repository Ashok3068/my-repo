package com.springboot.demo.demo;


public class LinkedListAddTwoNumbers {

    public static void main(String[] args) {
        int[] a={2,4,9};
        int[] b={5,6,4,9};
        ListNode listNode1 = getLinkedList(a);
        ListNode node2 = getLinkedList(b);
        display(listNode1);
        display(node2);

        ListNode add = addTwoNumbers(listNode1, node2);

        display(add);


    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {




        int carry = 0;
        ListNode latestNode = null;

        while (l2 != null || l1 != null) {
            int sum1 = 0;
            if (l2 != null && l1 != null) {
                sum1 = l2.val + l1.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 != null) {
                sum1 = l2.val + carry;
                l2 = l2.next;
            } else if (l1 != null) {
                sum1 = l1.val + carry;
                l1 = l1.next;
            }
            carry = sum1 / 10;
            sum1 = sum1 % 10;


           /* if (sum1 % 10 != 0) {

            } else {
                carry = 1;
                sum1 = sum1 % 10;
            }*/
            if (latestNode == null)
                latestNode = new ListNode(sum1);
             else add(latestNode, sum1);

            if (l2 == null && l1== null && carry == 1) {
                add(latestNode, carry);
            }


        }

        return latestNode;


    }


    static ListNode add(ListNode l, int val) {

        if (l == null)
            return new ListNode(val);

        else /*if (l.next == null) {
            l.next = new ListNode(val);
            return l;

        } else */{

            ListNode temp = l;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
            return l;
        }

    }

    static ListNode reverse(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode nextElement = head.next;
            head.next = previous;
            previous = head;
            head = nextElement;
        }
        return previous;
    }

    static void display(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("");
    }

    static int getSize(ListNode listNode) {
        int i =0;
        while (listNode != null) {
            listNode = listNode.next;
            ++i;
        }
      return i;
    }

    static ListNode getLinkedList(int a[]) {
        ListNode listNode1 = null;

        for (int i=0;i<a.length;i++) {
            if(i==0){
                 listNode1 = new ListNode(a[i]);
            }else{
            listNode1 = add(listNode1, a[i]);}
        }
        return listNode1;

    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
