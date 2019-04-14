package com.nikesh.bodymassindexbmi;

public class Calc {

    private float height,weight;


    public float calculate(){

        float calculate = (100*100*weight)/(height*height);
        return calculate;
    }


    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
