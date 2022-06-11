package cmsc256;

public class Grid {
    private char[][] grid = new char[3][3];

    /*
    * Initializes a 3 by 3 grid to default char values ('\u0000')
    * */
    public Grid() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                grid[row][column] = ('\u0000');
            }
        }
    }

        /**
         * Formats the grid row to a String that consists of a space, the char,
         *  a space, a vertical pipe, a space, the char, a space, a vertical pipe,
         * a space, the char, and a final space,
         * for example: " X | X | X "
         *
         * @param rowIndex  the index of the row to convert to a String
         * @return a formatted String representation of the row
         * @throws IllegalArgumentException if an invalid row index is given
         */
        public String getRow(int rowIndex) throws IllegalArgumentException {
            String getRow = "";

            if (rowIndex < 0 || rowIndex >= 3) throw new IllegalArgumentException("invalid row index is given");
            if (rowIndex > 0 || rowIndex <= 3) {
                for (int i = 0; i < grid[rowIndex].length; i++) {
                    if(grid[rowIndex][i] == '\u0000') {
                        grid[rowIndex][i] = ' ';
                    }
                }
                getRow = (" " + grid[rowIndex][0] + " |" + " " + grid[rowIndex][1] + " |" + " " + grid[rowIndex][2] + " ");
            }
            return getRow;
        }

        /**
         * Sets the grid location to the given value
         * @param value         char value for the grid location
         * @param rowIndex      the index of the row position
         * @param columnIndex   the index of the column position
         * @throws IllegalArgumentException if the row index or column index is invalid
         *                                  or if the position is not null
         */
        public void setPosition(char value, int rowIndex, int columnIndex) throws IllegalArgumentException {
            if(rowIndex < 0 || rowIndex >= 3) throw new IllegalArgumentException("row index is invalid");
            if(columnIndex < 0 || columnIndex >= 3) throw new IllegalArgumentException("column index is invalid");
            if(grid[rowIndex][columnIndex] != '\u0000') throw new IllegalArgumentException("Position is not empty");
            grid[rowIndex][columnIndex] = value;
        }

        /**
         * Checks for valid input value
         * @param inputValue the char value to be checked
         * @return true if input value is X, x, O, or o
         * @throws IllegalArgumentException if character is not X or O
         */
        public boolean checkInput(char inputValue) throws IllegalArgumentException {
            boolean result;
            if(inputValue == 'x' || inputValue == 'X' || inputValue == 'O' || inputValue == 'o') {
                result = true;
            } else throw new IllegalArgumentException("character is not X or O");
            return result;
        }

        /**
         * Checks if all positions have a char value
         * @return true if none of the grid locations contain the null character ('\u0000')
         */
        public boolean isFull(){
            boolean isFull = true;
            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid[row].length; column++) {
                    if (grid[row][column] == ('\u0000')) {
                        isFull = false;
                    }
                }
            }
            return isFull;
        }

        /**
         *  Check if row has all the same characters
         * @param rowIndex  the row index to check
         * @return  true if row contains the same char value
         * @throws IllegalArgumentException if an invalid row index is given
         */
        public boolean isRowMatching(int rowIndex) throws IllegalArgumentException {
            if(rowIndex < 0 || rowIndex >= 3) throw new IllegalArgumentException("row index is invalid");
            boolean result = false;
            if (grid[rowIndex][0] == grid[rowIndex][1] && grid[rowIndex][0] == grid[rowIndex][2] && grid[rowIndex][1] == grid[rowIndex][2]) {
                result = true;
            }
            return result;
        }

        /**
         * Check if column has all the same characters
         * @param columnIndex   the column index to check
         * @return  true if column contains the same char value
         * @throws IllegalArgumentException if an invalid column index is given
         */
        public boolean isColumnMatching(int columnIndex) throws IllegalArgumentException{
            if(columnIndex < 0 || columnIndex >= 3) throw new IllegalArgumentException("column index is invalid");
            boolean result = false;
            if (grid[0][columnIndex] == grid[1][columnIndex] && grid[0][columnIndex] == grid[2][columnIndex] && grid[1][columnIndex] == grid[2][columnIndex]) {
                result = true;
            }
            return result;
        }

        /**
         * Checks if either diagonal has the same characters
         * @return true if grid position 0,0; 1,1; and 2,2 are the same
         *              if grid position 2,0; 1,1; and 0,2 are the same
         */
        public boolean hasDiagonalMatch(){
            boolean result = false;
            if(grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[1][1] == grid[2][2] || grid[2][0] == grid[1][1] && grid[2][0] == grid[0][2] && grid[1][1] == grid[0][2]) {
                result = true;
            }
            return result;
        }

        /**
         * Checks if there is a character with three in a row on the grid
         * @return winning character if there is a row, column or diagonal match
         *          otherwise returns the null character
         */
        public char checkForWinner(){
            char result;
            if (grid[0][0] == grid[0][1] && grid[0][0] == grid[0][2] && grid[0][1] == grid[0][2]) {
                result = grid[0][0];
            } else if (grid[1][0] == grid[1][1] && grid[1][0] == grid[1][2] && grid[1][1] == grid[1][2]) {
                result = grid[1][1];
            } else if (grid[2][0] == grid[2][1] && grid[2][0] == grid[2][2] && grid[2][1] == grid[2][2]) {
                result = grid[2][2];
            } else if (grid[0][0] == grid[1][0] && grid[0][0] == grid[2][0] && grid[1][0] == grid[2][0]) {
                result = grid[1][0];
            } else if (grid[0][1] == grid[1][1] && grid[0][1] == grid[2][1] && grid[1][1] == grid[2][1]) {
                result = grid[0][1];
            } else if (grid[0][2] == grid[1][2] && grid[0][2] == grid[2][2] && grid[1][2] == grid[2][2]) {
                result = grid[0][2];
            } else if (grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[1][1] == grid[2][2]) {
                result = grid[2][2];
            } else if (grid[2][0] == grid[1][1] && grid[2][0] == grid[0][2] && grid[1][1] == grid[0][2]) {
                result = grid[2][0];
            }
            else {
                return '\u0000';
            }
            return result;
        }

        @Override
        /**
         * Returns a string representation of the grid with each row separated by a line
         * @return string
         */
        public String toString() {
            return (" " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + " " + '\n' + "---------" + '\n' + " " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + " " + '\n' + "---------" + '\n' + " " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2] + " " + '\n');
        }
    }
