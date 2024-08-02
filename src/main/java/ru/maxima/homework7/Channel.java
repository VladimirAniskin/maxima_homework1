package ru.maxima.homework7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Channel {
    private int nomer;
    private String nameCannal;
    private TVTransmission[] Transmission;
}