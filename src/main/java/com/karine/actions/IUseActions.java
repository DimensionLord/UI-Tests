package com.karine.actions;

public interface IUseActions {
    default Actions actions() {
        return new Actions();
    }
}
