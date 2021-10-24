package ru.mephi;

public class Main {
    public static void main(String[]args) {
        int arr1[] = {1, 3, 5, 7};
        List list1 = new List(arr1);

        int arr2[] = {2, 4, 6, 8};
        List list2 = new List(arr2);

        List newList = List.merge(list1, list2);

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
    }
}