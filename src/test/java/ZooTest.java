

import org.junit.Test;

public class ZooTest {

    @Test
    publc void shouldFeedAllAnimals(){
        Zoo zoo = new Zoo();
        Animal[] animals = {new Dog(), new Gorilla(), new Lion(), new Tiger(),};
        zoo.feedAnimals(animals);
    }


}
