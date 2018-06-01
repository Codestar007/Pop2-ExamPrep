import java.util.ArrayList;

/**
 * Created by kjeged01 on 01/06/2018.
 */
public class MyEnums {
    enum Days{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }
    public static ArrayList<String> enumIteration() {
        Days[] days = Days.values();
        ArrayList<String> stringDay = new ArrayList<String>();
        for (Days day : days) {
            stringDay.add(day.toString());
        }
        return stringDay;
    }

        public static void main(String[] args) {
            System.out.println(enumIteration());
        }
}

/*
* Key Points

Some key points on the enum type are:

    Java enums extend the java.lang.Enum class implicitly. Therefore, you cannot extend any other class in enum.
    Enums can implement interfaces. They implicitly implement the Serializable and Comparable interfaces.
    This means if you need some common functionality along diverse enum types, you can define it with an interface
    to have the enums provide the method implementations.
    In Java, enum is a keyword. Enum constructors are always private or default. Therefore, you cannot have public
    or protected constructors in an enum type.
    In an enum definition, comma separated constants must be terminated with a semicolon.
    You cannot create an instance of enum using the new operator.
    You can declare abstract methods within an enum. If you do so, all the enum fields must implement the abstract methods.
    You can use the “==” operator to compare enum constants effectively, since enum constants are final.

Summary

I often see code with lots of int constants representing a set of predefined values instead of enums, which is a better fit.
I attribute this to inexperienced programmers who are not familiar with enums.

Enums remove “magic numbers.” These are numbers that don’t really mean anything on their own. By replacing those numbers
with actual values, your code makes more sense and follows better coding principles.

Also, enums prevent incorrect values from being passed to a function. Consider that you have a method that takes an int value. T
his method will execute if we pass any int value. But if you want to restrict the values that the method takes as inputs,
you should ideally use enums. This is what is called type safety. Enums let you control the required set of inputs.
*/