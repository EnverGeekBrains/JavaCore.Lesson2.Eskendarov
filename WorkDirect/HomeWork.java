package ru.eskendarov.ea.homework;

public class HomeWork {

    public static void main(String[] args) {

        String[][] arrays = new String[][]{{"1","1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {
            int sum = convertAndSum(arrays);
            System.out.println("Sum of the whole array = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Size problem: " + e.getMessage());
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Value problem: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static int convertAndSum(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        if (arr.length != 4) throw new MyArraySizeException("Incorrect size array, ", arr.length);

        for (int i = 0; i < arr.length; i++) {
            String[] val = arr[i];
            for (int j = 0; j < val.length; j++) {
                if (val.length != 4)
                    throw new MyArraySizeException("Invalid inner array, ", arr.length);

                try {
                    sum += Integer.parseInt(val[j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid element value", val[j], i, j);
                }
            }

        }
        return sum;
    }

}
