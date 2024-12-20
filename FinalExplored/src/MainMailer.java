import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {

    public static void main(String[] args) {

        String[] names = {"Ann Jones", "Ann Jones Ph.D.", "Bob Jones M.D.", "Carol Jones", "Ed Green M.D.", "Ed Black"};


        List<StringBuilder> population = getName(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();

        population.forEach(s -> {
            counts.merge(s, 1, (oldVal,newVal) -> oldVal+1 );
        });

        System.out.println(counts);
        StringBuilder annJonesPhd = new StringBuilder("Ann Jones Ph.D.");
        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);


        List<StringBuilder> cleanedName = standardizeName(population);
        System.out.println(cleanedName);

        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);


    }

    private static List<StringBuilder> getName (String [] names){

        List<StringBuilder> list = new ArrayList<>();
        int index = 3;
        for (String name : names){
            for (int i =0 ; i< index ; i++){
                list.add(new StringBuilder(name));
            }
            index++;
        }
        return list;

    }


    private static List<StringBuilder> standardizeName (List<StringBuilder> list){

        List<StringBuilder> newList = new ArrayList<>();
        for (StringBuilder name : list){
            for (String suffix : new String[]{"Ph.D.", "M.D." }){

                if( name.indexOf(suffix)> -1 ){
                    StringBuilder newName = name.replace(name.indexOf(suffix)-1, name.length(), "");
                    newList.add(newName);
                }


            }


        }
        return newList;
    }
}
