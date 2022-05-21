package com.springboot.demo.demo;

public class FastAndSlow {
    public static void main(String[] args) {
   /*     Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);*/

     /*   head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " +findLinkedListCycleStart(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " +findLinkedListCycleStart(head));

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " +findLinkedListCycleStart(head));*/


        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(12);
      //  System.out.println("Is palindrome: " + checkPalindrome(head));

        reorder(head);

        System.out.println(happyNumber(12));

    }


    public static boolean findLinkedListCycle(Node head) {

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;

        }
        return false;
    }

    public static int findLinkedListCycleStart(Node head) {

        Node slow = head;
        Node fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                count = findLinkedListCycleLength(slow);
                break;
            }

        }
        slow = head;
        fast = head;
        while (count > 0) {
            fast = fast.next;
            --count;
        }
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.value;
    }

    public static int findLinkedListCycleLength(Node head) {
        Node current = head;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != head);

        return cycleLength;
    }


    /*Any number will be called a happy number if,
after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.*/
    public static boolean happyNumber(int number) {

        int slow = sumNum(number);
        int fast = sumNum(sumNum(number));
        while (slow != fast) {
            slow = sumNum(slow);
            fast = sumNum(sumNum(fast));
        }
        return slow == 1;

    }

    public static int sumNum(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum = sum + (digit * digit);
            num = num / 10;
        }
        return sum;
    }


    public static int findMiddleofLinkedList(Node node) {

        Node fast = node.next;
        Node slow = node;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.value;
    }

    public static boolean checkPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        // find middle of the LinkedList
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node headSecondHalf = reverseLinkedList(slow); // reverse the second half
        Node copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverseLinkedList(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;
        return false;

    }



    public static void reorder(Node head) {
        // find middle of the LinkedList
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node headSecondHalf =reverseLinkedList(slow);
        Node  headFirstHalf=head;
        while (headFirstHalf != null && headSecondHalf != null){


            Node temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;



        }

        // set the next of the last node to 'null'
        if (headFirstHalf != null)
            headFirstHalf.next = null;
        printLinkedList(head);
    }


    public static Node reverseLinkedList(Node head) {

        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void printLinkedList(Node n) {
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }


}


class Node {
    Node next;
    int value = 0;

    public Node(int value) {
        this.value = value;

    }
    public Node(int value, Node next) {
        this.value = value;
        this.next=next;

    }
}


