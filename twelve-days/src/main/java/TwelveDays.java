class TwelveDays {

    String verseCore = "On the %s day of Christmas my true love gave to me: ";

    String[] gifts = {"a Partridge in a Pear Tree",
            "two Turtle Doves",
            "three French Hens",
            "four Calling Birds",
            "five Gold Rings",
            "six Geese-a-Laying",
            "seven Swans-a-Swimming",
            "eight Maids-a-Milking",
            "nine Ladies Dancing",
            "ten Lords-a-Leaping",
            "eleven Pipers Piping",
            "twelve Drummers Drumming"};
    String[] ordinals = {"", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
    "eleventh", "twelfth"};

    String verse(int verseNumber) {
        String createdVerse = String.format(verseCore, ordinals[verseNumber]);
        for(int index = verseNumber-1; index>-1; index--){
            createdVerse += gifts[index];
            //here I am trying to figure out if a comma needs to be added
            if(index-1>-1){
                createdVerse += ", ";
            }
            //here I am trying to predict if there is a last gift to add to the line. If so, we need to add "and"
            if(index-1 == 0){
                createdVerse += "and ";
            }
        }
        createdVerse+=".\n";
        return createdVerse;
    }

    String verses(int startVerse, int endVerse) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
    
    String sing() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
