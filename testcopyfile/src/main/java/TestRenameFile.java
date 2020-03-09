import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestRenameFile {

    public static void main(String [] args) {

       /* String fileName1 = args[0];
        String fileName2 = args[1];

        // initialize File object
        File origFile = new File(fileName1);
        File destFile = new File(fileName2);
        // check if file exists
        if(origFile.exists()){
            // rename the file
            boolean result = origFile.renameTo(destFile);
            // check if the rename operation is success
            if(result){
                System.out.println("Operation Success");
            }else{
                System.out.println("Operation failed");
            }

        }else{
            System.out.println("File does not exist");
        }*/

        Integer data[] = {10,20,30,40,50,60,71,80,90,91};
        List<Integer> ls = Arrays.asList(data);

        Predicate<Integer> isEven = i -> i % 2 == 0;

        Predicate<Integer> isOdd = isEven.negate();

        List<Integer> pari = filterGeneric(ls, isOdd);

        /*for(Integer i:pari){
            System.out.println(i);
        }*/

        ls.stream().filter(isEven).forEach(i -> System.out.println(i));

    }

    public static <T> List<T> filterGeneric(List<T> inventory, Predicate<T> p){

        List<T> list = new ArrayList<T>();

        for(T t:inventory){
            if(p.test(t))
                list.add(t);
        }

        return list;
    }
}
