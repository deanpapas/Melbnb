/*
 * PropertyTypes
 * 
 * V2.0
 *
 * 29/03/2022
 */

/*
 * The PropertyTypes class defines the 3 different types of property. 
 * They are in a seperate class to ensure future types can added easily.
 */

public class PropertyTypes {

    public enum Types {
        TYPE1("Private room"),
        TYPE2("Entire place"),
        TYPE3("Shared room");

        private String string;

        Types(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }

    }
}