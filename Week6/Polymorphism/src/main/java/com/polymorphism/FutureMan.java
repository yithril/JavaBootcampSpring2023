package com.polymorphism;

public class FutureMan extends Person {
    private boolean hasJetPack;
    private boolean brainIsUploaded;

    public FutureMan(String name, double height, boolean hasJetPack, boolean brainIsUploaded) {
        super(name, height);
        this.hasJetPack = hasJetPack;
        this.brainIsUploaded = brainIsUploaded;
    }

    public boolean isHasJetPack() {
        return hasJetPack;
    }

    public void setHasJetPack(boolean hasJetPack) {
        this.hasJetPack = hasJetPack;
    }

    public boolean isBrainIsUploaded() {
        return brainIsUploaded;
    }

    public void setBrainIsUploaded(boolean brainIsUploaded) {
        this.brainIsUploaded = brainIsUploaded;
    }
}
