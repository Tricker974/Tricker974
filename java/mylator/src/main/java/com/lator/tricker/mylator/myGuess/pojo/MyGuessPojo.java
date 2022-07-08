package com.lator.tricker.mylator.myGuess.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class MyGuessPojo implements Serializable {
    private String blueList;
    private String redList;
    private String version;
    private String myRedNum;
    private String myBlueNum;
}
