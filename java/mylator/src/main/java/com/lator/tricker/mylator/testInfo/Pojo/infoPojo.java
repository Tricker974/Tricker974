package com.lator.tricker.mylator.testInfo.Pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class infoPojo {
    private String firstName;
    private String lastName;
    private String handler;
    private Integer infoNo;
}
