public class Main {

    public static int arr(String[][] a) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (a.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < a[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(a[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }

        return sum;
    }


    public static void main(String[] args) {
        //arr(new String[][]{{"1"},{"2"},{"3"},{"4"}});
        String[][] a = new String[][]{{"1","2","2","2"}, {"2","2","2","2"}, {"3","2","2","2"}, {"4","2","2","2"}};
        try {
            try {
                int result = arr(a);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива не соответствует");
            }
        } catch (MyArrayDataException e) {
            System.out.println("В массиве лежит неправильное значение ");
            System.out.println("В этой ячейке "+ e.getI() +e.getJ());
        }
    }
}
