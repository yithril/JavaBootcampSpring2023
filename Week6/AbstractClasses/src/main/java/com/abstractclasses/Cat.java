package com.abstractclasses;

public class Cat extends Animal {
    private boolean isDeclawed;

    public void makeSound(){
        System.out.println("Meow!");
    }

    public boolean isDeclawed() {
        return isDeclawed;
    }

    public void setDeclawed(boolean declawed) {
        isDeclawed = declawed;
    }
}
