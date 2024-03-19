package game;

public enum Token {
    Red{
        public String toString(){
            return "R";
        }
    },
    Yellow{
        public String toString(){
            return "Y";
        }
    },
    Empty {
        public String toString() {
            return " ";
        }
    }
}
