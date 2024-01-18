package com.gerosd.lambda;

import com.gerosd.lambda.ElectricityConsumer;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    private final List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricity(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricity(ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Выключатель включен");
        for (ElectricityConsumer c : listeners) {
            c.electricityOn(this);
        }
    }
}
