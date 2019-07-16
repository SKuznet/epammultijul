package com.epam.multi.lesson1;

public // This class describes the currentLight light value and the number of the letter updates
class LightStatus {

    private Light light;
    long referencePoint;

    public LightStatus(Light light, long referencePoint) {
        this.light = light;
        this.referencePoint = referencePoint;
    }

    public String getColour() {
        return light.getColour();
    }

    public long getReferencePoint() {
        return referencePoint;
    }

    public void setLightStatus(Light light) {
        this.light = light;
    }

}
