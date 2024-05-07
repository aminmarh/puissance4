package com.example.puissance4.game;

public enum Token {
    Red{
        public String toString(){
            return "\u001B[31m" + "R" + "\u001B[0m";
        }
    },
    Yellow{
        public String toString(){
            return "\u001B[33m" + "Y" + "\u001B[0m";
        }
    },
    Empty {
        public String toString() {
            return " ";
        }
    }
}
