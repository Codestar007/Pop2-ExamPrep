public class NoahsArk {
    public static void main(String[] args){
        String[][] animalList = {
                {"bears", "mammal", "Growl", "Terrestrial"},
                {"beetles", "layeggs", "Drone", "Flying"},
                {"cats", "mammal", "Purr", "Terrestrial"},
                {"crocodiles", "layeggs", "Grunt", "Aquatic"},
                {"dogs", "mammal", "Bark", "Terrestrial"},
                {"dolphins", "mammal", "Click", "Aquatic"},
                {"eagles", "layeggs", "Scream", "Flying"},
                {"flies", "layeggs", "Buzz", "Flying"},
                {"frogs", "layeggs", "Croak", "Aquatic"},
                {"lizards", "layeggs", "Chirp", "Terrestrial"},
                {"monkeys", "mammal", "Gibber", "Terrestrial"},
                {"pigeons", "layeggs", "Coo", "Flying"},
                {"salmon", "layeggs", "FRT", "Aquatic"},
                {"sharks", "layeggs", "SharkSilence", "Aquatic"},
                {"snakes", "layeggs", "Hiss", "Terrestrial"},
                {"whales", "mammal", "whistles", "Aquatic"}
        };

        AnimalInterface anAnimal;

        for (int i = 0; i < animalList.length; i++){
            if (animalList[i][1].equals("mammal")){
                anAnimal = new Mammals(animalList[i][0], animalList[i][1],
                        animalList[i][2], animalList[i][3]);
            } else{
                anAnimal = new EggLaying(animalList[i][0], animalList[i][1],
                        animalList[i][2], animalList[i][3]);
            }

            // Call the animal
            anAnimal.call();
            // As the animal to make a sound
            anAnimal.makeSound();
            // As the animal to reproduce
            anAnimal.reproduce();
            System.out.println("");

        }


    }
}
