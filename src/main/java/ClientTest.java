import java.util.*;
import java.util.stream.Collectors;

public class ClientTest {
    public static List<String> returnTopStrings(String s,int top) {
        Map<String,Integer> countRepeated = new HashMap<>();
        List<String> trivialWords = Arrays.asList("a", "and", "of", "are", "the", "to", "in", "it", "with", "but", "so", "at");
        List<String> returnList = new ArrayList<>();

        if( s!=null && !s.isEmpty()){
            String[] eachWordArray = s.split(" ");
            for(String eachWrd: eachWordArray){
                if(!trivialWords.contains(eachWrd)){
                    eachWrd =  eachWrd.replaceAll("[^a-zA-Z0-9]", "");
                    if(countRepeated.containsKey(eachWrd)){
                        countRepeated.put(eachWrd, countRepeated.get(eachWrd)+1);
                    } else {
                        countRepeated.put(eachWrd,1);
                    }

                }
            }

            Map<String, Integer> map = countRepeated.entrySet().stream().sorted().collect(
                    Collectors.toMap(a -> a.getKey(), b -> b.getValue()));


            Map<String,Integer>sortedMap = sortByValue(countRepeated);
            //List<String> returnList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                if(top>entry.getValue()){
                    returnList.add(entry.getKey());
                }
                //System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }


        return returnList;
    }
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {

        String s="Considering how common illness is, how tremendous the spiritual change that it brings, how astonishing, when the lights of health go down, the undiscovered countries that are then disclosed, what wastes and deserts of the soul a slight attack of influenza brings to view, what precipices and lawns sprinkled with bright flowers a little rise of temperature reveals, what ancient and obdurate oaks are uprooted in us by the act of sickness, how we go down into the pit of death and feel the water of annihilation close above our heads and wake thinking to find ourselves in the presence of the angels and harpers when we have a tooth out and come to the surface in the dentist’s arm-chair and confuse his “Rinse the Mouth rinse the mouth with the greeting of the Deity stooping from the floor of Heaven to welcome us when we think of this, as we are frequently forced to think of it, it becomes strange indeed that illness has not taken its place with love and battle and jealousy among the prime themes of literature.";
        returnTopStrings(s, 123);

    }


}
