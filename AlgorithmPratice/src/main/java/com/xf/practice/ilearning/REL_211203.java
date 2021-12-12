package com.xf.practice.ilearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class REL_211203 {
    Node mudi = null;

    class Node {
        Node parent;
        List<Node> children;
        String name;
        //boolean flag;
        int level;
        public Node(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }

    public String copyDir(String[] target, int num, String[] src) {
        StringBuffer sb = new StringBuffer();
        Node tarRoot = build(target, num);
        Node srcRoot = build(src, -1);

        merge(mudi, srcRoot);
        print(tarRoot, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }


    public void print(Node node, StringBuffer sb) {
        int level = node.level;
        String blank = createBlank(level);
        sb.append(blank + node.name +"¥n");

        int childCount = node.children.size();

        for (int i = 0; i < childCount; i++) {
            Node child = node.children.get(i);
            print(child, sb);
        }
    }

    public String createBlank(int count) {
        String blank = "";
        for (int i = 0; i < count; i++) {
            blank +="  ";
        }
        return blank;
    }

    public Node build(String[] paths, int num) {
        Stack<Node> stack = new Stack<Node>();
        Node root = null;

        int count = paths.length;


        for (int i = 0; i < count; i++) {
            String path = paths[i];
            int level = getLevel(path);
            String name = path.trim();
            Node node = new Node(name, level);
            node.children = new ArrayList<Node>();

            if (num == i + 1) {
                //node.flag = true;
                mudi = node;
            }

            if (stack.isEmpty()) {
                stack.push(node);
                root = node;
                continue;
            }

            while (stack.peek().level >= level) {
                stack.pop();
            }

            Node parent = stack.peek();
            parent.children.add(node);
            node.parent = parent;
            stack.push(node);

        }
        return root;
    }

    public void merge (Node target, Node src) {
        int tarChildCount = target.children.size();
        int srcChildCount = src.children.size();

        for (int i = 0; i < srcChildCount; i++) {
            boolean nashi = true;
            Node srcNode = src.children.get(i);
            for (int j = 0; j < tarChildCount; j++) {
                Node tarNode = target.children.get(j);
                if (srcNode.name.equals(tarNode.name)) {
                    merge(target.children.get(j), src.children.get(i));
                    nashi = false;
                }
            }

            if (nashi) {
                target.children.add(src.children.get(i));
                refreshLevel(src.children.get(i), target.level);
            }

        }

    }

    public void refreshLevel(Node node, int level) {
        int size = node.children.size();
        node.level = level + 1;
        for (int i = 0; i < size; i++) {
            Node child = node.children.get(i);
            if (child.children.size() != 0) {
                refreshLevel(child, node.level + 1);
            }
            child.level = node.level + 1;
        }
    }

    public int getLevel(String path) {
        int level = 0;

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == ' ') {
                level++;
            }
        }
        return level / 2;
    }

    public static void main(String[] args) {
        REL_211203 tm = new REL_211203();
        tm.copyDir(
                new String[] {"home", "  usr", "    bin", "    sbin", "      dir", "    log" },
                2,
                new String[] {"tools", "   xiafei1", "  xiafei2", "  bin","    xyz", "      abc"});


    }

}
