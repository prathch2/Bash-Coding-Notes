package cmsc256;


public class MyBook implements Comparable<MyBook> {
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String ISBN10;
    private String ISBN13;

    public MyBook() { this("None Given", "None Given", "None Given", "0000000000", "0000000000000"); }

    public MyBook(String title, String authorFirstName, String authorLastName, String ISBN10, String ISBN13) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.ISBN10 = ISBN10;
        this.ISBN13 = ISBN13;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if(title == null) throw new IllegalArgumentException("Title cannot be null");
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setAuthorFirstName(String authorFirstName) {
        if(authorFirstName == null) throw new IllegalArgumentException("Title cannot be null");
        this.authorFirstName = authorFirstName;
    }
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) {
        if(authorLastName == null) throw new IllegalArgumentException("Title cannot be null");
        this.authorLastName = authorLastName;
    }
    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setISBN10(String ISBN10) {
        String s = ISBN10;
        if(s.length() != 10) throw new IllegalArgumentException("invalid argument is passed");
        for (int i = 0; i < ISBN10.length(); i++) {
            boolean digit = Character.isDigit(ISBN10.charAt(i));
            if(!digit) throw new IllegalArgumentException("invalid argument is passed");
        }
        this.ISBN10 = ISBN10;
    }
    public String getISBN10() {
        return ISBN10;
    }

    public void setISBN13(String ISBN13) {
        String s = ISBN13;
        if (s.length() != 13) throw new IllegalArgumentException("invalid argument is passed");
        for (int i = 0; i < ISBN13.length(); i++) {
            boolean digit = Character.isDigit(ISBN13.charAt(i));
            if (!digit) throw new IllegalArgumentException("invalid argument is passed");
        }
        this.ISBN13 = ISBN13;
    }
    public String getISBN13() {
        return ISBN13;
    }

    public String toString() {
        return ("Title: " + this.title + '\n' + "Author: " + this.authorFirstName + " " + this.authorLastName + '\n' + "ISBN10: " + this.ISBN10 + '\n' + "ISBN13: " + this.ISBN13);
    }


    public boolean equals(Object otherBook) {
       if(this == otherBook) {
           return true;
        } else if(!(otherBook instanceof MyBook)) {
           return false;
       }
       return true;
    }

    @Override
    public int compareTo (MyBook other){
        int result = this.authorLastName.compareTo(other.getAuthorLastName());
        if(result == 0) {
            result = this.authorFirstName.compareTo(other.getAuthorFirstName());
        } if(result == 0){
            result = this.title.compareTo(other.getTitle());
        }
        return result;
    }
}
