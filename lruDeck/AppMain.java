package lruDeck;

/**
 * Created by Ajay Wadhara on 12/2/2016.
 * Main class for testing LRU cache
 */
public class AppMain {

    public static void main(String ...args){
        LRUWithDeck lruWithDeck = new LRUWithDeck(4);
        lruWithDeck.put(1,1);
        lruWithDeck.put(2,1);
        lruWithDeck.put(3,1);
        lruWithDeck.put(4,1);
        System.out.println(lruWithDeck.toString());
        lruWithDeck.put(5,1);
        System.out.println(lruWithDeck.toString());
        lruWithDeck.put(1, 1);
        lruWithDeck.get(4);

        System.out.println(lruWithDeck.toString());
    }
}
