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
        String[][] a = new String[][]{{"1","2","2","2"}, {"2","2","2","2"}, {"3","2","2","2"}, {"4","2","2","2"}};
        try {
            try {
                int result = arr(a);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Ðàçìåð ìàññèâà íå ñîîòâåòñòâóåò");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Â ìàññèâå ëåæèò íåïðàâèëüíîå çíà÷åíèå ");
            System.out.println("Â ýòîé ÿ÷åéêå "+ e.getI() +e.getJ());
        }
    }
}
