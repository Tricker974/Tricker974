package com.lator.tricker.mylator.number.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class NumberGuessPojo implements Serializable {
    private String version;
    private String redNum;
    private String blueNum;
}
