import java.util.*;

public class SkillManagement {
    public static void main(String[] args){
        HashSet<String> set=new HashSet<>();
        set.add("Java");
        set.add("SQL");
        set.add("Spring Boot");
        set.add("Java");
        set.add("React");
        set.add("Docker");
        set.add("SQL");
        set.add("AWS");

        System.out.println("Set:"+set);

        set.remove("Docker");

        System.out.println("Set Size:"+set.size());


        LinkedHashSet<String> linkedSet=new LinkedHashSet<>();
        linkedSet.add("Java");
        linkedSet.add("SQL");
        linkedSet.add("Spring Boot");
        linkedSet.add("Java");
        linkedSet.add("React");
        linkedSet.add("Docker");
        linkedSet.add("SQL");
        linkedSet.add("AWS");

        System.out.println("LinkedSet:"+linkedSet);

        linkedSet.remove("Docker");

        System.out.println("LinkedSet Size:"+linkedSet.size());

        TreeSet<String> treeSet=new TreeSet<>();
        treeSet.add("Java");
        treeSet.add("SQL");
        treeSet.add("Spring Boot");
        treeSet.add("Java");
        treeSet.add("React");
        treeSet.add("Docker");
        treeSet.add("SQL");
        treeSet.add("AWS");

        System.out.println("Set:"+treeSet);

        treeSet.remove("Docker");

        System.out.println("TreeSet Size:"+treeSet.size());

        set.add("Gen AI");
        set.add("Machine learning");

        linkedSet.add("AI");
        linkedSet.add("Computer Vision");

        treeSet.addAll(set);

        System.out.println("Set:"+set);
        System.out.println("LinkedSet:"+linkedSet);
        System.out.println("TreeSet:"+treeSet);

        System.out.println("Set contains Java?"+set.contains("Java"));
        System.out.println("Is LinkedSet Empty?"+linkedSet.isEmpty());
    }
}
