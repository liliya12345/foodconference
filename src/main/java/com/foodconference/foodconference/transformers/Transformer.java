package com.foodconference.foodconference.transformers;

public abstract class Transformer <T,E>{
    public abstract T transform(E e);
}
