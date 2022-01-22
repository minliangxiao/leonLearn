package com.example.alip6.design_pattern.state.text;

import com.example.alip6.design_pattern.state.context.StateContext;
import com.example.alip6.design_pattern.state.service.impl.InTransitOrderState;

public class Text {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext(new InTransitOrderState());
        stateContext.switchStateOrder();
    }
}
