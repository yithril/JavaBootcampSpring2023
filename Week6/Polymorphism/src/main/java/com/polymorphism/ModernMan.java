package com.polymorphism;

public class ModernMan extends Person {
    private boolean hasCellPhone;

    public ModernMan(String name, double height, boolean hasCellPhone) {
        super(name, height);
        this.hasCellPhone = hasCellPhone;
    }

    @Override
    public void speak(){
        System.out.println(this.getName() + " says where's my cell phone!");
    }

    public boolean isHasCellPhone() {
        return hasCellPhone;
    }

    public void setHasCellPhone(boolean hasCellPhone) {
        this.hasCellPhone = hasCellPhone;
    }
}
